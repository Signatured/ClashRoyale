package me.signatured.clashroyale.spawnable.structure.impl;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.card.annotation.GenerateCard;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.game.arena.ClashArena;
import me.signatured.clashroyale.spawnable.ClashRarity;
import me.signatured.clashroyale.spawnable.structure.NpcStructure;

@GenerateCard(key = "STRUCTURE_BOMBER_TOWER", name = "Bomber Tower", rarity = ClashRarity.RARE, arena = ClashArena.ARENA_2, cost = 5)
public class BomberTower extends NpcStructure {

	public BomberTower(ClashGame game, ClashPlayer player, int level) {
		super(game, player, level, ClashRarity.RARE);
	}

	@Override
	public String getNpcKey() {
		return "NPC_BOMBER";
	}

	@Override
	public int getLifetime() {
		return 40;
	}

	@Override
	public double getRange() {
		return 6;
	}

	@Override
	public int getBaseHealth() {
		return 950;
	}

}
