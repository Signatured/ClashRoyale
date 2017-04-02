package me.signatured.clashroyale.spawnable.npc.impl;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.arena.ArenaType;
import me.signatured.clashroyale.card.annotation.GenerateCard;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.spawnable.ClashRarity;
import me.signatured.clashroyale.spawnable.npc.SkinnedNpc;

@GenerateCard(key = "NPC_BALLOON", name = "Balloon", rarity = ClashRarity.EPIC, arena = ArenaType.ARENA_2, cost = 5)
public class Balloon extends SkinnedNpc {

	public Balloon(ClashGame game, ClashPlayer player, int level) {
		super(game, player, level);
	}

	@Override
	public double getHitSpeed() {
		return 3;
	}

	@Override
	public double getRange() {
		return -1;
	}

	@Override
	public MovementType getTargetType() {
		return null;
	}

	@Override
	public SpeedType getSpeed() {
		return SpeedType.MEDIUM;
	}

	@Override
	public MovementType getTransportType() {
		return MovementType.AIR;
	}
	
	@Override
	public int getBaseHealth() {
		return 1050;
	}
	
	@Override
	public int getBaseDamage() {
		return 600;
	}

}
