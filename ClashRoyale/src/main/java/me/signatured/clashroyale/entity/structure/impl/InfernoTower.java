package me.signatured.clashroyale.entity.structure.impl;

import org.bukkit.Location;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.entity.structure.ClashStructure;
import me.signatured.clashroyale.entity.structure.StructureType;
import me.signatured.clashroyale.game.ClashGame;

public class InfernoTower extends ClashStructure {

	public InfernoTower(ClashGame game, ClashPlayer player, Location towerLoc) {
		super(game, player, StructureType.INFERNO_TOWER, towerLoc);
	}

	@Override
	public void spawn() {
		
	}
	
	@Override
	public void despawn() {
		
	}

	@Override
	public void tick() {
		//TODO: Attack nearby enemies in range
	}

}
