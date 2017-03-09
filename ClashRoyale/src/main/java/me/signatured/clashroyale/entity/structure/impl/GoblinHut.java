package me.signatured.clashroyale.entity.structure.impl;

import org.bukkit.Location;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.entity.npc.NpcType;
import me.signatured.clashroyale.entity.structure.SpawnStructure;
import me.signatured.clashroyale.entity.structure.StructureType;
import me.signatured.clashroyale.game.ClashGame;

public class GoblinHut extends SpawnStructure {

	public GoblinHut(ClashGame game, ClashPlayer player, Location towerLoc, Location spawnLoc) {
		super(game, player, StructureType.GOBLIN_HUT, towerLoc, NpcType.ARCHER, spawnLoc, 1, 5);
	}
}
