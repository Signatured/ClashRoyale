package me.signatured.clashroyale.spawnable.npc;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.game.ClashGame;

public abstract class RidingNpc extends ClashNpc {

	public RidingNpc(ClashGame game, ClashPlayer player, int level) {
		super(game, player, level);
	}
	
	@Override
	public void spawn(Location loc) {
		//TODO: Spawn vehicle, give goal
	}
	
	public abstract EntityType getVehicleType();
}
