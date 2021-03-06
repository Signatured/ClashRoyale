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

@GenerateCard(key = "NPC_MINER", name = "Miner", rarity = ClashRarity.LEGENDARY, arena = ArenaType.ARENA_6, cost = 3)
public class Miner extends SkinnedNpc {

	public Miner(ClashGame game, ClashPlayer player, int level) {
		super(game, player, level);
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
		return 1000;
	}
	
	@Override
	public int getBaseDamage() {
		return 160;
	}
	
	@Override
	public ItemStack getMainHand() {
		return ItemBuilder.of(Material.STONE_SHOVEL).build();
	}

}
