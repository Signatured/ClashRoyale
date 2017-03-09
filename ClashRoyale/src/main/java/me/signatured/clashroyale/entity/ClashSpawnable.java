package me.signatured.clashroyale.entity;

import lombok.Getter;
import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.game.ClashGame;

@Getter
public abstract class ClashSpawnable {
	
	private ClashGame game;
	private ClashPlayer player;
	
	public ClashSpawnable(ClashGame game, ClashPlayer player) {
		this.game = game;
		this.player = player;
	}
	
	public abstract void spawn();
	public abstract void despawn();
	public abstract void tick();
}
