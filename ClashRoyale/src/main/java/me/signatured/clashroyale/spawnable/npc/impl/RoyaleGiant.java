package me.signatured.clashroyale.spawnable.npc.impl;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.card.annotation.GenerateCard;
import me.signatured.clashroyale.game.ClashArena;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.spawnable.ClashRarity;
import me.signatured.clashroyale.spawnable.npc.ClashNpc;
import me.signatured.clashroyale.spawnable.npc.NpcType;

@GenerateCard(key = "NPC_ROYALE_GIANT", name = "Royale Giant", rarity = ClashRarity.COMMON, arena = ClashArena.ARENA_7, cost = 6)
public class RoyaleGiant extends ClashNpc {

	public RoyaleGiant(ClashGame game, ClashPlayer player, int level) {
		super(game, player, NpcType.ROYALE_GIANT, level);
	}

	@Override
	public double getHitSpeed() {
		return 1.7;
	}

	@Override
	public double getRange() {
		return 6.5;
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
