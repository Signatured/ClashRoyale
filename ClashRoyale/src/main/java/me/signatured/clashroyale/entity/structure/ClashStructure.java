package me.signatured.clashroyale.entity.structure;

import org.bukkit.Location;

import lombok.Data;
import lombok.EqualsAndHashCode;
import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.entity.ClashSpawnable;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.util.schematic.Schematic;

@Data
@EqualsAndHashCode(callSuper=false)
public abstract class ClashStructure extends ClashSpawnable {
	
	private StructureType structureType;
	private Location loc;
	private int level;
	private int health;
		
	public ClashStructure(ClashGame game, ClashPlayer player, StructureType structureType, Location loc) {
		super(game, player);
		this.structureType = structureType;
		this.loc = loc;
	}
	
	public void loadSchematic() {
		try {
			Schematic schem = structureType.getSchematic();
			schem.place(loc);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
