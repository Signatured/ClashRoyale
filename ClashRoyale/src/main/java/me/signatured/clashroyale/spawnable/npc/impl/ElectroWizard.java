package me.signatured.clashroyale.spawnable.npc.impl;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.card.annotation.GenerateCard;
import me.signatured.clashroyale.game.ClashArena;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.spawnable.ClashRarity;
import me.signatured.clashroyale.spawnable.npc.ClashNpc;
import me.signatured.clashroyale.spawnable.npc.NpcType;
import me.signatured.clashroyale.spawnable.types.IClashNpc;

@GenerateCard(key = "NPC_ELECTRO_WIZARD", name = "Electro Wizard", rarity = ClashRarity.LEGENDARY, arena = ClashArena.ARENA_7, cost = 4)
public class ElectroWizard extends ClashNpc implements IClashNpc {

	public ElectroWizard(ClashGame game, ClashPlayer player, int level) {
		super(game, player, NpcType.ELECTRO_WIZARD, level);
	}

	@Override
	public double getHitSpeed() {
		return 1.7;
	}

	@Override
	public double getRange() {
		return 5;
	}

	@Override
	public MovementType getTargetType() {
		return MovementType.AIR_AND_GROUND;
	}

	@Override
	public SpeedType getSpeed() {
		return SpeedType.FAST;
	}

	@Override
	public MovementType getTransportType() {
		return MovementType.AIR;
	}

}