package me.signatured.clashroyale.spawnable.npc;

import org.bukkit.EntityEffect;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;

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
	
	protected static final NPCRegistry REG = CitizensAPI.getNPCRegistry();
	
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
		loc.setYaw(getFacingYaw());
		
		npc.spawn(loc);
		giveGear();
		
		//TODO: Add appropriate goals
	}
	
	@Override
	public void despawn() {
		npc.destroy();
		getGame().getSpawnables().remove(this);
	}
	
	@Override
	public void damage(int amount) {
		health = Math.max(0, health - amount);
		getLivingEntity().playEffect(EntityEffect.HURT);
		
		if (health <= 0)
			onDeath();
	}
	
	@Override
	public void onDeath() {
		getLivingEntity().playEffect(EntityEffect.DEATH);
		getLivingEntity().setHealth(0);
		
		despawn();
	}
	
	@Override
	public void tick() {
		
	}
	
	@Override
	public double getHealthPercent() {
		int percent = (int) (((double) health / calcHealth()) * 100);
		return percent != 0 ? percent : 1;
	}
	
	@Override
	public Location getLocation() {
		if (npc != null && npc.isSpawned())
			return npc.getStoredLocation();
		return null;
	}
	
	public LivingEntity getLivingEntity() {
		if (npc == null || npc.getEntity() == null)
			return null;
		Entity entity = npc.getEntity();
		
		if (entity.isDead())
			return null;
		
		return (LivingEntity) entity;
	}
	
	private void giveGear() {
		EntityEquipment equip = getLivingEntity().getEquipment();
		equip.setArmorContents(new ItemStack[] {getHelmet(), getChestplate(), getLeggings(), getBoots()});
		equip.setItemInMainHand(getMainHand());
		equip.setItemInOffHand(getOffHand());
	}
	
	private int calcHealth() {
		return (int) ((getBaseHealth() * getLevelMultiplier()) + getBaseHealth());
	}
	
	private int calcDamage() {
		return (int) ((getBaseDamage() * getLevelMultiplier()) + getBaseDamage());
	}
	
	public abstract EntityType getEntityType();
}
