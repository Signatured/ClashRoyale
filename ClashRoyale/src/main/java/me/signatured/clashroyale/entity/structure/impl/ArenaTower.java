package me.signatured.clashroyale.entity.structure.impl;

import org.bukkit.Location;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.entity.npc.NpcType;
import me.signatured.clashroyale.entity.structure.NpcStructure;
import me.signatured.clashroyale.entity.structure.StructureType;
import me.signatured.clashroyale.game.ClashGame;

public class ArenaTower extends NpcStructure {

	public ArenaTower(ClashGame game, ClashPlayer player, Location towerLoc, Location npcLoc) {
		super(game, player, StructureType.ARENA_TOWER, towerLoc, NpcType.ARENA_TOWER_NPC, npcLoc);
	}

}
