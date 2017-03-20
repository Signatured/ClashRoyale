package me.signatured.clashroyale.spawnable.spell.impl;

import org.bukkit.Location;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.card.annotation.GenerateCard;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.game.arena.ClashArena;
import me.signatured.clashroyale.spawnable.ClashRarity;
import me.signatured.clashroyale.spawnable.spell.ClashSpell;
import me.signatured.clashroyale.spawnable.types.IAOESpell;

@GenerateCard(key = "SPELL_GRAVEYARD", name = "Graveyard", rarity = ClashRarity.LEGENDARY, arena = ClashArena.ARENA_5, cost = 5)
public class GraveyardSpell extends ClashSpell implements IAOESpell {

	public GraveyardSpell(ClashGame game, ClashPlayer player, int level) {
		super(game, player, level);
	}

	@Override
	public void spawn(Location loc) {
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

	@Override
	public MovementType getTargetType() {
		return null;
	}

	@Override
	public double getRadius() {
		return 5;
	}

	@Override
	public double getDuration() {
		return 10;
	}

}
