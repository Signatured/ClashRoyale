package me.signatured.clashroyale.spawnable.types;

public interface IClashStructure extends IClashSpawnable, IDamageableSpawnable, ILocatable {
	
	public int getLifetime();
	
	default boolean isCrownTower() {
		return false;
	}
	
	default SpawnableType getSpawnableType() {
		return SpawnableType.BUILDING;
	}
}
