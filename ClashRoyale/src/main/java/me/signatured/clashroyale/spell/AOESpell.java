package me.signatured.clashroyale.spell;

import lombok.Getter;
import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.game.ClashGame;

@Getter
public abstract class AOESpell extends ClashSpell {
	
	private int radius;

	public AOESpell(ClashGame game, ClashPlayer player, SpellType spellType, int level, int radius) {
		super(game, player, spellType, level);
		this.radius = radius;
	}

}
