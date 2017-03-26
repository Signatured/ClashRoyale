package me.signatured.clashroyale.spawnable.npc.impl;

import org.bukkit.entity.EntityType;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.card.annotation.GenerateCard;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.spawnable.npc.ClashNpc;

@GenerateCard(key = "NPC_TOWER_KING", name = "Tower King", real = false)
public class TowerKing extends ClashNpc {
	
	public TowerKing(ClashGame game, ClashPlayer owner, int level) {
		super(game, owner, level);
	}
	
	@Override
	public EntityType getEntityType() {
		return EntityType.PLAYER;
	}

	@Override
	public double getHitSpeed() {
		return 1;
	}

	@Override
	public double getRange() {
		return 7;
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
		return 0.7;
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
