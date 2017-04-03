package me.signatured.clashroyale.spawnable;

import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;

import lombok.Getter;
import lombok.Setter;
import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.arena.ArenaData;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.game.ClashGameData;
import me.signatured.clashroyale.mechanics.SkinData;

@Getter
public abstract class ClashSpawnable {
	
	@Setter
	private String key;
	@Setter
	private String name;
	private ClashGame game;
	private ClashPlayer player;
	private int level;
	
	public ClashSpawnable(ClashGame game, ClashPlayer player, int level) {
		this.game = game;
		this.player = player;
		this.level = level;
	}
	
	public ClashGameData getGameData() {
		return player.getData();
	}
	
	public float getFacingYaw() {
		ArenaData arenaData = game.getData(player).getData();
		return arenaData.getYaw();
	}
	
	public ItemStack getSkinnedHead() {
		SkinData skinData = SkinData.getData(key);
		
		if (skinData == null)
			return null;
		
		return skinData.getSkull();
	}
	
	public abstract void spawn(Location loc);
	public abstract void despawn();
	public abstract void tick();
}
