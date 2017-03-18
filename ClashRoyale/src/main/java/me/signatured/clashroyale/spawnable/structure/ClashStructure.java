package me.signatured.clashroyale.spawnable.structure;

import java.io.File;

import org.bukkit.Location;

import lombok.Data;
import lombok.EqualsAndHashCode;
import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.ClashRoyale;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.spawnable.ClashRarity;
import me.signatured.clashroyale.spawnable.ClashSpawnable;
import me.signatured.clashroyale.util.schematic.Schematic;
import me.signatured.clashroyale.util.schematic.SchematicUtil;

@Data
@EqualsAndHashCode(callSuper=false)
public abstract class ClashStructure extends ClashSpawnable {
		
	private ClashRarity rarity;
	private Location loc;
	private Schematic schematic;
	private int level;
	private int health;
		
	public ClashStructure(ClashGame game, ClashPlayer player, int level, ClashRarity rarity) {
		super(game, player, level);
		this.rarity = rarity;
		
		loadSchematic();
	}
	
	public void place() {
		//TODO: Place
	}
	
	private File getSchematicFile() {
		return new File(ClashRoyale.getInstance().getDataFolder() + "/" + getKey().toLowerCase() + ".schematic");
	}
	
	private Schematic attemptLoadSchematic() throws Exception {
		return SchematicUtil.load(getSchematicFile());
	}
	
	private void loadSchematic() {
		try {
			schematic = attemptLoadSchematic();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
