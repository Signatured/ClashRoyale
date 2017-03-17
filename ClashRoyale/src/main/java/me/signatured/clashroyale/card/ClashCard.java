package me.signatured.clashroyale.card;

import lombok.AllArgsConstructor;
import lombok.Data;
import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.game.ClashArena;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.spawnable.ClashRarity;
import me.signatured.clashroyale.spawnable.ClashSpawnable;

@Data
@AllArgsConstructor
public class ClashCard {
	
	private String key;
	private String name;
	private Class<? extends ClashSpawnable> spawnClass;
	private ClashRarity rarity;
	private ClashArena arena;
	private int cost;
	private boolean real;

	public ClashSpawnable create(ClashPlayer player, ClashGame game, int level) {
		try {
			ClashSpawnable instance = (ClashSpawnable) spawnClass
					.getConstructor(ClashPlayer.class, ClashGame.class, Integer.class).newInstance(player, game, level);
			return instance;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}
