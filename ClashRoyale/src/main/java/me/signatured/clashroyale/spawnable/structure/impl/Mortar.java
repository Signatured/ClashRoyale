package me.signatured.clashroyale.spawnable.structure.impl;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.card.annotation.GenerateCard;
import me.signatured.clashroyale.game.ClashArena;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.spawnable.ClashRarity;
import me.signatured.clashroyale.spawnable.structure.AttackStructure;

@GenerateCard(key = "STRUCTURE_MORTAR", name = "Mortar", rarity = ClashRarity.COMMON, arena = ClashArena.ARENA_6, cost = 4)
public class Mortar extends AttackStructure {

	public Mortar(ClashGame game, ClashPlayer player, int level) {
		super(game, player, level, ClashRarity.RARE, 40, 5);
	}

	@Override
	public void tick() {
		//TODO: Attack enemies in range
	}

}
