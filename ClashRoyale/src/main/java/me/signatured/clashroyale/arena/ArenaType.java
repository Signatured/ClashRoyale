package me.signatured.clashroyale.arena;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldCreator;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ArenaType {
	
	ARENA_1("Goblin Statium", 0),
	ARENA_2("Bone Pit", 400),
	ARENA_3("Barbarian Bowl", 800),
	ARENA_4("P.E.K.K.A's Playhouse", 1100),
	ARENA_5("Spell Valley", 1400),
	ARENA_6("Builder's Workshop", 1700),
	ARENA_7("Royale Arena", 2000),
	ARENA_8("Frozen Peak", 2300),
	ARENA_9("Jungle Arena", 2600),
	ARENA_10("Hog Mountain", 3000),
	ARENA_11("Legendary Arena", 3800);
	
	private String name;
	private int trophyReq;
	
	public static void loadArenaWorlds() {
		new ArenaWorld(ArenaType.ARENA_1);
//		Arrays.asList(values()).forEach(a -> new ArenaWorld(a));
	}
	
	public ArenaWorld getArenaWorld() {
		return ArenaWorld.getWorld(this);
	}
	
	public String getWorldName() {
		return name().toLowerCase();
	}
	
	public boolean shouldDemote(int trophies) {
		return canBeDemoted() && trophies < (trophyReq - 50);
	}
	
	public boolean canBeDemoted() {
		return this != ARENA_1;
	}
	
	public World loadWorld() {
		return Bukkit.createWorld(new WorldCreator(getWorldName()));
	}

}
