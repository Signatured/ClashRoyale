package me.signatured.clashroyale.spawnable.npc.impl;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.card.annotation.GenerateCard;
import me.signatured.clashroyale.game.ClashArena;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.spawnable.ClashRarity;
import me.signatured.clashroyale.spawnable.npc.ClashNpc;
import me.signatured.clashroyale.spawnable.npc.NpcType;

@GenerateCard(key = "NPC_ICE_WIZARD", name = "Ice Wizard", rarity = ClashRarity.LEGENDARY, arena = ClashArena.ARENA_5, cost = 3)
public class IceWizard extends ClashNpc {

	public IceWizard(ClashGame game, ClashPlayer player, int level) {
		super(game, player, NpcType.ICE_WIZARD, level);
	}

	@Override
	public double getHitSpeed() {
		return 1.5;
	}

	@Override
	public double getRange() {
		return 5.5;
	}

	@Override
	public MovementType getTargetType() {
		return MovementType.AIR_AND_GROUND;
	}

	@Override
	public SpeedType getSpeed() {
		return SpeedType.MEDIUM;
	}

	@Override
	public MovementType getTransportType() {
		return MovementType.GROUND;
	}

}
