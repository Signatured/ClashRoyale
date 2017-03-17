package me.signatured.clashroyale.spawnable.types;

public interface IAOESpell extends IClashSpell {
	
	public MovementType getTargetType();
	
	public double getRadius();
	
	public double getDuration();
}
