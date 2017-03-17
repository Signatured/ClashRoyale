package me.signatured.clashroyale.spawnable.npc.impl;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.card.annotation.GenerateCard;
import me.signatured.clashroyale.game.ClashArena;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.spawnable.ClashRarity;
import me.signatured.clashroyale.spawnable.npc.ClashNpc;
import me.signatured.clashroyale.spawnable.npc.NpcType;
import me.signatured.clashroyale.spawnable.types.IClashNpc;

@GenerateCard(key = "NPC_MEGA_MINION", name = "Mega Minion", rarity = ClashRarity.RARE, arena = ClashArena.ARENA_7, cost = 3)
public class MegaMinion extends ClashNpc implements IClashNpc {

	public MegaMinion(ClashGame game, ClashPlayer player, int level) {
		super(game, player, NpcType.MEGA_MINION, level);
		flags().setFlying(true);
		flags().setAttackFlying(true);
	}

	@Override
	public double getHitSpeed() {
		return 1.5;
	}

	@Override
	public double getRange() {
		return 2;
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