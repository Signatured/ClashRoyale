package me.signatured.clashroyale.spawnable.types;

public interface INpcStructure extends IClashStructure {
	
	public String getNpcKey();
	
	default double getRange() {
		return -1;
	}
}
