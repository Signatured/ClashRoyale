package me.signatured.clashroyale.spawnable.npc.impl;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.card.annotation.GenerateCard;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.spawnable.npc.ClashNpc;
import me.signatured.clashroyale.spawnable.npc.NpcType;

@GenerateCard(key = "NPC_TOWER_ARCHER", name = "Tower Archer", real = false)
public class TowerArcher extends ClashNpc {
	
	public TowerArcher(ClashGame game, ClashPlayer owner, int level) {
		super(game, owner, NpcType.ARENA_TOWER_NPC, level);
	}

	@Override
	public double getHitSpeed() {
		return 0.8;
	}

	@Override
	public double getRange() {
		return 7.5;
	}

	@Override
	public MovementType getTargetType() {
		return MovementType.AIR_AND_GROUND;
	}

	@Override
	public SpeedType getSpeed() {
		return null;
	}

	@Override
	public MovementType getTransportType() {
		return null;
	}
	
	@Override
	public double getLevelMultiplier() {
		return 0.08;
	}
	
	@Override
	public int getBaseHealth() {
		return -1;
	}
	
	@Override
	public int getBaseDamage() {
		return 50;
	}

}
