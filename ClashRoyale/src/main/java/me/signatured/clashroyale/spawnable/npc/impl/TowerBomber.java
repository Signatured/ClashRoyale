package me.signatured.clashroyale.spawnable.npc.impl;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.card.annotation.GenerateCard;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.spawnable.npc.ClashNpc;
import me.signatured.clashroyale.spawnable.npc.NpcType;
import me.signatured.clashroyale.spawnable.types.IClashNpc;

@GenerateCard(key = "NPC_TOWER_BOMBER", name = "Tower Bomber", real = false)
public class TowerBomber extends ClashNpc implements IClashNpc {

	public TowerBomber(ClashGame game, ClashPlayer owner, int level) {
		super(game, owner, NpcType.TOWER_BOMBER, level);
	}

	@Override
	public double getHitSpeed() {
		return 1.6;
	}

	@Override
	public double getRange() {
		return 6;
	}

	@Override
	public MovementType getTargetType() {
		return MovementType.GROUND;
	}

	@Override
	public SpeedType getSpeed() {
		return null;
	}

	@Override
	public MovementType getTransportType() {
		return null;
	}

}
