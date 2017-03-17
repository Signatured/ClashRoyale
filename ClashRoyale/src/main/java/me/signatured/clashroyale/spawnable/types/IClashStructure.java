package me.signatured.clashroyale.spawnable.types;

public interface IClashStructure extends IClashSpawnable {
	
	public int getLifetime();
	
	default SpawnableType getSpawnableType() {
		return SpawnableType.BUILDING;
	}
}
