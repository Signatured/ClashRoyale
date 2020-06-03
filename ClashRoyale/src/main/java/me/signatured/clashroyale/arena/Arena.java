package me.signatured.clashroyale.arena;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Sign;

import lombok.AllArgsConstructor;
import lombok.Getter;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.util.ClashUtil;
import me.signatured.clashroyale.util.shape.Cuboid;
import me.signatured.clashroyale.util.task.Sync;

@Getter
public class Arena {
	
	private static int id = 0;
	
	private ClashGame game;
	private ArenaType type;
	private World world;
	private boolean loaded = false;
	
	public Arena(ClashGame game, ArenaWorld arenaWorld) {
		this.game = game;
		this.type = arenaWorld.getType();
		
		loadWorld(arenaWorld);
	}
	
	public void loadWorld(ArenaWorld arenaWorld) {
		int arenaId = id++;
		
		ClashUtil.copyWorld(arenaWorld.getWorld().getName(), "GAME_ARENA_" + arenaId, "uid.dat", "session.lock");
		world = Bukkit.createWorld(new WorldCreator("GAME_ARENA_" + arenaId));
		
		findSigns();
		finish();
	}
	
	public void unloadWorld() {
		ClashUtil.deleteWorld(world);
	}
	
	private void findSigns() {
		List<Block> signs = new ArrayList<>();
		ClashUtil.loadChunks(new Location(world, -216, 64, -189), 30, c -> {
			for (Block block : ClashUtil.findBlocks(c, Material.OAK_SIGN, Material.OAK_WALL_SIGN))
				if (!signs.contains(block))
					signs.add(block);
		});
		
		System.out.println(signs.size());
		
		Cuboid main1 = findCuboid("main", "1", signs);
		Cuboid rightlane1 = findCuboid("rightlane", "1", signs);
		Cuboid leftlane1 = findCuboid("leftlane", "1", signs);
		Cuboid main2 = findCuboid("main", "2", signs);
		Cuboid rightlane2 = findCuboid("rightlane", "2", signs);
		Cuboid leftlane2 = findCuboid("leftlane", "2", signs);
		SpawnLocation spawn1 = getSpawn("1", signs);
		SpawnLocation spawn2 = getSpawn("2", signs);
		
		game.getPlayer1().setData(new ArenaData(game.getPlayer1().getPlayer(), main1, rightlane1, leftlane1, spawn1));
		game.getPlayer2().setData(new ArenaData(game.getPlayer2().getPlayer(), main2, rightlane2, leftlane2, spawn2));
		
		for (Block sign : signs)
			sign.setType(Material.AIR);
	}
	
	private void finish() {
		Sync.get().run(() -> {
			loaded = true;
			
			game.setArena(this);
			game.begin();
		});
	}
	
	private Cuboid findCuboid(String region, String id, List<Block> signs) {
		Location corner1 = null;
		Location corner2 = null;
		
		for (Block block : signs) {
			Sign sign = (Sign) block.getState();
			
			if (sign.getLine(0).equalsIgnoreCase(region) && sign.getLine(1).equals(id)) {
				if (corner1 == null)
					corner1 = sign.getLocation();
				else {
					corner2 = sign.getLocation();
					break;
				}
			}
		}
		
		return new Cuboid(corner1, corner2);
	}
	
	private SpawnLocation getSpawn(String id, List<Block> signs) {
		Sign sign = signs.stream().map(s -> ((Sign)s.getState())).filter(s -> s.getLine(0).equalsIgnoreCase("spawn") && s.getLine(1).equals(id)).findAny().orElse(null);
		org.bukkit.material.Sign matSign = (org.bukkit.material.Sign) sign.getData();
		
		SpawnLocation loc = new SpawnLocation(sign.getLocation(), ClashUtil.faceToYaw(matSign.getFacing()));
		signs.remove(sign.getBlock());
		
		sign.setType(Material.AIR);
		sign.getBlock().getRelative(BlockFace.DOWN).setType(Material.AIR);
		
		return loc;
	}
	
	@Getter
	@AllArgsConstructor
	public class SpawnLocation {
		private Location loc;
		private float yaw;
	}
}
