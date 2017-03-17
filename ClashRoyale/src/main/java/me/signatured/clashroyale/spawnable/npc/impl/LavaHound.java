package me.signatured.clashroyale.spawnable.npc.impl;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.card.annotation.GenerateCard;
import me.signatured.clashroyale.game.ClashArena;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.spawnable.ClashRarity;
import me.signatured.clashroyale.spawnable.npc.ClashNpc;
import me.signatured.clashroyale.spawnable.npc.NpcType;
import me.signatured.clashroyale.spawnable.types.IClashNpc;

@GenerateCard(key = "NPC_LAVA_HOUND", name = "Lava Hound", rarity = ClashRarity.LEGENDARY, arena = ClashArena.ARENA_4, cost = 7)
public class LavaHound extends ClashNpc implements IClashNpc {

	public LavaHound(ClashGame game, ClashPlayer player, int level) {
		super(game, player, NpcType.LAVA_HOUND, level);
		flags().setFlying(true);
		flags().setStructuresOnly(true);
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
	
}