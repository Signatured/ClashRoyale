package me.signatured.clashroyale.entity.structure.impl;

import org.bukkit.Location;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.entity.npc.NpcType;
import me.signatured.clashroyale.entity.structure.NpcStructure;
import me.signatured.clashroyale.entity.structure.StructureType;
import me.signatured.clashroyale.game.ClashGame;

public class BomberTower extends NpcStructure {

	public BomberTower(ClashGame game, ClashPlayer player, Location towerLoc, Location npcLoc) {
		super(game, player, StructureType.BOMBER_TOWER, towerLoc, NpcType.ARCHER, npcLoc);
	}

}
