package me.signatured.clashroyale.spawnable.npc.impl;

import org.bukkit.entity.EntityType;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.card.annotation.GenerateCard;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.spawnable.npc.ClashNpc;

@GenerateCard(key = "NPC_GOLEMITE", name = "Golemite", real = false)
public class Golemite extends ClashNpc {

	public Golemite(ClashGame game, ClashPlayer player, int level) {
		super(game, player, level);
	}
	
	@Override
	public EntityType getEntityType() {
		return EntityType.SNOWMAN;
	}

	@Override
	public double getHitSpeed() {
		return 2.5;
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
		return SpeedType.SLOW;
	}

	@Override
	public MovementType getTransportType() {
		return MovementType.GROUND;
	}
	
	@Override
	public int getBaseHealth() {
		return 650;
	}
	
	@Override
	public int getBaseDamage() {
		return 40;
	}

}
