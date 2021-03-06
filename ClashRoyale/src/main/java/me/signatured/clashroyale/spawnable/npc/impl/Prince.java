package me.signatured.clashroyale.spawnable.npc.impl;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.arena.ArenaType;
import me.signatured.clashroyale.card.annotation.GenerateCard;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.spawnable.ClashRarity;
import me.signatured.clashroyale.spawnable.npc.RidingNpc;
import me.signatured.clashroyale.util.item.ItemBuilder;

@GenerateCard(key = "NPC_PRINCE", name = "Prince", rarity = ClashRarity.EPIC, arena = ArenaType.ARENA_1, cost = 5, defaultCard = true)
public class Prince extends RidingNpc {

	public Prince(ClashGame game, ClashPlayer player, int level) {
		super(game, player, level);
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
		return 1100;
	}
	
	@Override
	public int getBaseDamage() {
		return 245;
	}

	@Override
	public EntityType getVehicleType() {
		return EntityType.HORSE;
	}
	
	@Override
	public ItemStack getMainHand() {
		return ItemBuilder.of(Material.DIAMOND_SWORD).build();
	}
	
}
