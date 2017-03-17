package me.signatured.clashroyale.spawnable.npc.impl;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.card.annotation.GenerateCard;
import me.signatured.clashroyale.game.ClashArena;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.spawnable.ClashRarity;
import me.signatured.clashroyale.spawnable.npc.ClashNpc;
import me.signatured.clashroyale.spawnable.npc.NpcType;

@GenerateCard(key = "NPC_MINI_PEKKA", name = "Mini P.E.K.K.A.", rarity = ClashRarity.RARE, arena = ClashArena.ARENA_1, cost = 4)
public class MiniPekka extends ClashNpc {

	public MiniPekka(ClashGame game, ClashPlayer player, int level) {
		super(game, player, NpcType.MINI_PEKKA, level);
	}

	@Override
	public double getHitSpeed() {
		return 1.8;
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
