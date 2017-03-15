package me.signatured.clashroyale.spawnable.structure.impl;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.card.annotation.GenerateCard;
import me.signatured.clashroyale.game.ClashArena;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.spawnable.ClashRarity;
import me.signatured.clashroyale.spawnable.structure.AttackStructure;

@GenerateCard(key = "STRUCTURE_TESLA", name = "Tesla", rarity = ClashRarity.COMMON, arena = ClashArena.ARENA_4, cost = 4)
public class Tesla extends AttackStructure {

	public Tesla(ClashGame game, ClashPlayer player, int level) {
		super(game, player, level, ClashRarity.RARE, 40, 5);
	}

	@Override
	public void tick() {
		//TODO: Attack nearby enemies
	}

}
