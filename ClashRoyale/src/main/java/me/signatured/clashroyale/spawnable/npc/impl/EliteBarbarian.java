package me.signatured.clashroyale.spawnable.npc.impl;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.card.annotation.GenerateCard;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.spawnable.npc.ClashNpc;
import me.signatured.clashroyale.spawnable.npc.NpcType;

@GenerateCard(key = "NPC_ELITE_BARBARIAN", name = "Elite Barbarian", real = false)
public class EliteBarbarian extends ClashNpc {

	public EliteBarbarian(ClashGame game, ClashPlayer player, int level) {
		super(game, player, NpcType.ELITE_BARBARIAN, level);
	}

}
