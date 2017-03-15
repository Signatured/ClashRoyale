package me.signatured.clashroyale.spawnable.structure;

import org.bukkit.Location;

import lombok.Getter;
import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.spawnable.ClashRarity;

@Getter
public abstract class AttackStructure extends ClashStructure {
	
	private int range;

	public AttackStructure(ClashGame game, ClashPlayer player, int level, ClashRarity rarity, int lifeTime, int range) {
		super(game, player, level, rarity, lifeTime);
		this.range = range;
	}

	@Override
	public void spawn(Location loc) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void despawn() {
		
	}

	@Override
	public void onDeath() {
		
	}

}
