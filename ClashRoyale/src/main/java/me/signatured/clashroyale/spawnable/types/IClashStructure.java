package me.signatured.clashroyale.spawnable.types;

public interface IClashStructure extends IClashSpawnable, IDamageableSpawnable {
	
	public int getLifetime();
	
	default SpawnableType getSpawnableType() {
		return SpawnableType.BUILDING;
	}
}
