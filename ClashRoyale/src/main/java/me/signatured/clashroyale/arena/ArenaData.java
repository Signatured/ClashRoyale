package me.signatured.clashroyale.arena;

import org.bukkit.Location;

import lombok.Data;
import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.arena.Arena.SpawnLocation;
import me.signatured.clashroyale.util.shape.Cuboid;

@Data
public class ArenaData {
	
	private ClashPlayer player;
	private Cuboid main, rightLane, leftLane;
	private boolean rightLaneDestroyed = false, leftLaneDestroyed = false;
	private Location spawn;
	private float yaw;
	
	public ArenaData(ClashPlayer player, Cuboid main, Cuboid rightLane, Cuboid leftLane, SpawnLocation spawnLoc) {
		this.player = player;
		this.main = main;
		this.rightLane = rightLane;
		this.leftLane = leftLane;
		this.spawn = spawnLoc.getLoc();
		this.yaw = spawnLoc.getYaw();
		
		spawn.setYaw(yaw);
	}
	
	public boolean canPlace(ClashPlayer player, Location loc) {
		if (this.player.equals(player) && contains(loc))
			return true;
		
		if (!this.player.equals(player)) {
			if ((rightLaneDestroyed && rightLane.contains(loc)) || (leftLaneDestroyed && leftLane.contains(loc)))
				return true;
		}
		
		return false;
	}
	
	private boolean contains(Location loc) {
		return main.contains(loc) || rightLane.contains(loc) || leftLane.contains(loc);
	}
}
