package me.signatured.clashroyale.spawnable.spell;

import lombok.Getter;
import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.game.ClashGame;

@Getter
public abstract class AOESpell extends ClashSpell {
	
	private int radius;

	public AOESpell(ClashGame game, ClashPlayer player, int level, int radius) {
		super(game, player, level);
		this.radius = radius;
	}

}
