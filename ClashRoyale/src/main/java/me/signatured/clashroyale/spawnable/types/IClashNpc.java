package me.signatured.clashroyale.spawnable.types;

import org.bukkit.inventory.ItemStack;

import lombok.AllArgsConstructor;
import lombok.Getter;

public interface IClashNpc extends IClashSpawnable, IAttackSpawnable, IDamageableSpawnable, ILocatable {
	
	public SpeedType getSpeed();
	
	public MovementType getTransportType();
	
	default SpawnableType getSpawnableType() {
		return SpawnableType.TROOP;
	}
	
	default ItemStack getMainHand() {
		return null;
	}
	
	default ItemStack getOffHand() {
		return null;
	}
	
	default ItemStack getHelmet() {
		return null;
	}
	
	default ItemStack getChestplate() {
		return null;
	}
	
	default ItemStack getLeggings() {
		return null;
	}
	
	default ItemStack getBoots() {
		return null;
	}
	
	@Getter
	@AllArgsConstructor
	public enum SpeedType {
		SLOW(45), MEDIUM(60), FAST(90), VERY_FAST(120);
		
		private int speed;
	}
}
