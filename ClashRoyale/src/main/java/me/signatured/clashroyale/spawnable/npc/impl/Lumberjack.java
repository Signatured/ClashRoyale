package me.signatured.clashroyale.spawnable.npc.impl;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.card.annotation.GenerateCard;
import me.signatured.clashroyale.game.ClashArena;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.spawnable.ClashRarity;
import me.signatured.clashroyale.spawnable.npc.ClashNpc;
import me.signatured.clashroyale.spawnable.npc.NpcType;

@GenerateCard(key = "NPC_LUMBERJACK", name = "Lumberjack", rarity = ClashRarity.LEGENDARY, arena = ClashArena.ARENA_8, cost = 4)
public class Lumberjack extends ClashNpc {

	public Lumberjack(ClashGame game, ClashPlayer player, int level) {
		super(game, player, NpcType.LUMBERJACK, level);
	}

}
