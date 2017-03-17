package me.signatured.clashroyale.spawnable.npc.impl;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.card.annotation.GenerateCard;
import me.signatured.clashroyale.game.ClashArena;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.spawnable.ClashRarity;
import me.signatured.clashroyale.spawnable.npc.ClashNpc;
import me.signatured.clashroyale.spawnable.npc.NpcType;
import me.signatured.clashroyale.spawnable.types.IClashNpc;

@GenerateCard(key = "NPC_DART_GOBLIN", name = "Dart Goblin", rarity = ClashRarity.RARE, arena = ClashArena.ARENA_9, cost = 3)
public class DartGoblin extends ClashNpc implements IClashNpc {

	public DartGoblin(ClashGame game, ClashPlayer player, int level) {
		super(game, player, NpcType.DART_GOBLIN, level);
		flags().setAttackFlying(true);
	}

	@Override
	public double getHitSpeed() {
		return 0.7;
	}

	@Override
	public double getRange() {
		return 6.5;
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