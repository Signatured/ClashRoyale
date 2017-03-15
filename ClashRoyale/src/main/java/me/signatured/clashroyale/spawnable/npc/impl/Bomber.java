package me.signatured.clashroyale.spawnable.npc.impl;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.card.annotation.GenerateCard;
import me.signatured.clashroyale.game.ClashArena;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.spawnable.ClashRarity;
import me.signatured.clashroyale.spawnable.npc.ClashNpc;
import me.signatured.clashroyale.spawnable.npc.NpcType;

@GenerateCard(key = "NPC_BOMBER", name = "Bomber", rarity = ClashRarity.COMMON, arena = ClashArena.ARENA_1, cost = 3)
public class Bomber extends ClashNpc {

	public Bomber(ClashGame game, ClashPlayer player, int level) {
		super(game, player, NpcType.BOMBER, level);
	}

}
