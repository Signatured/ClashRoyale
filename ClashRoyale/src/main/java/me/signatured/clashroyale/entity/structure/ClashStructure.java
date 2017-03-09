package me.signatured.clashroyale.entity.structure;

import org.bukkit.Location;

import lombok.Data;
import lombok.EqualsAndHashCode;
import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.entity.ClashSpawnable;
import me.signatured.clashroyale.game.ClashGame;

@Data
@EqualsAndHashCode(callSuper=false)
public abstract class ClashStructure extends ClashSpawnable {
	
	private StructureType structureType;
	private Location towerLoc;
	private int level;
	private int health;
		
	public ClashStructure(ClashGame game, ClashPlayer player, StructureType structureType, Location towerLoc) {
		super(game, player);
		this.structureType = structureType;
		this.towerLoc = towerLoc;
	}
}
