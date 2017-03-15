package me.signatured.clashroyale.spawnable.npc.impl;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.card.annotation.GenerateCard;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.spawnable.npc.ClashNpc;
import me.signatured.clashroyale.spawnable.npc.NpcType;

@GenerateCard(key = "NPC_TOWER_KING", name = "Tower King", real = false)
public class TowerKing extends ClashNpc {

	public TowerKing(ClashGame game, ClashPlayer owner, int level) {
		super(game, owner, NpcType.KING_TOWER_NPC, level);
	}

}
