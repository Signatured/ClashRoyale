package me.signatured.clashroyale.spawnable.structure.impl;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.arena.ArenaType;
import me.signatured.clashroyale.card.annotation.GenerateCard;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.spawnable.ClashRarity;
import me.signatured.clashroyale.spawnable.structure.SpawnStructure;

@GenerateCard(key = "STRUCTURE_FURNACE", name = "Furnace", rarity = ClashRarity.RARE, arena = ArenaType.ARENA_5, cost = 4)
public class Furnace extends SpawnStructure {

	public Furnace(ClashGame game, ClashPlayer player, int level) {
		super(game, player, level, ClashRarity.RARE);
	}

	@Override
	public String getNpcKey() {
		return "NPC_FIRE_SPIRIT";
	}

	@Override
	public double getSpawnSpeed() {
		return 10;
	}

	@Override
	public int getSpawnAmount() {
		return 2;
	}

	@Override
	public int getLifetime() {
		return 50;
	}

	@Override
	public int getBaseHealth() {
		return 600;
	}

}
