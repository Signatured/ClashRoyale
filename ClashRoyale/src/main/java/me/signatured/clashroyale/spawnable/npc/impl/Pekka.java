package me.signatured.clashroyale.spawnable.npc.impl;

import org.bukkit.*;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.arena.ArenaType;
import me.signatured.clashroyale.card.annotation.GenerateCard;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.spawnable.ClashRarity;
import me.signatured.clashroyale.spawnable.npc.ClashNpc;
import me.signatured.clashroyale.util.item.ItemBuilder;

@GenerateCard(key = "NPC_PEKKA", name = "P.E.K.K.A.", rarity = ClashRarity.EPIC, arena = ArenaType.ARENA_4, cost = 7)
public class Pekka extends ClashNpc {

	public Pekka(ClashGame game, ClashPlayer player, int level) {
		super(game, player, level);
	}
	
	@Override
	public EntityType getEntityType() {
		return EntityType.WITHER_SKELETON;
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
		return SpeedType.SLOW;
	}

	@Override
	public MovementType getTransportType() {
		return MovementType.GROUND;
	}
	
	@Override
	public int getBaseHealth() {
		return 2600;
	}
	
	@Override
	public int getBaseDamage() {
		return 510;
	}
	
	@Override
	public ItemStack getMainHand() {
		return ItemBuilder.of(Material.DIAMOND_SWORD).build();
	}
	
	@Override
	public ItemStack getHelmet() {
		return getSkinnedHead();
	}
	
	@Override
	public ItemStack getChestplate() {
		return ItemBuilder.of(Material.LEATHER_CHESTPLATE).setLeatherArmorColor(Color.BLUE).build();
	}
	
	@Override
	public ItemStack getLeggings() {
		return ItemBuilder.of(Material.LEATHER_LEGGINGS).setLeatherArmorColor(Color.BLUE).build();
	}
	
	@Override
	public ItemStack getBoots() {
		return ItemBuilder.of(Material.LEATHER_BOOTS).setLeatherArmorColor(Color.BLUE).build();
	}

}
