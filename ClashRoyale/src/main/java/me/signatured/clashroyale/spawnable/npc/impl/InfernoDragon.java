package me.signatured.clashroyale.spawnable.npc.impl;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.arena.ArenaType;
import me.signatured.clashroyale.card.annotation.GenerateCard;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.spawnable.ClashRarity;
import me.signatured.clashroyale.spawnable.npc.SkinnedNpc;
import me.signatured.clashroyale.util.item.ItemBuilder;

@GenerateCard(key = "NPC_INFERNO_DRAGON", name = "Inferno Dragon", rarity = ClashRarity.LEGENDARY, arena = ArenaType.ARENA_4, cost = 4)
public class InfernoDragon extends SkinnedNpc {

	public InfernoDragon(ClashGame game, ClashPlayer player, int level) {
		super(game, player, level);
	}

	@Override
	public double getHitSpeed() {
		return 0.4;
	}

	@Override
	public double getRange() {
		return 4;
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
		return MovementType.AIR;
	}
	
	@Override
	public int getBaseHealth() {
		return 1000;
	}
	
	@Override
	public int getBaseDamage() {
		return 30;
	}
	
	@Override
	public ItemStack getHelmet() {
		return ItemBuilder.of(Material.IRON_HELMET).build();
	}

}
