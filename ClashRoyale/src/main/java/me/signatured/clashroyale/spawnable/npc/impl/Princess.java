package me.signatured.clashroyale.spawnable.npc.impl;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.arena.ArenaType;
import me.signatured.clashroyale.card.annotation.GenerateCard;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.spawnable.ClashRarity;
import me.signatured.clashroyale.spawnable.npc.SkinnedNpc;

@GenerateCard(key = "NPC_PRINCESS", name = "Princess", rarity = ClashRarity.LEGENDARY, arena = ArenaType.ARENA_7, cost = 3)
public class Princess extends SkinnedNpc {

	public Princess(ClashGame game, ClashPlayer player, int level) {
		super(game, player, level);
	}

	@Override
	public double getHitSpeed() {
		return 3;
	}

	@Override
	public double getRange() {
		return 9;
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
		return 216;
	}
	
	@Override
	public int getBaseDamage() {
		return 140;
	}

}
