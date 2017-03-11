package me.signatured.clashroyale.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.npc.skin.SkinnableEntity;
import net.citizensnpcs.util.NMS;

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
	 * Shortcut of {@link Random#nextInt(int)}.
	 * @param max The maximum number to return (non-inclusive).
	 * @return A number in the range of [0, max).
	 */
	public static int random(int max) {
		return RANDOM.nextInt(max);
	}
}
