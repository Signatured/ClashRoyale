package me.signatured.clashroyale.spawnable.types;

public interface ISpawnStructure extends IClashStructure {
	
	public String getNpcKey();
	
	public double getSpawnSpeed();
	
	public int getSpawnAmount();
	
	default double getRange() {
		return -1;
	}
	
}
