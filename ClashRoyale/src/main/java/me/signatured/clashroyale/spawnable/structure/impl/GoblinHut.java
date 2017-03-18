package me.signatured.clashroyale.spawnable.structure.impl;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.card.annotation.GenerateCard;
import me.signatured.clashroyale.game.ClashArena;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.spawnable.ClashRarity;
import me.signatured.clashroyale.spawnable.structure.SpawnStructure;

@GenerateCard(key = "STRUCTURE_GOBLIN_HUT", name = "Goblin Hut", rarity = ClashRarity.RARE, arena = ClashArena.ARENA_1, cost = 5)
public class GoblinHut extends SpawnStructure {

	public GoblinHut(ClashGame game, ClashPlayer player, int level) {
		super(game, player, level, ClashRarity.RARE);
	}

	@Override
	public String getNpcKey() {
		return "NPC_GOBLIN";
	}

	@Override
	public double getSpawnSpeed() {
		return 4.9;
	}

	@Override
	public int getSpawnAmount() {
		return 1;
	}

	@Override
	public int getLifetime() {
		return 60;
	}

	@Override
	public int getBaseHealth() {
		return 700;
	}
}
