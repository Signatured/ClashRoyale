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

@GenerateCard(key = "NPC_ROYALE_GIANT", name = "Royale Giant", rarity = ClashRarity.COMMON, arena = ArenaType.ARENA_7, cost = 6)
public class RoyaleGiant extends ClashNpc {

	public RoyaleGiant(ClashGame game, ClashPlayer player, int level) {
		super(game, player, level);
	}
	
	@Override
	public EntityType getEntityType() {
		return EntityType.WITHER_SKELETON;
	}

	@Override
	public double getHitSpeed() {
		return 1.7;
	}

	@Override
	public double getRange() {
		return 6.5;
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
		return 1200;
	}
	
	@Override
	public int getBaseDamage() {
		return 75;
	}
	
	@Override
	public ItemStack getMainHand() {
		return ItemBuilder.of(Material.DIAMOND_HOE).build();
	}
	
	@Override
	public ItemStack getHelmet() {
		return getSkinnedHead();
	}
	
	@Override
	public ItemStack getChestplate() {
		return ItemBuilder.of(Material.CHAINMAIL_CHESTPLATE).setLeatherArmorColor(Color.BLUE).build();
	}
	
	@Override
	public ItemStack getLeggings() {
		return ItemBuilder.of(Material.CHAINMAIL_LEGGINGS).setLeatherArmorColor(Color.BLUE).build();
	}
	
	@Override
	public ItemStack getBoots() {
		return ItemBuilder.of(Material.CHAINMAIL_BOOTS).setLeatherArmorColor(Color.BLUE).build();
	}

}
