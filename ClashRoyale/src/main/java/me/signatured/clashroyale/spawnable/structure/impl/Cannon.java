package me.signatured.clashroyale.spawnable.structure.impl;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.arena.ArenaType;
import me.signatured.clashroyale.card.annotation.GenerateCard;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.spawnable.ClashRarity;
import me.signatured.clashroyale.spawnable.structure.AttackStructure;
import me.signatured.clashroyale.spawnable.types.IAttackStructure;

@GenerateCard(key = "STRUCTURE_CANNON", name = "Cannon", rarity = ClashRarity.COMMON, arena = ArenaType.ARENA_3, cost = 3)
public class Cannon extends AttackStructure implements IAttackStructure {

	public Cannon(ClashGame game, ClashPlayer player, int level) {
		super(game, player, level, ClashRarity.COMMON);
	}

	@Override
	public void tick() {
		//TODO: Point and shoot at nearest NPC
	}

	@Override
	public int getLifetime() {
		return 30;
	}

	@Override
	public double getRange() {
		return 5.5;
	}

	@Override
	public double getHitSpeed() {
		return 0.8;
	}

	@Override
	public MovementType getTargetType() {
		return MovementType.GROUND;
	}

	@Override
	public int getBaseHealth() {
		return 350;
	}

	@Override
	public int getBaseDamage() {
		return 60;
	}

}
