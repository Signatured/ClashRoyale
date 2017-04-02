package me.signatured.clashroyale.spawnable.npc.impl;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.arena.ArenaType;
import me.signatured.clashroyale.card.annotation.GenerateCard;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.spawnable.ClashRarity;
import me.signatured.clashroyale.spawnable.npc.SkinnedNpc;

@GenerateCard(key = "NPC_EXECUTIONER", name = "Executioner", rarity = ClashRarity.EPIC, arena = ArenaType.ARENA_9, cost = 5)
public class Executioner extends SkinnedNpc {

	public Executioner(ClashGame game, ClashPlayer player, int level) {
		super(game, player, level);
	}

	@Override
	public double getHitSpeed() {
		return 2.4;
	}

	@Override
	public double getRange() {
		return 4.5;
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
		return 760;
	}
	
	@Override
	public int getBaseDamage() {
		return 100;
	}

}
