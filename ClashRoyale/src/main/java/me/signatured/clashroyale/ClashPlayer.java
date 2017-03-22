package me.signatured.clashroyale;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.entity.Player;

import lombok.Data;
import lombok.Getter;
import me.signatured.clashroyale.arena.ArenaType;
import me.signatured.clashroyale.card.CardDeck;
import me.signatured.clashroyale.card.ClashCard;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.game.ClashGameData;

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
}
