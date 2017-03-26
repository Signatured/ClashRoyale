package me.signatured.clashroyale.spawnable;

import org.bukkit.Location;

import lombok.Getter;
import lombok.Setter;
import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.game.ClashGameData;

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
	
	public abstract void spawn(Location loc);
	public abstract void despawn();
	public abstract void tick();
}
