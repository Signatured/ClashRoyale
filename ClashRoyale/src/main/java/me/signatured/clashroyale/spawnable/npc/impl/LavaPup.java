package me.signatured.clashroyale.spawnable.npc.impl;

import org.bukkit.*;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.card.annotation.GenerateCard;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.spawnable.npc.ClashNpc;
import me.signatured.clashroyale.util.item.ItemBuilder;

@GenerateCard(key = "NPC_LAVA_PUP", name = "Lava Pup", real = false)
public class LavaPup extends ClashNpc {

	public LavaPup(ClashGame game, ClashPlayer player, int level) {
		super(game, player, level);
	}
	
	@Override
	public EntityType getEntityType() {
		return EntityType.ZOMBIE;
	}

	@Override
	public double getHitSpeed() {
		return 1;
	}

	@Override
	public double getRange() {
		return -1;
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
		return 179;
	}
	
	@Override
	public int getBaseDamage() {
		return 45;
	}
	
	@Override
	public ItemStack getHelmet() {
		return ItemBuilder.of(Material.LEATHER_CHESTPLATE).setLeatherArmorColor(Color.YELLOW).build();
	}
	
	@Override
	public ItemStack getChestplate() {
		return ItemBuilder.of(Material.LEATHER_CHESTPLATE).setLeatherArmorColor(Color.YELLOW).build();
	}
	
	@Override
	public ItemStack getLeggings() {
		return ItemBuilder.of(Material.LEATHER_LEGGINGS).setLeatherArmorColor(Color.YELLOW).build();
	}
	
	@Override
	public ItemStack getBoots() {
		return ItemBuilder.of(Material.LEATHER_BOOTS).setLeatherArmorColor(Color.YELLOW).build();
	}

}
