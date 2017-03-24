package me.signatured.clashroyale;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import lombok.Data;
import lombok.Getter;
import me.signatured.clashroyale.arena.ArenaType;
import me.signatured.clashroyale.card.CardDeck;
import me.signatured.clashroyale.card.ClashCard;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.game.ClashGameData;
import me.signatured.clashroyale.util.ClashUtil;
import me.signatured.clashroyale.util.Title;

@Data
public class ClashPlayer {
	
	@Getter
	private static List<ClashPlayer> players = new ArrayList<>();
	
	private String name;
	private UUID uuid;
	private ClashGame game;
	private List<ClashCard> ownedCards = new ArrayList<>();
	private CardDeck[] decks = new CardDeck[3];
	private int selectedDeck = 0;
	
	private ArenaType arena;
	private int trophies;
	
	public ClashPlayer(String name, UUID uuid) {
		this.name = name;
		this.uuid = uuid;
		
		players.add(this);
	}
	
	public static ClashPlayer getPlayer(Player player) {
		return getPlayer(player.getUniqueId());
	}
	
	public static ClashPlayer getPlayer(String name) {
		return players.stream().filter(p -> p.getName().equalsIgnoreCase(name)).findAny().orElse(null);
	}
	
	public static ClashPlayer getPlayer(UUID uuid) {
		return players.stream().filter(p -> p.getUuid().equals(uuid)).findAny().orElse(null);
	}
	
	public ClashGameData getData() {
		return game != null ? game.getData(this) : null;
	}
	
	public void teleport(Location loc) {
		if (!isOnline())
			return;
		getPlayer().teleport(loc);
	}
	
	public void title(Title title) {
		if (!isOnline())
			return;
		title.send(getPlayer());
	}
	
	public void actionbar(String message) {
		if (!isOnline())
			return;
		ClashUtil.actionbar(getPlayer(), message);
	}
	
	public void sound(Sound sound) {
		if (!isOnline())
			return;
		getPlayer().playSound(getLocation(), sound, 1f, 1f);
	}
	
	public Location getLocation() {
		if (!isOnline())
			return null;
		return getPlayer().getLocation();
	}
	
	public boolean isOnline() {
		return getPlayer() != null && getPlayer().isOnline();
	}
	
	public Player getPlayer() {
		return Bukkit.getPlayer(uuid);
	}
}
