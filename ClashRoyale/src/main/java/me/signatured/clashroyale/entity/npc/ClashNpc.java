package me.signatured.clashroyale.entity.npc;

import org.bukkit.entity.EntityType;

import lombok.Data;
import lombok.EqualsAndHashCode;
import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.entity.ClashSpawnable;
import me.signatured.clashroyale.game.ClashGame;
import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.api.npc.NPCRegistry;

@Data
@EqualsAndHashCode(callSuper=false)
public class ClashNpc extends ClashSpawnable {
	
	private static final NPCRegistry REG = CitizensAPI.getNPCRegistry();
	
	private final double LEVEL_MULT = 0.1;
	
	private NPC npc;
	private NpcType npcType;
	private NpcFlags flags;
	private int level, health, damage, range;
	
	public ClashNpc(ClashGame game, ClashPlayer player, NpcType npcType, int level) {
		super(game, player);
		this.npcType = npcType;
		this.level = level;
		this.health = (int) (npcType.getBaseHealth() * LEVEL_MULT) + npcType.getBaseHealth();
		this.damage = (int) (npcType.getBaseDamage() * LEVEL_MULT) + npcType.getBaseDamage();
		this.range = npcType.getRange();
	}
	
	@Override
	public void spawn() {
		npc = REG.createNPC(EntityType.PLAYER, npcType.getName());
		
		//TODO: Spawn looking correct way, add appropriate goals
	}
	
	@Override
	public void despawn() {
		
	}
	
	@Override
	public void tick() {
		
	}
	
	public NpcFlags flags() {
		return flags;
	}
}
