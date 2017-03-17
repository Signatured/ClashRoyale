package me.signatured.clashroyale.spawnable.npc.impl;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.card.annotation.GenerateCard;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.spawnable.npc.ClashNpc;
import me.signatured.clashroyale.spawnable.npc.NpcType;
import me.signatured.clashroyale.spawnable.types.IClashNpc;

@GenerateCard(key = "NPC_TOWER_KING", name = "Tower King", real = false)
public class TowerKing extends ClashNpc implements IClashNpc {

	public TowerKing(ClashGame game, ClashPlayer owner, int level) {
		super(game, owner, NpcType.KING_TOWER_NPC, level);
	}

	@Override
	public double getHitSpeed() {
		return 1;
	}

	@Override
	public double getRange() {
		return 7;
	}

	@Override
	public MovementType getTargetType() {
		return MovementType.AIR_AND_GROUND;
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
