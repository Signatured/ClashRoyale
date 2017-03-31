package me.signatured.clashroyale.util.schematic;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.util.BlockVector;
import org.bukkit.util.Vector;

import me.signatured.clashroyale.util.ClashUtil;

public class Schematic {
	
	private HashMap<BlockVector, StoredBlock> blocks = new HashMap<>();
	private Vector size;
	private Vector origin;
	private Vector offset;
	private HashMap<BlockVector, ReplacedBlock> replaced = new HashMap<>();

	public Vector getOrigin() {
		return origin;
	}

	public void setOrigin(Vector origin) {
		this.origin = origin;
	}

	public Vector getOffset() {
		return offset;
	}

	public void setOffset(Vector offset) {
		this.offset = offset;
	}

	public HashMap<BlockVector, StoredBlock> getBlocks() {
		return blocks;
	}

	public HashMap<BlockVector, ReplacedBlock> getReplaced() {
		return replaced;
	}

	/**
	 * X = Width
	 * Y = Height
	 * Z = Length
	 */
	public Vector getSize() {
		return size;
	}

	public void setSize(Vector size) {
		this.size = size;
	}

	public StoredBlock getBlockAt(int x, int y, int z) {
		for (Entry<BlockVector, StoredBlock> set : blocks.entrySet())
			if (set.getKey().getX() == x && set.getKey().getZ() == z && set.getKey().getY() == y)
				return set.getValue();
		return null;
	}

	/**
	 * Place the schematic at the given location
	 *
	 * @param place
	 *            - The location to place the schematic at
	 * @param replaceAir
	 *            - Whether to replace an existing block with air if the
	 *            schematic has an air block
	 *            Example: If a schematic is made up of a 5x5x5 cube of AIR,
	 *            placing it will do nothing with replaceAir set to true
	 */
	@SuppressWarnings("deprecation")
	public void place(Location place, boolean replaceAir) {
		for (Entry<BlockVector, StoredBlock> set : getSolids()) {
			Location current = place.clone().add(set.getKey().getX(), set.getKey().getY(), set.getKey().getZ());
			StoredBlock storedBlock = set.getValue();
			Block block = current.getBlock();
			if (storedBlock == null || (!replaceAir && Material.getMaterial(storedBlock.blockId) == Material.AIR))
				continue;
			replaced.put(set.getKey(), new ReplacedBlock(block));
			ClashUtil.setTypeQuick(block, Material.getMaterial(storedBlock.blockId), storedBlock.data);
		}
		
		for (Entry<BlockVector, StoredBlock> set : getNonSolids()) {
			Location current = place.clone().add(set.getKey().getX(), set.getKey().getY(), set.getKey().getZ());
			StoredBlock storedBlock = set.getValue();
			Block block = current.getBlock();
			if (storedBlock == null || (!replaceAir && Material.getMaterial(storedBlock.blockId) == Material.AIR))
				continue;
			replaced.put(set.getKey(), new ReplacedBlock(block));
		}
	}
	
	public void place(Location place) {
		place(place, true);
	}
	
	public void rotate(int degree) {
		Vector newSize = size;
		{
			double x = size.getX();
			double z = size.getZ();
			double radians = Math.toRadians(degree);
			double newX = x * Math.cos(radians) - z * Math.sin(radians);
			double newZ = x * Math.sin(radians) + z * Math.cos(radians);
			newSize = new Vector(newX, size.getY(), newZ);
		}
		boolean negativeX = newSize.getX() < 0;
		boolean negativeZ = newSize.getZ() < 0;
		for (Entry<BlockVector, StoredBlock> set : blocks.entrySet()) {
			double x = set.getKey().getX();
			double z = set.getKey().getZ();
			double radians = Math.toRadians(degree);
			double newX = x * Math.cos(radians) - z * Math.sin(radians);
			double newZ = x * Math.sin(radians) + z * Math.cos(radians);
			if (negativeX)
				newX += size.getX();
			if (negativeZ)
				newZ += size.getZ();
			set.getKey().setX(newX);
			set.getKey().setZ(newZ);
		}
	}
	
	@SuppressWarnings("deprecation")
	private List<Entry<BlockVector, StoredBlock>> getNonSolids() {
		return blocks.entrySet().stream()
				.filter(e -> !Material.getMaterial(e.getValue().blockId).isSolid())
				.collect(Collectors.toCollection(LinkedList::new));
	}
	
	@SuppressWarnings("deprecation")
	private List<Entry<BlockVector, StoredBlock>> getSolids() {
		return blocks.entrySet().stream()
				.filter(e -> Material.getMaterial(e.getValue().blockId).isSolid())
				.collect(Collectors.toCollection(LinkedList::new));
	}
	
	public void remove() {
		getNonSolids().stream().map(Entry::getKey).map(replaced::get).forEach(ReplacedBlock::restore);
		getSolids().stream().map(Entry::getKey).map(replaced::get).forEach(ReplacedBlock::restore);
	}
	
	public static void cleanEntities(Location loc) {
		for (Entity e : loc.getWorld().getEntities())
			if (e instanceof Item && e.getLocation().distance(loc) < 1)
				e.remove();
	}

	/**
	 * Essentially a faux copy of a Block. Contains all the data necessary
	 * to change a Block to this.
	 */
	public static class ReplacedBlock {
		
		private Location location;
		private Material material;
		private byte data;

		@SuppressWarnings("deprecation")
		public ReplacedBlock(Block block) {
			location = block.getLocation();
			material = block.getType();
			data = block.getData();
		}

		/**
		 * Sets the given block to this block.
		 * @param block
		 */
		public void restore(Block block) {
			ClashUtil.setTypeQuick(block, material, data);
		}
		
		public void restore() {
			restore(location.getBlock());
			cleanEntities(location);
		}

		public Location getLocation() {
			return location;
		}

		public void setLocation(Location location) {
			this.location = location;
		}

		public Material getType() {
			return material;
		}

		public void setType(Material material) {
			this.material = material;
		}

		public byte getData() {
			return data;
		}

		public void setData(byte data) {
			this.data = data;
		}
	}
}
