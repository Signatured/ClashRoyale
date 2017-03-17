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
	private NpcType npcType;
	private int level, health, damage;
	
	public ClashNpc(ClashGame game, ClashPlayer player, NpcType npcType, int level) {
		super(game, player, level);
		this.npcType = npcType;
		this.level = level;
		this.health = npcType.getCalcHealth(level);
		this.damage = npcType.getCalcDamage(level);
	}
	
	@Override
	public void spawn(Location loc) {
		npc = REG.createNPC(EntityType.PLAYER, getName());
		
		//TODO: Spawn looking correct way, add appropriate goals
	}
	
	@Override
	public void despawn() {
		
	}
	
	@Override
	public void onDeath() {
		
	}
	
	@Override
	public void tick() {
		
	}
}
