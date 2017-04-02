package me.signatured.clashroyale.spawnable.npc.impl;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.arena.ArenaType;
import me.signatured.clashroyale.card.annotation.GenerateCard;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.spawnable.ClashRarity;
import me.signatured.clashroyale.spawnable.npc.SkinnedNpc;

@GenerateCard(key = "NPC_ELECTRO_WIZARD", name = "Electro Wizard", rarity = ClashRarity.LEGENDARY, arena = ArenaType.ARENA_7, cost = 4)
public class ElectroWizard extends SkinnedNpc {

	public ElectroWizard(ClashGame game, ClashPlayer player, int level) {
		super(game, player, level);
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
	
	@Override
	public int getBaseHealth() {
		return 600;
	}
	
	@Override
	public int getBaseDamage() {
		return 200;
	}
	
	public int getBaseSpawnDamage() {
		return 159;
	}

}
