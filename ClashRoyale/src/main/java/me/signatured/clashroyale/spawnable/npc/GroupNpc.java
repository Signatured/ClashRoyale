package me.signatured.clashroyale.spawnable.npc;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;

import lombok.Data;
import lombok.EqualsAndHashCode;
import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.card.CardList;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.spawnable.ClashSpawnable;

@Data
@EqualsAndHashCode(callSuper=false)
public abstract class GroupNpc extends ClashSpawnable {
		
	private List<ClashNpc> npcs = new ArrayList<>();
	private int amount;

	public GroupNpc(ClashGame game, ClashPlayer player, int level, int amount) {
		super(game, player, level);
		this.amount = amount;
	}

	@Override
	public void spawn(Location loc) {
		for (int i = 0; i < amount; i++) {
			ClashSpawnable spawnable = CardList.getInstance().find(getNpcKey()).create(getPlayer(), getGame(), getLevel());
			spawnable.spawn(loc);
		}
	}

	@Override
	public void despawn() {
		
	}

	@Override
	public void tick() {
		
	}
	
	public abstract String getNpcKey();

}
