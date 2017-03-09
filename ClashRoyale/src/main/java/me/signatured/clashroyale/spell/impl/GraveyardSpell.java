package me.signatured.clashroyale.spell.impl;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.spell.AOESpell;
import me.signatured.clashroyale.spell.SpellType;

public class GraveyardSpell extends AOESpell {

	public GraveyardSpell(ClashGame game, ClashPlayer player, int level) {
		super(game, player, SpellType.GRAVEYARD, level, 5);
	}

	@Override
	public void spawn() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void despawn() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

}
