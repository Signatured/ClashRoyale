package me.signatured.clashroyale.spawnable.structure.impl;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.card.annotation.GenerateCard;
import me.signatured.clashroyale.game.ClashArena;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.spawnable.ClashRarity;
import me.signatured.clashroyale.spawnable.structure.SpawnStructure;

@GenerateCard(key = "STRUCTURE_BARBARIAN_HUT", name = "Barbarian Hut", rarity = ClashRarity.RARE, arena = ClashArena.ARENA_3, cost = 7)
public class BarbarianHut extends SpawnStructure {

	public BarbarianHut(ClashGame game, ClashPlayer player, int level) {
		super(game, player, level, ClashRarity.RARE);
	}

	@Override
	public int getLifetime() {
		return 60;
	}

	@Override
	public String getNpcKey() {
		return "NPC_BARBARIAN";
	}

	@Override
	public double getSpawnSpeed() {
		return 14;
	}

	@Override
	public int getSpawnAmount() {
		return 2;
	}

}
