package me.signatured.clashroyale.util.schematic;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;

import org.bukkit.util.BlockVector;
import org.bukkit.util.Vector;

import me.signatured.clashroyale.util.schematic.nbt.ByteArrayTag;
import me.signatured.clashroyale.util.schematic.nbt.CompoundTag;
import me.signatured.clashroyale.util.schematic.nbt.IntTag;
import me.signatured.clashroyale.util.schematic.nbt.ListTag;
import me.signatured.clashroyale.util.schematic.nbt.NBTInputStream;
import me.signatured.clashroyale.util.schematic.nbt.NBTUtils;
import me.signatured.clashroyale.util.schematic.nbt.ShortTag;
import me.signatured.clashroyale.util.schematic.nbt.StringTag;
import me.signatured.clashroyale.util.schematic.nbt.Tag;

public class SchematicUtil {
	
	/**
	 * Load the schematic from a file
	 *
	 * @param file
	 * @return the loaded schematic
	 * @throws Exception
	 */
	public static Schematic load(File file) throws Exception {
		return SchematicUtil.load(new FileInputStream(file));
	}

	/**
	 * Load the schematic from an input stream
	 *
	 * @param stream
	 * @return the loaded schematic
	 * @throws Exception
	 */
	public static Schematic load(InputStream stream) throws Exception {
		NBTInputStream nbtStream = new NBTInputStream(new GZIPInputStream(stream));
		Vector origin = new Vector();
		Vector offset = new Vector();
		// Schematic tag
		CompoundTag schematicTag = (CompoundTag) nbtStream.readTag();
		nbtStream.close();
		if (!schematicTag.getName().equals("Schematic"))
			throw new Exception("Tag \"Schematic\" does not exist or is not first");
		// Check
		Map<String, Tag> schematic = schematicTag.getValue();
		if (!schematic.containsKey("Blocks"))
			throw new Exception("Schematic file is missing a \"Blocks\" tag");
		// Get information
		short width = NBTUtils.getChildTag(schematic, "Width", ShortTag.class).getValue();
		short length = NBTUtils.getChildTag(schematic, "Length", ShortTag.class).getValue();
		short height = NBTUtils.getChildTag(schematic, "Height", ShortTag.class).getValue();
		try {
			int originX = NBTUtils.getChildTag(schematic, "WEOriginX", IntTag.class).getValue();
			int originY = NBTUtils.getChildTag(schematic, "WEOriginY", IntTag.class).getValue();
			int originZ = NBTUtils.getChildTag(schematic, "WEOriginZ", IntTag.class).getValue();
			origin = new Vector(originX, originY, originZ);
		} catch (Exception e) {
			// No origin data
		}
		try {
			int offsetX = NBTUtils.getChildTag(schematic, "WEOffsetX", IntTag.class).getValue();
			int offsetY = NBTUtils.getChildTag(schematic, "WEOffsetY", IntTag.class).getValue();
			int offsetZ = NBTUtils.getChildTag(schematic, "WEOffsetZ", IntTag.class).getValue();
			offset = new Vector(offsetX, offsetY, offsetZ);
		} catch (Exception e) {
			// No offset data
		}
		// Check type of Schematic
		String materials = NBTUtils.getChildTag(schematic, "Materials", StringTag.class).getValue();
		if (!materials.equals("Alpha"))
			throw new Exception("Schematic file is not an Alpha schematic");
		// Get blocks
		byte[] blockId = NBTUtils.getChildTag(schematic, "Blocks", ByteArrayTag.class).getValue();
		byte[] blockData = NBTUtils.getChildTag(schematic, "Data", ByteArrayTag.class).getValue();
		byte[] addId = new byte[0];
		short[] blocks = new short[blockId.length]; // Have to later combine IDs
		// We support 4096 block IDs using the same method as vanilla Minecraft,
		// where
		// the highest 4 bits are stored in a separate byte array.
		if (schematic.containsKey("AddBlocks"))
			addId = NBTUtils.getChildTag(schematic, "AddBlocks", ByteArrayTag.class).getValue();
		// Combine the AddBlocks data with the first 8-bit block ID
		for (int index = 0; index < blockId.length; index++)
			if ((index >> 1) >= addId.length)
				blocks[index] = (short) (blockId[index] & 0xFF);
			else if ((index & 1) == 0)
				blocks[index] = (short) (((addId[index >> 1] & 0x0F) << 8) + (blockId[index] & 0xFF));
			else
				blocks[index] = (short) (((addId[index >> 1] & 0xF0) << 4) + (blockId[index] & 0xFF));
		// Need to pull out tile entities
		List<Tag> tileEntities = NBTUtils.getChildTag(schematic, "TileEntities", ListTag.class).getValue();
		Map<BlockVector, Map<String, Tag>> tileEntitiesMap = new HashMap<BlockVector, Map<String, Tag>>();
		for (Tag tag : tileEntities) {
			if (!(tag instanceof CompoundTag))
				continue;
			CompoundTag t = (CompoundTag) tag;
			int x = 0;
			int y = 0;
			int z = 0;
			Map<String, Tag> values = new HashMap<String, Tag>();
			for (Map.Entry<String, Tag> entry : t.getValue().entrySet()) {
				if (entry.getKey().equals("x")) {
					if (entry.getValue() instanceof IntTag)
						x = ((IntTag) entry.getValue()).getValue();
				} else if (entry.getKey().equals("y")) {
					if (entry.getValue() instanceof IntTag)
						y = ((IntTag) entry.getValue()).getValue();
				} else if (entry.getKey().equals("z"))
					if (entry.getValue() instanceof IntTag)
						z = ((IntTag) entry.getValue()).getValue();
				values.put(entry.getKey(), entry.getValue());
			}
			BlockVector vec = new BlockVector(x, y, z);
			tileEntitiesMap.put(vec, values);
		}
		Vector size = new Vector(width, height, length);
		Schematic scheme = new Schematic();
		scheme.setOffset(offset);
		scheme.setOrigin(origin);
		scheme.setSize(size);
		for (int x = 0; x < width; ++x)
			for (int y = 0; y < height; ++y)
				for (int z = 0; z < length; ++z) {
					int index = y * width * length + z * width + x;
					BlockVector pt = new BlockVector(x, y, z);
					StoredBlock block = new StoredBlock(blocks[index], blockData[index]);
					scheme.getBlocks().put(pt, block);
				}
		return scheme;
	}
}
