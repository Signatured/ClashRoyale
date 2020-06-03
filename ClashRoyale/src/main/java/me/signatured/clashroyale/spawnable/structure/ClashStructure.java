package me.signatured.clashroyale.spawnable.structure;

import java.io.File;

import me.signatured.clashroyale.util.schematic.*;
import org.bukkit.Location;

import lombok.Data;
import lombok.EqualsAndHashCode;
import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.ClashRoyale;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.spawnable.ClashRarity;
import me.signatured.clashroyale.spawnable.ClashSpawnable;
import me.signatured.clashroyale.spawnable.types.IClashStructure;

@Data
@EqualsAndHashCode(callSuper=false)
public abstract class ClashStructure extends ClashSpawnable implements IClashStructure {
		
	private ClashRarity rarity;
	private Location loc;
	private Schem schematic;
	private int level;
	private int health;
		
	public ClashStructure(ClashGame game, ClashPlayer player, int level, ClashRarity rarity) {
		super(game, player, level);
		this.rarity = rarity;
		
		loadSchematic();
	}
	
	//TODO: point in correct direction, center, etc
	public void place(Location loc) {
		this.loc = loc;
		schematic.place(loc);
	}
	
	@Override
	public void damage(int amount) {
		health = Math.max(0, health - amount);
		
		if (health <= 0)
			onDeath();
	}
	
	@Override
	public void onDeath() {
		
	}
	
	@Override
	public double getHealthPercent() {
		return ((double) health / calcHealth()) * 100;
	}
	
	@Override
	public Location getLocation() {
		return loc;
	}
	
	private int calcHealth() {
		return (int) ((getBaseHealth() * getLevelMultiplier()) + getBaseHealth());
	}
	
	private String getSchematicName() {
		return getKey().toLowerCase();
	}
	
	private Schem attemptLoadSchematic() throws Exception {
		return Schem.loadSchematic(getSchematicName());
	}
	
	private void loadSchematic() {
		try {
			schematic = attemptLoadSchematic();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
