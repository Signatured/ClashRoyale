package me.signatured.clashroyale.spawnable.npc.impl;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.card.annotation.GenerateCard;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.spawnable.npc.ClashNpc;
import me.signatured.clashroyale.spawnable.npc.NpcType;

@GenerateCard(key = "NPC_MINI_GOLEM", name = "Mini Golem", real = false)
public class MiniGolem extends ClashNpc {

	public MiniGolem(ClashGame game, ClashPlayer player, int level) {
		super(game, player, NpcType.MINI_GOLEM, level);
		flags().setStructuresOnly(true);
	}

}
