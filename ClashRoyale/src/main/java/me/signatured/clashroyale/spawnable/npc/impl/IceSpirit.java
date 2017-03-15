package me.signatured.clashroyale.spawnable.npc.impl;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.card.annotation.GenerateCard;
import me.signatured.clashroyale.game.ClashArena;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.spawnable.ClashRarity;
import me.signatured.clashroyale.spawnable.npc.ClashNpc;
import me.signatured.clashroyale.spawnable.npc.NpcType;

@GenerateCard(key = "NPC_ICE_SPIRIT", name = "Ice Spirit", rarity = ClashRarity.COMMON, arena = ClashArena.ARENA_8, cost = 1)
public class IceSpirit extends ClashNpc {

	public IceSpirit(ClashGame game, ClashPlayer player, int level) {
		super(game, player, NpcType.ICE_SPIRIT, level);
		flags().setAttackFlying(true);
	}

}
