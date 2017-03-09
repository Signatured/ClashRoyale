package me.signatured.clashroyale.entity.structure.impl;

import org.bukkit.Location;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.entity.npc.NpcType;
import me.signatured.clashroyale.entity.structure.SpawnStructure;
import me.signatured.clashroyale.entity.structure.StructureType;
import me.signatured.clashroyale.game.ClashGame;

public class BarbarianHut extends SpawnStructure {

	public BarbarianHut(ClashGame game, ClashPlayer player, Location towerLoc, Location spawnLoc) {
		super(game, player, StructureType.BARBARIAN_HUT, towerLoc, NpcType.ARCHER, spawnLoc, 2, 14);
	}

}
