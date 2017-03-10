package me.signatured.clashroyale.entity.structure;

import org.bukkit.Location;

import lombok.Getter;
import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.entity.npc.NpcType;
import me.signatured.clashroyale.game.ClashGame;
import net.citizensnpcs.api.npc.NPC;

@Getter
public class NpcStructure extends ClashStructure {
	
	private NpcType npcType;
	private NPC npc;
	private Location npcLoc;

	public NpcStructure(ClashGame game, ClashPlayer player, StructureType structureType, Location towerLoc, NpcType npcType, Location npcLoc) {
		super(game, player, structureType, towerLoc);
		this.npcType = npcType;
		this.npcLoc = npcLoc;
	}

	@Override
	public void spawn() {
		loadSchematic();
	}
	
	@Override
	public void despawn() {
		
	}

	@Override
	public void tick() {
		// Not really needed for NPC structures since NPCs handle everything
	}

}
