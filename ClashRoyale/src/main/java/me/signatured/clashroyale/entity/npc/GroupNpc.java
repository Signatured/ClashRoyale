package me.signatured.clashroyale.entity.npc;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.entity.ClashSpawnable;
import me.signatured.clashroyale.game.ClashGame;

@Data
@EqualsAndHashCode(callSuper=false)
public class GroupNpc extends ClashSpawnable {
		
	private final double LEVEL_MULT = 0.1;
	
	private List<ClashNpc> npcs = new ArrayList<>();
	private NpcType npcType;
	private int level;
	private int amount;

	public GroupNpc(ClashGame game, ClashPlayer player, NpcType npcType, int level, int amount) {
		super(game, player);
		this.npcType = npcType;
		this.level = level;
		this.amount = amount;
	}

	@Override
	public void spawn() {
		for (int i = 0; i < amount; i++) {
			ClashNpc npc = (ClashNpc) npcType.create(getGame(), getPlayer(), level);
			npcs.add(npc);
			
			npc.spawn();
		}
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

}
