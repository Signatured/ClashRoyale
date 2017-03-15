package me.signatured.clashroyale.spawnable.spell;

import lombok.Data;
import lombok.EqualsAndHashCode;
import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.spawnable.ClashSpawnable;

@Data
@EqualsAndHashCode(callSuper=false)
public abstract class ClashSpell extends ClashSpawnable {
		
	public ClashSpell(ClashGame game, ClashPlayer player, int level) {
		super(game, player, level);
	}
	
	@Override
	public void onDeath() {
		//Not needed for spells
	}

}
