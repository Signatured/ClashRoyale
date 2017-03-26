package me.signatured.clashroyale.arena;

import org.bukkit.Location;

import lombok.Data;
import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.util.shape.Cuboid;

@Data
public class ArenaData {
	
	private ClashPlayer player;
	private Cuboid main, rightLane, leftLane;
	private boolean rightLaneDestroyed = false, leftLaneDestroyed = false;
	
	public ArenaData(ClashPlayer player, Cuboid main, Cuboid rightLane, Cuboid leftLane) {
		this.player = player;
		this.main = main;
		this.rightLane = rightLane;
		this.leftLane = leftLane;
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
