package me.signatured.clashroyale.spawnable.structure.impl;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.card.annotation.GenerateCard;
import me.signatured.clashroyale.game.ClashArena;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.spawnable.ClashRarity;
import me.signatured.clashroyale.spawnable.structure.AttackStructure;

@GenerateCard(key = "STRUCTURE_CANNON", name = "Cannon", rarity = ClashRarity.COMMON, arena = ClashArena.ARENA_3, cost = 3)
public class Cannon extends AttackStructure {

	public Cannon(ClashGame game, ClashPlayer player, int level) {
		super(game, player, level, ClashRarity.COMMON, 30, 5);
	}

	@Override
	public void tick() {
		//TODO: Point and shoot at nearest NPC
	}

}
