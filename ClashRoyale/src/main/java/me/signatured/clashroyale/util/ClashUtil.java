package me.signatured.clashroyale.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.npc.skin.SkinnableEntity;
import net.citizensnpcs.util.NMS;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;

public class ClashUtil {
	
	public static Random RANDOM = new Random();
	
	/**
	 * Apply skin of player given to NPC
	 */
	public static void applySkin(NPC npc, String skinName) {
		npc.data().setPersistent("player-skin-name", skinName);
		
		if (npc.isSpawned()) {
			SkinnableEntity skinnable = NMS.getSkinnable(npc.getEntity());
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
	 * Copy a worlds files to another destination for easy world duplication
	 * 
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
	
	public static void actionbar(Player player, String message) {
		IChatBaseComponent icbc = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + C.translate(message) + "\"}");
		PacketPlayOutChat bar = new PacketPlayOutChat(icbc, (byte) 2);
		((CraftPlayer) player).getHandle().playerConnection.sendPacket(bar);
	}
	
	/**
	 * Shortcut of {@link Random#nextInt(int)}.
	 * @param max The maximum number to return (non-inclusive).
	 * @return A number in the range of [0, max).
	 */
	public static int random(int max) {
		return RANDOM.nextInt(max);
	}
}
