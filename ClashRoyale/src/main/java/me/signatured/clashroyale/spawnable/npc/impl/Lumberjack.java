package me.signatured.clashroyale.spawnable.npc.impl;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionType;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.arena.ArenaType;
import me.signatured.clashroyale.card.annotation.GenerateCard;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.spawnable.ClashRarity;
import me.signatured.clashroyale.spawnable.npc.SkinnedNpc;
import me.signatured.clashroyale.util.item.ItemBuilder;

@GenerateCard(key = "NPC_LUMBERJACK", name = "Lumberjack", rarity = ClashRarity.LEGENDARY, arena = ArenaType.ARENA_8, cost = 4)
public class Lumberjack extends SkinnedNpc {

	public Lumberjack(ClashGame game, ClashPlayer player, int level) {
		super(game, player, level);
	}

	@Override
	public double getHitSpeed() {
		return 0.7;
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
		return 950;
	}
	
	@Override
	public int getBaseDamage() {
		return 200;
	}
	
	@Override
	public ItemStack getMainHand() {
		return ItemBuilder.of(Material.STONE_AXE).build();
	}
	
	@Override
	public ItemStack getOffHand() {
		return ItemBuilder.of(Material.POTION).setPotionMeta(PotionType.INSTANT_DAMAGE, false, false).build();
	}

}
