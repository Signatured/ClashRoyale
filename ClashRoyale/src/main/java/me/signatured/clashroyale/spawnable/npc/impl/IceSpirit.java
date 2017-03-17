package me.signatured.clashroyale.spawnable.npc.impl;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.card.annotation.GenerateCard;
import me.signatured.clashroyale.game.ClashArena;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.spawnable.ClashRarity;
import me.signatured.clashroyale.spawnable.npc.ClashNpc;
import me.signatured.clashroyale.spawnable.npc.NpcType;
import me.signatured.clashroyale.spawnable.types.IClashNpc;

@GenerateCard(key = "NPC_ICE_SPIRIT", name = "Ice Spirit", rarity = ClashRarity.COMMON, arena = ClashArena.ARENA_8, cost = 1)
public class IceSpirit extends ClashNpc implements IClashNpc {

	public IceSpirit(ClashGame game, ClashPlayer player, int level) {
		super(game, player, NpcType.ICE_SPIRIT, level);
		flags().setAttackFlying(true);
	}

	@Override
	public double getHitSpeed() {
		return 0;
	}

	@Override
	public double getRange() {
		return 2.5;
	}

	@Override
	public MovementType getTargetType() {
		return MovementType.AIR_AND_GROUND;
	}

	@Override
	public SpeedType getSpeed() {
		return SpeedType.VERY_FAST;
	}

	@Override
	public MovementType getTransportType() {
		return MovementType.GROUND;
	}

}