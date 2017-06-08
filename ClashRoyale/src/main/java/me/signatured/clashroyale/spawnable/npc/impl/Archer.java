package me.signatured.clashroyale.spawnable.npc.impl;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.card.annotation.GenerateCard;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.spawnable.npc.SkinnedNpc;
import me.signatured.clashroyale.util.item.ItemBuilder;

@GenerateCard(key = "NPC_ARCHER", name = "Archer", real = false)
public class Archer extends SkinnedNpc {

	public Archer(ClashGame game, ClashPlayer owner, int level) {
		super(game, owner, level);
	}

	@Override
	public double getHitSpeed() {
		return 1.2;
	}

	@Override
	public double getRange() {
		return 5;
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
		return MovementType.GROUND;
	}

	@Override
	public int getBaseHealth() {
		return 120;
	}
	
	@Override
	public int getBaseDamage() {
		return 41;
	}
	
	@Override
	public ItemStack getMainHand() {
		return ItemBuilder.of(Material.BOW).build();
	}

}
