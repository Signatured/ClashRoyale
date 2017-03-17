package me.signatured.clashroyale.spawnable.npc.impl;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.card.annotation.GenerateCard;
import me.signatured.clashroyale.game.ClashArena;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.spawnable.ClashRarity;
import me.signatured.clashroyale.spawnable.npc.ClashNpc;
import me.signatured.clashroyale.spawnable.npc.NpcType;
import me.signatured.clashroyale.spawnable.types.IClashNpc;

@GenerateCard(key = "NPC_INFERNO_DRAGON", name = "Inferno Dragon", rarity = ClashRarity.LEGENDARY, arena = ClashArena.ARENA_4, cost = 4)
public class InfernoDragon extends ClashNpc implements IClashNpc {

	public InfernoDragon(ClashGame game, ClashPlayer player, int level) {
		super(game, player, NpcType.INFERNO_DRAGON, level);
	}

	@Override
	public double getHitSpeed() {
		return 0.4;
	}

	@Override
	public double getRange() {
		return 4;
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
		return MovementType.AIR;
	}

}
