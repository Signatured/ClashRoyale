package me.signatured.clashroyale.card;

import org.bukkit.Location;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.spawnable.ClashSpawnable;

@Data
@Builder
@AllArgsConstructor
public class PlayerCard {
	
	private ClashPlayer player;
	private ClashCard card;
	private int level, amount;

	public void spawn(Location loc) {
		ClashSpawnable cs = card.create(player, player.getGame(), level);
		cs.spawn(loc);
	}
}