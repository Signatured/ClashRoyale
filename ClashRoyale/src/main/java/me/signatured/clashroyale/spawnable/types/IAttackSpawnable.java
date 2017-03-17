package me.signatured.clashroyale.spawnable.types;

import me.signatured.clashroyale.spawnable.ClashSpawnable;
import me.signatured.clashroyale.spawnable.npc.ClashNpc;
import me.signatured.clashroyale.spawnable.structure.ClashStructure;
import me.signatured.clashroyale.spawnable.types.IClashSpawnable.MovementType;

public interface IAttackSpawnable {
	
	public double getHitSpeed();
		
	public double getRange();
	
	public MovementType getTargetType();
	
	default boolean canAttack(ClashSpawnable spawnable) {
		if (spawnable instanceof ClashStructure)
			return true;
		
		if (spawnable instanceof ClashNpc)
			return getTargetType().canAttack(((ClashNpc)spawnable).getTransportType());
		
		return false;
	}
}
