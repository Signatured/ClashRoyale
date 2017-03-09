package me.signatured.clashroyale.entity.npc.impl;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.entity.npc.ClashNpc;
import me.signatured.clashroyale.entity.npc.NpcType;
import me.signatured.clashroyale.game.ClashGame;

public class TowerArcher extends ClashNpc {

	public TowerArcher(ClashGame game, ClashPlayer owner, int level) {
		super(game, owner, NpcType.ARENA_TOWER_NPC, level);
	}

}
