package me.signatured.clashroyale.spawnable.types;

public interface IClashSpawnable {
	
	public SpawnableType getSpawnableType();
	
	default int getDeployTime() {
		return 1;
	};
	
	public enum SpawnableType {
		BUILDING, TROOP, SPELL;
	}
	
	public enum MovementType {
		AIR, GROUND, AIR_AND_GROUND;
		
		public boolean canAttack(MovementType type) {
			if (type == null)
				return false;
			
			if (type == AIR)
				return this == AIR || this == AIR_AND_GROUND;
			if (type == GROUND)
				return this == GROUND || this == AIR_AND_GROUND;
			
			return false;
		}
	}
}
