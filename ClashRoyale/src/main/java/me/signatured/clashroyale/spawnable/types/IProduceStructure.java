package me.signatured.clashroyale.spawnable.types;

public interface IProduceStructure extends IClashStructure {
	
	public double getProduceSpeed();
	
	default double getRange() {
		return -1;
	}
	
	default MovementType getTargetType() {
		return null;
	}
	
}
