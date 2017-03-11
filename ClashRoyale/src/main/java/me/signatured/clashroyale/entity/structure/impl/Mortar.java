package me.signatured.clashroyale.entity.structure.impl;

import org.bukkit.Location;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.entity.structure.AttackStructure;
import me.signatured.clashroyale.entity.structure.StructureType;
import me.signatured.clashroyale.game.ClashGame;

public class Mortar extends AttackStructure {

	public Mortar(ClashGame game, ClashPlayer player, Location towerLoc) {
		super(game, player, StructureType.MORTAR, towerLoc, 5);
	}

	@Override
	public void tick() {
		//TODO: Attack enemies in range
	}

}
