package me.signatured.clashroyale.game.arena;

import org.bukkit.Location;

import lombok.Getter;
import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.util.shape.Cuboid;

@Getter
public class ClashArenaData {
	
	private ClashPlayer player;
	private Cuboid main, lane1, lane2;
	private boolean lane1Destroyed = false, lane2Destroyed = false;
	
	public ClashArenaData(ClashPlayer player, Cuboid main, Cuboid lane1, Cuboid lane2) {
		this.player = player;
		this.main = main;
		this.lane1 = lane1;
		this.lane2 = lane2;
	}
	
	public boolean canPlace(ClashPlayer player, Location loc) {
		if (this.player.equals(player) && contains(loc))
			return true;
		
		if (!this.player.equals(player)) {
			if ((lane1Destroyed && lane1.contains(loc)) || (lane2Destroyed && lane2.contains(loc)))
				return true;
		}
		
		return false;
	}
	
	private boolean contains(Location loc) {
		return main.contains(loc) || lane1.contains(loc) || lane2.contains(loc);
	}
}
