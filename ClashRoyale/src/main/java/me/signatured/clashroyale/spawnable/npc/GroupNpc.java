package me.signatured.clashroyale.spawnable.npc;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;

import lombok.Data;
import lombok.EqualsAndHashCode;
import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.spawnable.ClashSpawnable;

@Data
@EqualsAndHashCode(callSuper=false)
public abstract class GroupNpc extends ClashSpawnable {
		
	private List<ClashNpc> npcs = new ArrayList<>();
	private int level;
	private int amount;

	public GroupNpc(ClashGame game, ClashPlayer player, int level, int amount) {
		super(game, player, level);
		this.level = level;
		this.amount = amount;
	}

	@Override
	public void spawn(Location loc) {
		
	}

	@Override
	public void despawn() {
		
	}
	
	@Override
	public void onDeath() {
		
	}

	@Override
	public void tick() {
		
	}
	
	public abstract String getNpcKey();

}
