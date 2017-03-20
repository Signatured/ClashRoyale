package me.signatured.clashroyale.spawnable.structure.impl;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.card.annotation.GenerateCard;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.game.arena.ClashArena;
import me.signatured.clashroyale.spawnable.ClashRarity;
import me.signatured.clashroyale.spawnable.structure.AttackStructure;

@GenerateCard(key = "STRUCTURE_INFERNO_TOWER", name = "Inferno Tower", rarity = ClashRarity.RARE, arena = ClashArena.ARENA_4, cost = 5)
public class InfernoTower extends AttackStructure {

	public InfernoTower(ClashGame game, ClashPlayer player, int level) {
		super(game, player, level, ClashRarity.RARE);
	}

	@Override
	public void tick() {
		//TODO: Attack nearby enemies in range
	}

	@Override
	public double getRange() {
		return 6;
	}

	@Override
	public int getLifetime() {
		return 40;
	}

	@Override
	public double getHitSpeed() {
		return 0.4;
	}

	@Override
	public MovementType getTargetType() {
		return MovementType.AIR_AND_GROUND;
	}

	@Override
	public int getBaseHealth() {
		return 800;
	}

	@Override
	public int getBaseDamage() {
		return 20;
	}

}
