package me.signatured.clashroyale.spawnable.npc;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.game.ClashGame;
import net.citizensnpcs.api.npc.NPC;

public abstract class RidingNpc extends ClashNpc {
	
	private NPC vehicle;

	public RidingNpc(ClashGame game, ClashPlayer player, int level) {
		super(game, player, level);
	}
	
	@Override
	public void spawn(Location loc) {
		vehicle = REG.createNPC(getVehicleType(), getName());
		
		//TODO: Give goal
	}
	
	@Override
	public void despawn() {
		super.despawn();
		vehicle.destroy();
	}
	
	public abstract EntityType getVehicleType();
}
