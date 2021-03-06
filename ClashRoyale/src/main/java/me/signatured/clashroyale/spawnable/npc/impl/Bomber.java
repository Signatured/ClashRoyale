package me.signatured.clashroyale.spawnable.npc.impl;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.arena.ArenaType;
import me.signatured.clashroyale.card.annotation.GenerateCard;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.spawnable.ClashRarity;
import me.signatured.clashroyale.spawnable.npc.ClashNpc;
import me.signatured.clashroyale.util.item.ItemBuilder;

@GenerateCard(key = "NPC_BOMBER", name = "Bomber", rarity = ClashRarity.COMMON, arena = ArenaType.ARENA_1, cost = 3, defaultCard = true)
public class Bomber extends ClashNpc {

	public Bomber(ClashGame game, ClashPlayer player, int level) {
		super(game, player, level);
	}
	
	@Override
	public EntityType getEntityType() {
		return EntityType.SKELETON;
	}

	@Override
	public double getHitSpeed() {
		return 1.9;
	}

	@Override
	public double getRange() {
		return 4.5;
	}

	@Override
	public MovementType getTargetType() {
		return MovementType.GROUND;
	}

	@Override
	public SpeedType getSpeed() {
		return SpeedType.MEDIUM;
	}

	@Override
	public MovementType getTransportType() {
		return MovementType.GROUND;
	}

	@Override
	public int getBaseDamage() {
		return 147;
	}

	@Override
	public int getBaseHealth() {
		return 128;
	}
	
	@Override
	public ItemStack getMainHand() {
		return ItemBuilder.of(Material.TNT).build();
	}
	
	@Override
	public ItemStack getHelmet() {
		return getSkinnedHead();
	}

}
