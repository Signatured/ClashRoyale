package me.signatured.clashroyale.spawnable.npc.impl;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.card.annotation.GenerateCard;
import me.signatured.clashroyale.game.ClashArena;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.spawnable.ClashRarity;
import me.signatured.clashroyale.spawnable.npc.ClashNpc;
import me.signatured.clashroyale.spawnable.npc.NpcType;

@GenerateCard(key = "NPC_MEGA_MINION", name = "Mega Minion", rarity = ClashRarity.RARE, arena = ClashArena.ARENA_7, cost = 3)
public class MegaMinion extends ClashNpc {

	public MegaMinion(ClashGame game, ClashPlayer player, int level) {
		super(game, player, NpcType.MEGA_MINION, level);
		flags().setFlying(true);
		flags().setAttackFlying(true);
	}

}
