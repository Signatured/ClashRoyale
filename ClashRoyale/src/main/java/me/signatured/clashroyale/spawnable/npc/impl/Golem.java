package me.signatured.clashroyale.spawnable.npc.impl;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.card.annotation.GenerateCard;
import me.signatured.clashroyale.game.ClashArena;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.spawnable.ClashRarity;
import me.signatured.clashroyale.spawnable.npc.ClashNpc;
import me.signatured.clashroyale.spawnable.npc.NpcType;
import me.signatured.clashroyale.spawnable.types.IClashNpc;

@GenerateCard(key = "NPC_GOLEM", name = "Golem", rarity = ClashRarity.EPIC, arena = ClashArena.ARENA_6, cost = 8)
public class Golem extends ClashNpc implements IClashNpc {

	public Golem(ClashGame game, ClashPlayer player, int level) {
		super(game, player, NpcType.GOLEM, level);
		flags().setStructuresOnly(true);
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

}
