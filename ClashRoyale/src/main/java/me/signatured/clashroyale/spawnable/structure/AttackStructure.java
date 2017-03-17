package me.signatured.clashroyale.spawnable.structure;

import org.bukkit.Location;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.spawnable.ClashRarity;
import me.signatured.clashroyale.spawnable.types.IAttackStructure;

public abstract class AttackStructure extends ClashStructure implements IAttackStructure {
	
	public AttackStructure(ClashGame game, ClashPlayer player, int level, ClashRarity rarity) {
		super(game, player, level, rarity);
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
