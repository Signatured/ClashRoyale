package me.signatured.clashroyale.entity.structure.impl;

import org.bukkit.Location;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.entity.structure.ClashStructure;
import me.signatured.clashroyale.entity.structure.StructureType;
import me.signatured.clashroyale.game.ClashGame;

public class Cannon extends ClashStructure {

	public Cannon(ClashGame game, ClashPlayer player, Location towerLoc) {
		super(game, player, StructureType.CANNON, towerLoc);
	}

	@Override
	public void spawn() {
		//TODO: Load schematic
	}
	
	@Override
	public void despawn() {
		
	}

	@Override
	public void tick() {
		//TODO: Point and shoot at nearest NPC
	}

}
