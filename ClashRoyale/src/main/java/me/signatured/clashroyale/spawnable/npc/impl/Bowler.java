package me.signatured.clashroyale.spawnable.npc.impl;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.card.annotation.GenerateCard;
import me.signatured.clashroyale.game.ClashArena;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.spawnable.ClashRarity;
import me.signatured.clashroyale.spawnable.npc.ClashNpc;
import me.signatured.clashroyale.spawnable.npc.NpcType;

@GenerateCard(key = "NPC_BOWLER", name = "Bowler", rarity = ClashRarity.EPIC, arena = ClashArena.ARENA_8, cost = 5)
public class Bowler extends ClashNpc {

	public Bowler(ClashGame game, ClashPlayer player, int level) {
		super(game, player, NpcType.BOWLER, level);
	}

	@Override
	public double getHitSpeed() {
		return 2.5;
	}

	@Override
	public double getRange() {
		return 5;
	}

	@Override
	public MovementType getTargetType() {
		return MovementType.GROUND;
	}

	@Override
	public SpeedType getSpeed() {
		return SpeedType.SLOW;
	}

	@Override
	public MovementType getTransportType() {
		return MovementType.GROUND;
	}
	
	@Override
	public int getBaseHealth() {
		return 1200;
	}
	
	@Override
	public int getBaseDamage() {
		return 180;
	}

}
