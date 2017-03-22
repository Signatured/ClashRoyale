package me.signatured.clashroyale.spawnable.npc.impl;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.arena.ArenaType;
import me.signatured.clashroyale.card.annotation.GenerateCard;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.spawnable.ClashRarity;
import me.signatured.clashroyale.spawnable.npc.ClashNpc;

@GenerateCard(key = "NPC_WIZARD", name = "Wizard", rarity = ClashRarity.RARE, arena = ArenaType.ARENA_5, cost = 5)
public class Wizard extends ClashNpc {

	public Wizard(ClashGame game, ClashPlayer player, int level) {
		super(game, player, level);
	}

	@Override
	public double getHitSpeed() {
		return 1.4;
	}

	@Override
	public double getRange() {
		return 5.5;
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
		return 340;
	}
	
	@Override
	public int getBaseDamage() {
		return 130;
	}

}
