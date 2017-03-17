package me.signatured.clashroyale.spawnable.structure.impl;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.card.annotation.GenerateCard;
import me.signatured.clashroyale.game.ClashArena;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.spawnable.ClashRarity;
import me.signatured.clashroyale.spawnable.structure.SpawnStructure;

@GenerateCard(key = "STRUCTURE_FURNACE", name = "Furnace", rarity = ClashRarity.RARE, arena = ClashArena.ARENA_5, cost = 4)
public class Furnace extends SpawnStructure {

	public Furnace(ClashGame game, ClashPlayer player, int level) {
		super(game, player, level, ClashRarity.RARE);
	}

	@Override
	public int getLifetime() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getRange() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public SpawnableType getSpawnableType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getNpcKey() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getSpawnSpeed() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getSpawnAmount() {
		// TODO Auto-generated method stub
		return 0;
	}

}
