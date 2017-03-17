package me.signatured.clashroyale.spawnable.types;

import me.signatured.clashroyale.spawnable.types.IClashSpawnable.MovementType;

public interface IAttackSpawnable {
	
	public double getHitSpeed();
		
	public double getRange();
	
	public MovementType getTargetType();
}
