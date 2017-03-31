package me.signatured.clashroyale.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.ChunkSnapshot;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.spawnable.ClashSpawnable;
import me.signatured.clashroyale.spawnable.types.IDamageableSpawnable;
import me.signatured.clashroyale.spawnable.types.ILocatable;
import me.signatured.clashroyale.util.task.Sync;
import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.npc.skin.SkinnableEntity;
import net.minecraft.server.v1_8_R3.BlockPosition;
import net.minecraft.server.v1_8_R3.IBlockData;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;

public class ClashUtil {
	
	public static Random RANDOM = new Random();
	public static final BlockFace[] RADIAL = {BlockFace.WEST, BlockFace.NORTH_WEST, BlockFace.NORTH, BlockFace.NORTH_EAST, BlockFace.EAST, BlockFace.SOUTH_EAST, BlockFace.SOUTH, BlockFace.SOUTH_WEST};
	private static final EnumMap<BlockFace, Integer> notches = new EnumMap<BlockFace, Integer>(BlockFace.class);

    static {
        for (int i = 0; i < RADIAL.length; i++)
            notches.put(RADIAL[i], i);
    }
    
    /**
     * Gets the Notch integer representation of a BlockFace<br>
     * <b>These are the horizontal faces, which exclude up and down</b>
     *
     * @param face to get
     * @return Notch of the face
     */
    public static int faceToNotch(BlockFace face) {
        Integer notch = notches.get(face);
        return notch == null ? 0 : notch.intValue();
    }
    
    /**
     * Gets the angle from a horizontal Block Face
     *
     * @param face to get the angle for
     * @return face angle
     */
    public static int faceToYaw(final BlockFace face) {
        return wrapAngle(45 * faceToNotch(face));
    }
    
    /**
     * Wraps the angle to be between -180 and 180 degrees
     *
     * @param angle to wrap
     * @return [-180 > angle >= 180]
     */
    public static int wrapAngle(int angle) {
        int wrappedAngle = angle;
        while (wrappedAngle <= -180)
            wrappedAngle += 360;
        
        while (wrappedAngle > 180)
            wrappedAngle -= 360;
        return wrappedAngle;
    }
	
	/**
	 * Apply skin of player given to NPC
	 */
	public static void applySkin(NPC npc, String skinName) {
		npc.data().setPersistent(NPC.PLAYER_SKIN_UUID_METADATA, skinName);
		
		if (npc.isSpawned()) {
			SkinnableEntity skinnable = npc.getEntity() instanceof SkinnableEntity ? (SkinnableEntity) npc.getEntity()
					: null;
			if (skinnable != null)
				skinnable.setSkinName(skinName);
		}
	}
	
	/**
	 * @return List from given args
	 */
	@SafeVarargs
	public static <T> List<T> getList(T... args) {
		List<T> list = new ArrayList<>();
		
		for (T arg : args)
			list.add(arg);
		
		return list;
	}
	
	/**
	 * @return A random entry in the list.
	 */
	public static <T> T getRandomEntry(List<T> list) {
		return list.get(random(list.size()));
	}
	
	/**
	 * @return A random entry in the list excluding those given.
	 */
	@SafeVarargs
	public static <T> T getRandomEntry(List<T> list, T... excluding) {
		for (T exclude : excluding)
			list.remove(exclude);
		
		return getRandomEntry(list);
	}
	
	/**
	 * @return A random entry in the arguments.
	 */
	@SafeVarargs
	public static <T> T getRandomEntry(T... args) {
		return args[random(args.length)];
	}
	
	/**
	 * @return A random entry in the arguments excluding those given.
	 */
	@SafeVarargs
	public static <T> T getRandomEntry(T[] args, T... excluding) {
		List<T> list = new ArrayList<>();
		List<T> excludeList = Arrays.asList(excluding);
		
		for (T arg : args) {
			if (!excludeList.contains(arg))
				list.add(arg);
		}
		
		return getRandomEntry(list);
	}
	
	/**
	 * @return The string converted to a location. Format: world,x,y,z
	 */
	public static Location deserializeLoc(String loc) {
		String[] parts = loc.split(",");
		return new Location(Bukkit.getWorld(parts[0]), Double.valueOf(parts[1]), Double.valueOf(parts[2]), Double.valueOf(parts[3]));
	}
	
	/**
	 * @return The location converted to a string. 
	 */
	public static String serializeLoc(Location loc) {
		return loc.getWorld().getName() + "," + loc.getX() + "," + loc.getY() + "," + loc.getZ();
	}
	
	/**
	 * @return A string representation of a time
	 */
	public static String getTime(long millis) {
		long second = (millis / 1000) % 60;
		long minute = (millis / (1000 * 60)) % 60;
		long hour = (millis / (1000 * 60 * 60)) % 24;
		
		if (hour == 0)
			return String.format("%02dm:%02ds", minute, second);

		return String.format("%02dh:%02dm:%02ds", hour, minute, second);
	}
	
	/**
	 * @param worldName World to copy
	 * @param newLocation New file location/world name
	 * @param ignore Files to ignore
	 */
	public static void copyWorld(String worldName, String newLocation, String... ignore) {
		File worldFile = new File(worldName);
		File copyFile = new File(newLocation);
		
		if (!copyFile.exists())
			copyFile.mkdir();
		
		try {
			FileUtils.copyDirectory(worldFile, copyFile);
			
			for (File file : copyFile.listFiles()) {
				if (Arrays.asList(ignore).contains(file.getName()))
					file.delete();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @param player Player to send message to
	 * @param message Message to send in actionbar
	 */
	public static void actionbar(Player player, String message) {
		IChatBaseComponent icbc = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + C.translate(message) + "\"}");
		PacketPlayOutChat bar = new PacketPlayOutChat(icbc, (byte) 2);
		((CraftPlayer) player).getHandle().playerConnection.sendPacket(bar);
	}
	
	/**
	 * Find all blocks of the given types in a chunk
	 * 
	 * @param chunk Chuck to search
	 * @param materials Material to look for
	 * @return List of blocks with materials given
	 */
	public static List<Block> findBlocks(Chunk chunk, Material... materials) {
		List<Block> chunkBlocks = getBlocks(chunk);
		List<Block> found = new ArrayList<>();
		
		for (Block block : chunkBlocks) {
			for (Material mat : materials)
				if (block.getType() == mat) {
					found.add(block);
					break;
				}
		}
		return found;
	}
	
	/**
	 * Collect all blocks from a chunk
	 * 
	 * @param chunk Chunk to collect blocks from
	 * @return List of blocks
	 */
	public static List<Block> getBlocks(Chunk chunk) {
		List<Block> blocks = new ArrayList<>();
		for (int x = 0; x < 16; x++)
			for (int z = 0; z < 16; z++)
				for (int y = 0; y < 128; y++)
					blocks.add(chunk.getBlock(x, y, z));
		return blocks;
	}
	
	/**
	 * Load in chunks temp using constructor to use live chunk
	 * 
	 * @param center Center location
	 * @param chunks Radius of chunks to load in
	 * @param consumer What to do with loaded chunk
	 */
	public static void loadChunks(Location center, int chunks, Consumer<Chunk> consumer) {
		World world = center.getWorld();
		for (int x = -chunks; x <= chunks; x++) {
			for (int z = -chunks; z <= chunks; z++) {
				loadChunkTemporarily(world,  x,  z, consumer);
			}
		}
	}
	
	/**
	 * Load in a chunk, perform a consumer then unload it again
	 * 
	 * @param world World to load chunk in
	 * @param x Position of chunk
	 * @param z Position of chunk
	 * @param consumer What to run before unloading again
	 */
	public static void loadChunkTemporarily(World world, int x, int z, Consumer<Chunk> consumer) {
		boolean wasLoaded = world.isChunkLoaded(x, z);
		consumer.accept(world.getChunkAt(x, z));
		
		if (!wasLoaded)
			world.unloadChunk(x, z, false);
	}
	
	/**
	 * Efficient way to search chunk via ChunkSnapshot
	 * 
	 * @param chunk
	 * @param materials
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static List<Block> findBlocks(ChunkSnapshot chunk, Material... materials) {
		List<Block> result = new LinkedList<>();
		List<Material> mats = Arrays.asList(materials);
		
		boolean checkMaterials = !mats.isEmpty();
		
		for (int x = 0; x != 16; x++)
			for (int z = 0; z != 16; z++)
				for (int y = 0; y != 256; y++) {
					Material m = Material.getMaterial(chunk.getBlockTypeId(x, y, z));
					if (!checkMaterials || mats.contains(m)) {
						int absX = chunk.getX() * 16 + x;
						int absZ = chunk.getZ() * 16 + z;
						result.add(new Location(Bukkit.getWorld(chunk.getWorldName()), absX, y, absZ).getBlock());
					}
				}
		
		return result;
	}
	
	/**
	 * Sets the type of a block quickly
	 * 
	 * @param block Block to set type
	 * @param type Type to set
	 * @param data Data to set (default 0)
	 */
	public static void setTypeQuick(Block block, Material type, int data) {
		setTypeQuick(block.getLocation(), type, data);
	}
	
	/**
	 * Sets the type of a location quickly
	 * 
	 * @param loc Location to set type
	 * @param type Type to set
	 * @param data Data to set (default 0)
	 */
	@SuppressWarnings("deprecation")
	public static void setTypeQuick(Location loc, Material type, int data) {

		World world = loc.getWorld();
		
		int x = loc.getBlockX();
		int y = loc.getBlockY();
		int z = loc.getBlockZ();
		
		net.minecraft.server.v1_8_R3.Chunk chunk = getChunk(world, x, z);
        
        BlockPosition bp = new BlockPosition(x, y, z);
        
        int combined = type.getId() + (data << 12);
        
        IBlockData ibd = net.minecraft.server.v1_8_R3.Block.getByCombinedId(combined);
        
        Runnable change = () -> chunk.getWorld().setTypeAndData(bp, ibd, 2); // 2 == Dont update physics.
        
        if (!Bukkit.isPrimaryThread())
        	Sync.get().run(change);
        else
        	change.run();
        
        Bukkit.getOnlinePlayers().forEach(p -> p.sendBlockChange(new Location(world, x, y, z), type, (byte) data));
	}
	
	/**
	 * Get a net.minecraft.server.v1_8_R3.Chunk via coords
	 * 
	 * @param world Bukkit world
	 * @param x X coordinate
	 * @param z Z coordinate
	 * @return net.minecraft.server.v1_8_R3.Chunk
	 */
	public static net.minecraft.server.v1_8_R3.Chunk getChunk(org.bukkit.World world, int x, int z) {
		
		CraftWorld cw = (CraftWorld) world;
		
        net.minecraft.server.v1_8_R3.World w = cw.getHandle();
        net.minecraft.server.v1_8_R3.Chunk chunk = w.getChunkAt(x >> 4, z >> 4);
        
		return chunk;
	}
	
	/**
	 * Get a list of spawnables in a specified game in a given range
	 */
	public static List<ClashSpawnable> getSpawnablesInRange(ClashGame game, Location loc, double radius) {
		List<ClashSpawnable> spawnables = new ArrayList<>();
		for (ClashSpawnable s : game.getSpawnables()) {
			if (s instanceof ILocatable && s instanceof IDamageableSpawnable) {
				ILocatable locatable = (ILocatable) s;
				
				if (locatable.getLocation() != null && locatable.getLocation().distance(loc) <= radius)
					spawnables.add(s);
			}
		}
		return spawnables;
	}
	
	/**
	 * Get a list of spawnables in a specified game in a given range and owner
	 */
	public static List<ClashSpawnable> getSpawnablesInRange(ClashPlayer owner, Location loc, double radius) {
		List<ClashSpawnable> spawnables = getSpawnablesInRange(owner.getGame(), loc, radius);
		return spawnables.stream().filter(s -> s.getPlayer().equals(owner)).collect(Collectors.toList());
	}
	
	/**
	 * @param max The maximum number to return (non-inclusive).
	 * @return A number in the range of [0, max).
	 */
	public static int random(int max) {
		return RANDOM.nextInt(max);
	}
}
