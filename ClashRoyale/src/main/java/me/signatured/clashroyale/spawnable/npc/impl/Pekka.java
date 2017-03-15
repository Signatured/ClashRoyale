package me.signatured.clashroyale.spawnable.npc.impl;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.card.annotation.GenerateCard;
import me.signatured.clashroyale.game.ClashArena;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.spawnable.ClashRarity;
import me.signatured.clashroyale.spawnable.npc.ClashNpc;
import me.signatured.clashroyale.spawnable.npc.NpcType;

@GenerateCard(key = "NPC_PEKKA", name = "P.E.K.K.A.", rarity = ClashRarity.EPIC, arena = ClashArena.ARENA_4, cost = 7)
public class Pekka extends ClashNpc {

	public Pekka(ClashGame game, ClashPlayer player, int level) {
		super(game, player, NpcType.PEKKA, level);
	}

}
