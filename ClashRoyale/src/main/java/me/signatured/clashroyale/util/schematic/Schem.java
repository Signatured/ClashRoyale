package me.signatured.clashroyale.util.schematic;

import com.sk89q.worldedit.*;
import com.sk89q.worldedit.bukkit.*;
import com.sk89q.worldedit.extent.clipboard.*;
import com.sk89q.worldedit.extent.clipboard.io.*;
import com.sk89q.worldedit.math.*;
import com.sk89q.worldedit.world.block.*;
import org.bukkit.*;
import org.bukkit.util.Vector;

import java.io.*;
import java.util.*;

public class Schem {
	public final Map<Vector, BlockState> map = new LinkedHashMap<>();
	public final Vector min, max;
	public final int hashCode;

	public static WorldEditPlugin worldEdit() {
		return (WorldEditPlugin) Bukkit.getPluginManager().getPlugin("WorldEdit");
	}

	public static Schem loadSchematic(String name) throws Exception {
		WorldEdit worldEdit = worldEdit().getWorldEdit();
		LocalConfiguration config = worldEdit.getConfiguration();

		File dir = worldEdit.getWorkingDirectoryFile(config.saveDir);

		for (ClipboardFormat format : BuiltInClipboardFormat.values()) {
			File file = worldEdit.getSafeOpenFile(null, dir, name, format.getPrimaryFileExtension(), format.getFileExtensions().toArray(new String[0]));
			if (file.isFile()) {
				try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(file))) {
					ClipboardReader reader = format.getReader(in);
					return new Schem(reader.read());
				}
			}
		}

		throw new FileNotFoundException("SCHEMATIC: " + name);
	}

	public Schem(Clipboard clipboard) {
		BlockVector3 v_min = clipboard.getMinimumPoint();
		BlockVector3 v_max = clipboard.getMaximumPoint();
		BlockVector3 v_center = clipboard.getOrigin();

		Vector min = new Vector(v_min.getBlockX(), v_min.getBlockY(), v_min.getBlockZ());
		Vector max = new Vector(v_max.getBlockX(), v_max.getBlockY(), v_max.getBlockZ());
		Vector center = new Vector(v_center.getBlockX(), v_center.getBlockY(), v_center.getBlockZ());

		for (int x = min.getBlockX(); x <= max.getBlockX(); ++x) {
			for (int y = min.getBlockY(); y <= max.getBlockY(); ++y) {
				for (int z = min.getBlockZ(); z <= max.getBlockZ(); ++z) {
					BlockState state = clipboard.getBlock(BlockVector3.at(x, y, z));
					if (state != null) {
						map.put(new Vector(x, y, z).subtract(center), state);
					}
				}
			}
		}

		this.min = min.subtract(center);
		this.max = max.subtract(center);

		int k = map.hashCode();
		k = k * 257 + min.hashCode();
		k = k * 257 + max.hashCode();
		hashCode = k;
	}

	public Vector realMin() {
		return min;
	}

	public Vector realMax() {
		return max;
	}

	public Vector size() {
		return realMax().subtract(realMin()).add(new Vector(1, 1, 1));
	}

	public Vector sizeA() {
		return realMax().subtract(realMin());
	}

	public void place(Location loc) {
		try {
			paste(loc.getWorld(), loc.toVector(), true, true);
		} catch (WorldEditException e) {
			e.printStackTrace();
		}
	}

	public void place(World world, Vector offset, Vector pos, boolean notifyAndLight) throws WorldEditException {
		BlockState state = map.get(pos);
		if (state == null)
			return;

		BukkitWorld bukkitWorld = new BukkitWorld(world);

		Vector v = pos.add(offset);
		bukkitWorld.setBlock(BlockVector3.at(v.getBlockX(), v.getBlockY(), v.getBlockZ()), state, notifyAndLight);
	}

	public void paste(World world, Vector offset, boolean notifyAndLight) throws WorldEditException {
		paste(world, offset, notifyAndLight, true);
	}

	public void paste(World world, Vector offset, boolean notifyAndLight, boolean setAir) throws WorldEditException {
		BukkitWorld bukkitWorld = new BukkitWorld(world);

		for (Map.Entry<Vector, BlockState> e : map.entrySet()) {
			Vector pos = e.getKey();
			BlockState state = e.getValue();

			if (!setAir && state.getBlockType().getMaterial().isAir())
				continue;

			Vector v = pos.add(offset);
			bukkitWorld.setBlock(BlockVector3.at(v.getBlockX(), v.getBlockY(), v.getBlockZ()), state, notifyAndLight);
		}
	}

	@Override
	public String toString() {
		return "Schem[" + "min=" + min + ", " + "max=" + max + ", " + "map.size()=" + map.size() + ", " + "map.hashCode()=" + map.hashCode() + ", " + "hashCode=" + hashCode() + "]";
	}

	@Override
	public int hashCode() {
		return hashCode;
	}

	@Override
	public boolean equals(Object other) {
		if (other == this)
			return true;
		if (!(other instanceof Schem))
			return false;
		Schem o = (Schem) other;
		return Objects.equals(min, o.min) && Objects.equals(max, o.max) && Objects.equals(map, o.map);
	}
}
