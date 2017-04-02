package me.signatured.clashroyale.spawnable.npc.impl;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.arena.ArenaType;
import me.signatured.clashroyale.card.annotation.GenerateCard;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.spawnable.ClashRarity;
import me.signatured.clashroyale.spawnable.npc.SkinnedNpc;

@GenerateCard(key = "NPC_LAVA_HOUND", name = "Lava Hound", rarity = ClashRarity.LEGENDARY, arena = ArenaType.ARENA_4, cost = 7)
public class LavaHound extends SkinnedNpc {

	public LavaHound(ClashGame game, ClashPlayer player, int level) {
		super(game, player, level);
	}

	@Override
	public double getHitSpeed() {
		return 1.3;
	}

	@Override
	public double getRange() {
		return 2;
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
		return MovementType.AIR;
	}
	
	@Override
	public int getBaseHealth() {
		return 3000;
	}
	
	@Override
	public int getBaseDamage() {
		return 45;
	}
	
}
