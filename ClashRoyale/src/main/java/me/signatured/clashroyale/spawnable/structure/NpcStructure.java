package me.signatured.clashroyale.spawnable.structure;

import org.bukkit.Location;

import lombok.Getter;
import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.spawnable.ClashRarity;
import me.signatured.clashroyale.spawnable.types.INpcStructure;
import net.citizensnpcs.api.npc.NPC;

@Getter
public abstract class NpcStructure extends ClashStructure implements INpcStructure {
	
	private NPC npc;
	private Location npcLoc;

	public NpcStructure(ClashGame game, ClashPlayer player, int level, ClashRarity rarity) {
		super(game, player, level, rarity);
	}

	@Override
	public void spawn(Location loc) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void despawn() {
		
	}
	
	@Override
	public void onDeath() {
		
	}

	@Override
	public void tick() {
		// Not really needed for NPC structures since NPCs handle everything
	}

}
