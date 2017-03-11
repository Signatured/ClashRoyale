package me.signatured.clashroyale.entity.structure;

import org.bukkit.Location;

import lombok.Getter;
import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.game.ClashGame;

@Getter
public abstract class AttackStructure extends ClashStructure {
	
	private int range;

	public AttackStructure(ClashGame game, ClashPlayer player, StructureType structureType, Location loc, int range) {
		super(game, player, structureType, loc);
		this.range = range;
	}

	@Override
	public void spawn() {
		
	}

	@Override
	public void despawn() {
		
	}

	@Override
	public void onDeath() {
		
	}

}
