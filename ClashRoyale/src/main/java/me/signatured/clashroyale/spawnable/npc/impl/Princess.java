package me.signatured.clashroyale.spawnable.npc.impl;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.card.annotation.GenerateCard;
import me.signatured.clashroyale.game.ClashArena;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.spawnable.ClashRarity;
import me.signatured.clashroyale.spawnable.npc.ClashNpc;
import me.signatured.clashroyale.spawnable.npc.NpcType;

@GenerateCard(key = "NPC_PRINCESS", name = "Princess", rarity = ClashRarity.LEGENDARY, arena = ClashArena.ARENA_7, cost = 3)
public class Princess extends ClashNpc {

	public Princess(ClashGame game, ClashPlayer player, int level) {
		super(game, player, NpcType.PRINCESS, level);
		flags().setAttackFlying(true);
	}

}
