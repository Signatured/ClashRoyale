package me.signatured.clashroyale.spawnable.npc.impl;

import org.bukkit.entity.EntityType;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.arena.ArenaType;
import me.signatured.clashroyale.card.annotation.GenerateCard;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.spawnable.ClashRarity;
import me.signatured.clashroyale.spawnable.npc.ClashNpc;

@GenerateCard(key = "NPC_GIANT_SKELETON", name = "Giant Skeleton", rarity = ClashRarity.EPIC, arena = ArenaType.ARENA_2, cost = 6)
public class GiantSkeleton extends ClashNpc {

	public GiantSkeleton(ClashGame game, ClashPlayer player, int level) {
		super(game, player, level);
	}
	
	@Override
	public EntityType getEntityType() {
		return EntityType.PLAYER;
	}

	@Override
	public double getHitSpeed() {
		return 1.5;
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
		return SpeedType.MEDIUM;
	}

	@Override
	public MovementType getTransportType() {
		return MovementType.GROUND;
	}
	
	@Override
	public int getBaseHealth() {
		return 2000;
	}
	
	@Override
	public int getBaseDamage() {
		return 130;
	}

}
