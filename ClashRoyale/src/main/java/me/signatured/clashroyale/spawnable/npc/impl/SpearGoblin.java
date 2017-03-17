package me.signatured.clashroyale.spawnable.npc.impl;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.card.annotation.GenerateCard;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.spawnable.npc.ClashNpc;
import me.signatured.clashroyale.spawnable.npc.NpcType;
import me.signatured.clashroyale.spawnable.types.IClashNpc;

@GenerateCard(key = "NPC_SPEAR_GOBLIN", name = "Spear Goblin", real = false)
public class SpearGoblin extends ClashNpc implements IClashNpc {

	public SpearGoblin(ClashGame game, ClashPlayer player, int level) {
		super(game, player, NpcType.SPEAR_GOBLIN, level);
		flags().setAttackFlying(true);
	}

	@Override
	public double getHitSpeed() {
		return 1.3;
	}

	@Override
	public double getRange() {
		return 5;
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
