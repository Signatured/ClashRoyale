package me.signatured.clashroyale.spawnable.types;

public interface IDamageableSpawnable {
	
	public int getBaseHealth();
	
	public void damage(int amount);
	
	public void onDeath();
	
	public double getHealthPercent();
	
}
