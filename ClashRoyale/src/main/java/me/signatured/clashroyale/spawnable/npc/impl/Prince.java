package me.signatured.clashroyale.spawnable.npc.impl;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.card.annotation.GenerateCard;
import me.signatured.clashroyale.game.ClashArena;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.spawnable.ClashRarity;
import me.signatured.clashroyale.spawnable.npc.ClashNpc;
import me.signatured.clashroyale.spawnable.npc.NpcType;

@GenerateCard(key = "NPC_PRINCE", name = "Prince", rarity = ClashRarity.EPIC, arena = ClashArena.ARENA_1, cost = 5)
public class Prince extends ClashNpc {

	public Prince(ClashGame game, ClashPlayer player, int level) {
		super(game, player, NpcType.PRINCE, level);
	}

}
