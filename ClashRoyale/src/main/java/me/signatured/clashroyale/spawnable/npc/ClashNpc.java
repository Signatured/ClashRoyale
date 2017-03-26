package me.signatured.clashroyale.spawnable.npc;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;

import lombok.Data;
import lombok.EqualsAndHashCode;
import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.spawnable.ClashSpawnable;
import me.signatured.clashroyale.spawnable.types.IClashNpc;
import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.api.npc.NPCRegistry;

@Data
@EqualsAndHashCode(callSuper=false)
public abstract class ClashNpc extends ClashSpawnable implements IClashNpc {
	
	private static final NPCRegistry REG = CitizensAPI.getNPCRegistry();
	
	private NPC npc;
	private int level, health, damage;
	
	public ClashNpc(ClashGame game, ClashPlayer player, int level) {
		super(game, player, level);
		this.level = level;
		this.health = calcHealth();
		this.damage = calcDamage();
	}
	
	@Override
	public void spawn(Location loc) {
		npc = REG.createNPC(getEntityType(), getName());
		
		//TODO: Spawn looking correct way, add appropriate goals
	}
	
	@Override
	public void despawn() {
		
	}
	
	@Override
	public void damage(int amount) {
		health = Math.max(0, health - amount);
		
		if (health <= 0)
			onDeath();
	}
	
	@Override
	public void onDeath() {
		
	}
	
	@Override
	public void tick() {
		
	}
	
	@Override
	public double getHealthPercent() {
		return ((double) health / calcHealth()) * 100;
	}
	
	@Override
	public Location getLocation() {
		if (npc != null && npc.isSpawned())
			return npc.getStoredLocation();
		return null;
	}
	
	private int calcHealth() {
		return (int) ((getBaseHealth() * getLevelMultiplier()) + getBaseHealth());
	}
	
	private int calcDamage() {
		return (int) ((getBaseDamage() * getLevelMultiplier()) + getBaseDamage());
	}
	
	public abstract EntityType getEntityType();
}
