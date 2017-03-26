package me.signatured.clashroyale.spawnable.types;

import lombok.AllArgsConstructor;
import lombok.Getter;

public interface IClashNpc extends IClashSpawnable, IAttackSpawnable, IDamageableSpawnable, ILocatable {
	
	public SpeedType getSpeed();
	
	public MovementType getTransportType();
	
	default SpawnableType getSpawnableType() {
		return SpawnableType.TROOP;
	}
	
	@Getter
	@AllArgsConstructor
	public enum SpeedType {
		SLOW(45), MEDIUM(60), FAST(90), VERY_FAST(120);
		
		private int speed;
	}
}
