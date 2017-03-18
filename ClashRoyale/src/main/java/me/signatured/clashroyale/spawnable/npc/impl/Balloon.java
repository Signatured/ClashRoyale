package me.signatured.clashroyale.spawnable.npc.impl;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.card.annotation.GenerateCard;
import me.signatured.clashroyale.game.ClashArena;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.spawnable.ClashRarity;
import me.signatured.clashroyale.spawnable.npc.ClashNpc;
import me.signatured.clashroyale.spawnable.npc.NpcType;

@GenerateCard(key = "NPC_BALLOON", name = "Balloon", rarity = ClashRarity.EPIC, arena = ClashArena.ARENA_2, cost = 5)
public class Balloon extends ClashNpc {

	public Balloon(ClashGame game, ClashPlayer player, NpcType npcType, int level) {
		super(game, player, npcType, level);
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
