package me.signatured.clashroyale.spawnable.types;

public interface IClashSpell extends IClashSpawnable {
	
	default SpawnableType getSpawnableType() {
		return SpawnableType.SPELL;
	}
}
