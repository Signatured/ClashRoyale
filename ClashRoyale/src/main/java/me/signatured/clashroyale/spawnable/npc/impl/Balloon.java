package me.signatured.clashroyale.spawnable.npc.impl;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.card.annotation.GenerateCard;
import me.signatured.clashroyale.game.ClashArena;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.spawnable.ClashRarity;
import me.signatured.clashroyale.spawnable.npc.ClashNpc;
import me.signatured.clashroyale.spawnable.npc.NpcType;

@GenerateCard(key = "NPC_BALLOON", name = "Balloon", rarity = ClashRarity.EPIC, arena = ClashArena.ARENA_2, cost = 5)
public class Balloon extends ClashNpc {

	public Balloon(ClashGame game, ClashPlayer player, NpcType npcType, int level) {
		super(game, player, npcType, level);
		flags().setFlying(true);
		flags().setAttackFlying(true);
	}

}
