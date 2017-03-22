package me.signatured.clashroyale.spawnable.npc.impl;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.arena.ArenaType;
import me.signatured.clashroyale.card.annotation.GenerateCard;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.spawnable.ClashRarity;
import me.signatured.clashroyale.spawnable.npc.ClashNpc;

@GenerateCard(key = "NPC_LUMBERJACK", name = "Lumberjack", rarity = ClashRarity.LEGENDARY, arena = ArenaType.ARENA_8, cost = 4)
public class Lumberjack extends ClashNpc {

	public Lumberjack(ClashGame game, ClashPlayer player, int level) {
		super(game, player, level);
	}

	@Override
	public double getHitSpeed() {
		return 0.7;
	}

	@Override
	public double getRange() {
		return -1;
	}

	@Override
	public MovementType getTargetType() {
		return MovementType.GROUND;
	}

	@Override
	public SpeedType getSpeed() {
		return SpeedType.VERY_FAST;
	}

	@Override
	public MovementType getTransportType() {
		return MovementType.GROUND;
	}
	
	@Override
	public int getBaseHealth() {
		return 950;
	}
	
	@Override
	public int getBaseDamage() {
		return 200;
	}

}
