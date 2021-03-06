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

@GenerateCard(key = "NPC_KNIGHT", name = "Knight", rarity = ClashRarity.COMMON, arena = ArenaType.ARENA_1, cost = 3, defaultCard = true)
public class Knight extends SkinnedNpc {

	public Knight(ClashGame game, ClashPlayer player, int level) {
		super(game, player, level);
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
		return SpeedType.MEDIUM;
	}

	@Override
	public MovementType getTransportType() {
		return MovementType.GROUND;
	}
	
	@Override
	public int getBaseHealth() {
		return 660;
	}
	
	@Override
	public int getBaseDamage() {
		return 75;
	}
	
	@Override
	public ItemStack getMainHand() {
		return ItemBuilder.of(Material.IRON_SWORD).build();
	}
	
	@Override
	public ItemStack getChestplate() {
		return ItemBuilder.of(Material.CHAINMAIL_CHESTPLATE).build();
	}

}
