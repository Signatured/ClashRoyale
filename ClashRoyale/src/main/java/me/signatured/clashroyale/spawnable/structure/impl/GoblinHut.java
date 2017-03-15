package me.signatured.clashroyale.spawnable.structure.impl;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.card.annotation.GenerateCard;
import me.signatured.clashroyale.game.ClashArena;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.spawnable.ClashRarity;
import me.signatured.clashroyale.spawnable.npc.NpcType;
import me.signatured.clashroyale.spawnable.structure.SpawnStructure;

@GenerateCard(key = "STRUCTURE_GOBLIN_HUT", name = "Goblin Hut", rarity = ClashRarity.RARE, arena = ClashArena.ARENA_1, cost = 5)
public class GoblinHut extends SpawnStructure {

	public GoblinHut(ClashGame game, ClashPlayer player, int level) {
		super(game, player, level, ClashRarity.RARE, 60, NpcType.ARCHER, 1, 5);
	}
}
