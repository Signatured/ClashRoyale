package me.signatured.clashroyale.spawnable.npc.impl;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.card.annotation.GenerateCard;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.spawnable.npc.ClashNpc;
import me.signatured.clashroyale.spawnable.npc.NpcType;
import me.signatured.clashroyale.spawnable.types.IClashNpc;

@GenerateCard(key = "NPC_GOBLIN", name = "Goblin", real = false)
public class Goblin extends ClashNpc implements IClashNpc {

	public Goblin(ClashGame game, ClashPlayer player, int level) {
		super(game, player, NpcType.GOBLIN, level);
	}

	@Override
	public int getDeployTime() {
		return 1;
	}

	@Override
	public double getHitSpeed() {
		return 1.1;
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
		return SpeedType.VERY_FAST;
	}

	@Override
	public MovementType getTransportType() {
		return MovementType.GROUND;
	}

}