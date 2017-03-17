package me.signatured.clashroyale.spawnable.structure.impl;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.card.annotation.GenerateCard;
import me.signatured.clashroyale.game.ClashArena;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.spawnable.ClashRarity;
import me.signatured.clashroyale.spawnable.structure.AttackStructure;

@GenerateCard(key = "STRUCTURE_X_BOW", name = "X-Bow", rarity = ClashRarity.EPIC, arena = ClashArena.ARENA_3, cost = 6)
public class XBow extends AttackStructure {

	public XBow(ClashGame game, ClashPlayer player, int level) {
		super(game, player, level, ClashRarity.RARE);
	}

	@Override
	public void tick() {
		//TODO: Attack nearby enemies
	}

	@Override
	public double getRange() {
		return 11.5;
	}

	@Override
	public int getLifetime() {
		return 40;
	}

	@Override
	public double getHitSpeed() {
		return 0.3;
	}

	@Override
	public MovementType getTargetType() {
		return MovementType.GROUND;
	}

}
