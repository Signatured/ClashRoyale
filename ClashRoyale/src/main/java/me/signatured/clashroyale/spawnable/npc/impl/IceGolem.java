package me.signatured.clashroyale.spawnable.npc.impl;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.card.annotation.GenerateCard;
import me.signatured.clashroyale.game.ClashArena;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.spawnable.ClashRarity;
import me.signatured.clashroyale.spawnable.npc.ClashNpc;
import me.signatured.clashroyale.spawnable.npc.NpcType;

@GenerateCard(key = "NPC_ICE_GOLEM", name = "Ice Golem", rarity = ClashRarity.RARE, arena = ClashArena.ARENA_8, cost = 2)
public class IceGolem extends ClashNpc {

	public IceGolem(ClashGame game, ClashPlayer player, int level) {
		super(game, player, NpcType.ICE_GOLEM, level);
		flags().setStructuresOnly(true);
	}

}
