package me.signatured.clashroyale.spawnable.npc.impl;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.card.annotation.GenerateCard;
import me.signatured.clashroyale.game.ClashArena;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.spawnable.ClashRarity;
import me.signatured.clashroyale.spawnable.npc.ClashNpc;
import me.signatured.clashroyale.spawnable.npc.NpcType;
import me.signatured.clashroyale.spawnable.types.IClashNpc;

@GenerateCard(key = "NPC_BANDIT", name = "Bandit", rarity = ClashRarity.LEGENDARY, arena = ClashArena.ARENA_9, cost = 3)
public class Bandit extends ClashNpc implements IClashNpc {

	public Bandit(ClashGame game, ClashPlayer player, int level) {
		super(game, player, NpcType.BOMBER, level);
	}

	@Override
	public double getHitSpeed() {
		return 1;
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
		return SpeedType.FAST;
	}

	@Override
	public MovementType getTransportType() {
		return MovementType.GROUND;
	}

}
