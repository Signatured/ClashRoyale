package me.signatured.clashroyale.spawnable.npc.impl;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.card.annotation.GenerateCard;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.spawnable.npc.ClashNpc;
import me.signatured.clashroyale.util.item.ItemBuilder;

@GenerateCard(key = "NPC_GOBLIN", name = "Goblin", real = false)
public class Goblin extends ClashNpc {

	public Goblin(ClashGame game, ClashPlayer player, int level) {
		super(game, player, level);
	}
	
	@Override
	public EntityType getEntityType() {
		return EntityType.ZOMBIE;
	}

	@Override
	public int getDeployTime() {
		return 1;
	}

	@Override
	public double getHitSpeed() {
		return 1.1;
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
		return SpeedType.VERY_FAST;
	}

	@Override
	public MovementType getTransportType() {
		return MovementType.GROUND;
	}
	
	@Override
	public int getBaseHealth() {
		return 80;
	}
	
	@Override
	public int getBaseDamage() {
		return 50;
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
