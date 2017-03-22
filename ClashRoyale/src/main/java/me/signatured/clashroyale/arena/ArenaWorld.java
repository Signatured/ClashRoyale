package me.signatured.clashroyale.arena;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.World;

import lombok.Getter;

@Getter
public class ArenaWorld {
	
	@Getter
	private static List<ArenaWorld> worlds = new ArrayList<>();
	
	private ArenaType type;
	private World world;
	
	public ArenaWorld(ArenaType type) {
		this.type = type;
		this.world = type.loadWorld();
		world.setTime(6000);
		world.setGameRuleValue("doDaylightCycle", "false");
		
		worlds.add(this);
	}
	
	public static ArenaWorld getWorld(ArenaType type) {
		return worlds.stream().filter(w -> w.getType() == type).findAny().orElse(null);
	}
}
