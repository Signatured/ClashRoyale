package me.signatured.clashroyale.spawnable.npc.impl;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.card.annotation.GenerateCard;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.spawnable.npc.ClashNpc;
import me.signatured.clashroyale.spawnable.npc.NpcType;

@GenerateCard(key = "NPC_BARBARIAN", name = "Barbarian", real = false)
public class Barbarian extends ClashNpc {

	public Barbarian(ClashGame game, ClashPlayer player, int level) {
		super(game, player, NpcType.BARBARIAN, level);
	}

}
