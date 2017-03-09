package me.signatured.clashroyale.entity.npc.impl;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.entity.npc.ClashNpc;
import me.signatured.clashroyale.entity.npc.NpcType;
import me.signatured.clashroyale.game.ClashGame;

public class TowerKing extends ClashNpc {

	public TowerKing(ClashGame game, ClashPlayer owner, int level) {
		super(game, owner, NpcType.KING_TOWER_NPC, level);
	}

}
