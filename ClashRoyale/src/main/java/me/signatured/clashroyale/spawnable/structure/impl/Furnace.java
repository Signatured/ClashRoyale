package me.signatured.clashroyale.spawnable.structure.impl;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.card.annotation.GenerateCard;
import me.signatured.clashroyale.game.ClashArena;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.spawnable.ClashRarity;
import me.signatured.clashroyale.spawnable.npc.NpcType;
import me.signatured.clashroyale.spawnable.structure.SpawnStructure;

@GenerateCard(key = "STRUCTURE_FURNACE", name = "Furnace", rarity = ClashRarity.RARE, arena = ClashArena.ARENA_5, cost = 4)
public class Furnace extends SpawnStructure {

	public Furnace(ClashGame game, ClashPlayer player, int level) {
		super(game, player, level, ClashRarity.RARE, 50, NpcType.ARCHER, 2, 10);
	}

}
