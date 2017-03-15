package me.signatured.clashroyale.spawnable.npc.impl;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.card.annotation.GenerateCard;
import me.signatured.clashroyale.game.ClashArena;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.spawnable.ClashRarity;
import me.signatured.clashroyale.spawnable.npc.ClashNpc;
import me.signatured.clashroyale.spawnable.npc.NpcType;

@GenerateCard(key = "NPC_HOG_RIDER", name = "Hog Rider", rarity = ClashRarity.RARE, arena = ClashArena.ARENA_4, cost = 4)
public class HogRider extends ClashNpc {

	public HogRider(ClashGame game, ClashPlayer player, int level) {
		super(game, player, NpcType.HOG_RIDER, level);
		flags().setStructuresOnly(true);
	}

}
