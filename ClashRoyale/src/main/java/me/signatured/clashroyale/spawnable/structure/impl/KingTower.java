package me.signatured.clashroyale.spawnable.structure.impl;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.spawnable.ClashRarity;
import me.signatured.clashroyale.spawnable.npc.NpcType;
import me.signatured.clashroyale.spawnable.structure.NpcStructure;

public class KingTower extends NpcStructure {

	public KingTower(ClashGame game, ClashPlayer player, int level) {
		super(game, player, level, ClashRarity.COMMON, -1, NpcType.KING_TOWER_NPC);
	}

}
