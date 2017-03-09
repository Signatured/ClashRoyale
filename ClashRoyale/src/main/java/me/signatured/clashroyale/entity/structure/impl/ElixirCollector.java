package me.signatured.clashroyale.entity.structure.impl;

import org.bukkit.Location;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.entity.structure.ClashStructure;
import me.signatured.clashroyale.entity.structure.StructureType;
import me.signatured.clashroyale.game.ClashGame;

public class ElixirCollector extends ClashStructure {

	public ElixirCollector(ClashGame game, ClashPlayer player, Location towerLoc) {
		super(game, player, StructureType.ELIXER_COLLECTOR, towerLoc);
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
		//TODO: Give elixer when time
	}

}
