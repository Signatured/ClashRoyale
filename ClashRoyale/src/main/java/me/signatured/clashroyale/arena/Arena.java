package me.signatured.clashroyale.arena;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;

import com.boydti.fawe.bukkit.wrapper.AsyncWorld;
import com.boydti.fawe.util.TaskManager;

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
	
	private void loadWorld(ArenaWorld arenaWorld) {
		TaskManager.IMP.async(new Runnable() {
			@Override
			public void run() {
				int arenaId = id++;
				
				ClashUtil.copyWorld(arenaWorld.getWorld().getName(), "ARENA_" + arenaId, "uid.dat", "session.dat");
				AsyncWorld arenaWorld = AsyncWorld.create(new WorldCreator("ARENA_" + arenaId));
				arenaWorld.commit();
				
				world = arenaWorld.getBukkitWorld();
				findSigns();
				finish();
			}
		});
	}
	
	private void findSigns() {
		List<Block> signs = new ArrayList<>();
		ClashUtil.loadChunks(world.getSpawnLocation(), 20, c -> {
			for (Block block : ClashUtil.findBlocks(c.getChunkSnapshot(), Material.SIGN, Material.SIGN_POST, Material.WALL_SIGN))
				if (!signs.contains(block))
					signs.add(block);
		});
		
		Cuboid main1 = findCuboid("main", "1", signs);
		Cuboid rightlane1 = findCuboid("rightlane", "1", signs);
		Cuboid leftlane1 = findCuboid("leftlane", "1", signs);
		Cuboid main2 = findCuboid("main", "2", signs);
		Cuboid rightlane2 = findCuboid("rightlane", "2", signs);
		Cuboid leftlane2 = findCuboid("leftlane", "2", signs);
		
		game.getPlayer1().setData(new ArenaData(game.getPlayer1().getPlayer(), main1, rightlane1, leftlane1));
		game.getPlayer2().setData(new ArenaData(game.getPlayer2().getPlayer(), main2, rightlane2, leftlane2));
		
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
}
