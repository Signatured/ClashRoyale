package me.signatured.clashroyale.spawnable.npc.impl;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.card.annotation.GenerateCard;
import me.signatured.clashroyale.game.ClashArena;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.spawnable.ClashRarity;
import me.signatured.clashroyale.spawnable.npc.ClashNpc;
import me.signatured.clashroyale.spawnable.npc.NpcType;

@GenerateCard(key = "NPC_ARCHER", name = "Archer", rarity = ClashRarity.COMMON, arena = ClashArena.ARENA_1, cost = 3)
public class Archer extends ClashNpc{

	public Archer(ClashGame game, ClashPlayer owner, int level) {
		super(game, owner, NpcType.ARCHER, level);
	}

	@Override
	public double getHitSpeed() {
		return 1.2;
	}

	@Override
	public double getRange() {
		return 5;
	}

	@Override
	public MovementType getTargetType() {
		return MovementType.AIR_AND_GROUND;
	}

	@Override
	public SpeedType getSpeed() {
		return SpeedType.MEDIUM;
	}

	@Override
	public MovementType getTransportType() {
		return MovementType.GROUND;
	}

	@Override
	public int getBaseHealth() {
		return 120;
	}
	
	@Override
	public int getBaseDamage() {
		return 41;
	}

}
