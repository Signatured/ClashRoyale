package me.signatured.clashroyale.spawnable.structure.impl;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.arena.ArenaType;
import me.signatured.clashroyale.card.annotation.GenerateCard;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.spawnable.ClashRarity;
import me.signatured.clashroyale.spawnable.structure.SpawnStructure;

@GenerateCard(key = "STRUCTURE_TOMBSTONE", name = "Tombstone", rarity = ClashRarity.RARE, arena = ArenaType.ARENA_2, cost = 3)
public class Tombstone extends SpawnStructure {

	public Tombstone(ClashGame game, ClashPlayer player, int level) {
		super(game, player, level, ClashRarity.RARE);
	}

	@Override
	public String getNpcKey() {
		return "NPC_SKELETON";
	}

	@Override
	public double getSpawnSpeed() {
		return 2.9;
	}

	@Override
	public int getSpawnAmount() {
		return 1;
	}

	@Override
	public int getLifetime() {
		return 40;
	}

	@Override
	public int getBaseHealth() {
		return 240;
	}

}
