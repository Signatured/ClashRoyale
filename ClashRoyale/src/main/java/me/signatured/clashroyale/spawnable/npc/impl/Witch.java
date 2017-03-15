package me.signatured.clashroyale.spawnable.npc.impl;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.card.annotation.GenerateCard;
import me.signatured.clashroyale.game.ClashArena;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.spawnable.ClashRarity;
import me.signatured.clashroyale.spawnable.npc.ClashNpc;
import me.signatured.clashroyale.spawnable.npc.NpcType;

@GenerateCard(key = "NPC_WITCH", name = "Witch", rarity = ClashRarity.EPIC, arena = ClashArena.ARENA_1, cost = 5)
public class Witch extends ClashNpc {

	public Witch(ClashGame game, ClashPlayer player, int level) {
		super(game, player, NpcType.WITCH, level);
		flags().setAttackFlying(true);
	}

}
