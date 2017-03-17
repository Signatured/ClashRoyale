package me.signatured.clashroyale.spawnable.npc.impl;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.card.annotation.GenerateCard;
import me.signatured.clashroyale.game.ClashArena;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.spawnable.ClashRarity;
import me.signatured.clashroyale.spawnable.npc.ClashNpc;
import me.signatured.clashroyale.spawnable.npc.NpcType;

@GenerateCard(key = "NPC_BABY_DRAGON", name = "Baby Dragon", rarity = ClashRarity.EPIC, arena = ClashArena.ARENA_1, cost = 4)
public class BabyDragon extends ClashNpc {

	public BabyDragon(ClashGame game, ClashPlayer owner, int level) {
		super(game, owner, NpcType.BABY_DRAGON, level);
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

}
