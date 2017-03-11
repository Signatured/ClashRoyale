package me.signatured.clashroyale.spell;

import lombok.Data;
import lombok.EqualsAndHashCode;
import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.entity.ClashSpawnable;
import me.signatured.clashroyale.game.ClashGame;

@Data
@EqualsAndHashCode(callSuper=false)
public abstract class ClashSpell extends ClashSpawnable {
	
	private SpellType spellType;
	private int level;
	
	public ClashSpell(ClashGame game, ClashPlayer player, SpellType spellType, int level) {
		super(game, player);
		this.spellType = spellType;
		this.level = level;
	}
	
	@Override
	public void onDeath() {
		//Not needed for spells
	}

}
