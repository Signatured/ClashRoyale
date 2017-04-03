package me.signatured.clashroyale.spawnable.npc.impl;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.card.annotation.GenerateCard;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.spawnable.npc.ClashNpc;
import me.signatured.clashroyale.util.item.ItemBuilder;

@GenerateCard(key = "NPC_TOWER_BOMBER", name = "Tower Bomber", real = false)
public class TowerBomber extends ClashNpc {

	public TowerBomber(ClashGame game, ClashPlayer owner, int level) {
		super(game, owner, level);
	}
	
	@Override
	public EntityType getEntityType() {
		return EntityType.SKELETON;
	}

	@Override
	public double getHitSpeed() {
		return 1.6;
	}

	@Override
	public double getRange() {
		return 6;
	}

	@Override
	public MovementType getTargetType() {
		return MovementType.GROUND;
	}

	@Override
	public SpeedType getSpeed() {
		return null;
	}

	@Override
	public MovementType getTransportType() {
		return null;
	}
	
	@Override
	public int getBaseHealth() {
		return -1;
	}
	
	@Override
	public int getBaseDamage() {
		return 100;
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
