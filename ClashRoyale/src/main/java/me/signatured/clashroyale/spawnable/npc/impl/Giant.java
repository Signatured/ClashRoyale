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

@GenerateCard(key = "NPC_GIANT", name = "Giant", rarity = ClashRarity.RARE, arena = ArenaType.ARENA_1, cost = 5)
public class Giant extends ClashNpc {

	public Giant(ClashGame game, ClashPlayer player, int level) {
		super(game, player, level);
	}
	
	@Override
	public EntityType getEntityType() {
		return EntityType.WITHER_SKELETON;
	}

	@Override
	public double getHitSpeed() {
		return 1.5;
	}

	@Override
	public double getRange() {
		return -1;
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
	
	@Override
	public int getBaseHealth() {
		return 1900;
	}
	
	@Override
	public int getBaseDamage() {
		return 120;
	}
	
	@Override
	public ItemStack getHelmet() {
		return getSkinnedHead();
	}
	
	@Override
	public ItemStack getChestplate() {
		return ItemBuilder.of(Material.LEATHER_CHESTPLATE).build();
	}
	
	@Override
	public ItemStack getLeggings() {
		return ItemBuilder.of(Material.LEATHER_LEGGINGS).build();
	}
	
	@Override
	public ItemStack getBoots() {
		return ItemBuilder.of(Material.LEATHER_BOOTS).build();
	}

}
