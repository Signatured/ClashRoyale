package me.signatured.clashroyale.entity.structure.impl;

import org.bukkit.Location;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.entity.npc.NpcType;
import me.signatured.clashroyale.entity.structure.NpcStructure;
import me.signatured.clashroyale.entity.structure.StructureType;
import me.signatured.clashroyale.game.ClashGame;

public class KingTower extends NpcStructure {

	public KingTower(ClashGame game, ClashPlayer player, Location towerLoc, Location npcLoc) {
		super(game, player, StructureType.KING_TOWER, towerLoc, NpcType.KING_TOWER_NPC, npcLoc);
	}

}
