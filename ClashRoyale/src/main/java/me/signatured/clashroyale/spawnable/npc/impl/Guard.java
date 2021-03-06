package me.signatured.clashroyale.spawnable.npc.impl;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.card.annotation.GenerateCard;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.spawnable.npc.ClashNpc;
import me.signatured.clashroyale.util.item.ItemBuilder;

@GenerateCard(key = "NPC_GUARD", name = "Guard", real = false)
public class Guard extends ClashNpc {

	public Guard(ClashGame game, ClashPlayer player, int level) {
		super(game, player, level);
	}
	
	@Override
	public EntityType getEntityType() {
		return EntityType.STRAY;
	}

	@Override
	public double getHitSpeed() {
		return 1.2;
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
		return SpeedType.FAST;
	}

	@Override
	public MovementType getTransportType() {
		return MovementType.GROUND;
	}
	
	@Override
	public int getBaseHealth() {
		return 65;
	}
	
	@Override
	public int getBaseDamage() {
		return 65;
	}
	
	public int getBaseShieldHealth() {
		return 150;
	}
	
	@Override
	public ItemStack getMainHand() {
		return ItemBuilder.of(Material.STONE_SWORD).build();
	}
	
	@Override
	public ItemStack getOffHand() {
		return ItemBuilder.of(Material.SHIELD).build();
	}
	
	@Override
	public ItemStack getHelmet() {
		return getSkinnedHead();
	}

}
