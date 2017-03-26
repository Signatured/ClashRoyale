package me.signatured.clashroyale.spawnable.npc.impl;

import org.bukkit.entity.EntityType;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.arena.ArenaType;
import me.signatured.clashroyale.card.annotation.GenerateCard;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.spawnable.ClashRarity;
import me.signatured.clashroyale.spawnable.npc.ClashNpc;

@GenerateCard(key = "NPC_BABY_DRAGON", name = "Baby Dragon", rarity = ClashRarity.EPIC, arena = ArenaType.ARENA_1, cost = 4)
public class BabyDragon extends ClashNpc {

	public BabyDragon(ClashGame game, ClashPlayer owner, int level) {
		super(game, owner, level);
	}
	
	@Override
	public EntityType getEntityType() {
		return EntityType.PLAYER;
	}

	@Override
	public double getHitSpeed() {
		return 1.6;
	}

	@Override
	public double getRange() {
		return 3.5;
	}

	@Override
	public MovementType getTargetType() {
		return MovementType.AIR_AND_GROUND;
	}

	@Override
	public SpeedType getSpeed() {
		return SpeedType.FAST;
	}

	@Override
	public MovementType getTransportType() {
		return MovementType.AIR;
	}

	@Override
	public int getBaseHealth() {
		return 800;
	}
	
	@Override
	public int getBaseDamage() {
		return 100;
	}

}
