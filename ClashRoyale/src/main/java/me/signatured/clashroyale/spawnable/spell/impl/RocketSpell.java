package me.signatured.clashroyale.spawnable.spell.impl;

import org.bukkit.Location;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.card.annotation.GenerateCard;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.game.arena.ClashArena;
import me.signatured.clashroyale.spawnable.ClashRarity;
import me.signatured.clashroyale.spawnable.spell.ClashSpell;
import me.signatured.clashroyale.spawnable.types.IClashSpell;

@GenerateCard(key = "SPELL_ROCKET", name = "Arrows", rarity = ClashRarity.RARE, arena = ClashArena.ARENA_3, cost = 6)
public class RocketSpell extends ClashSpell implements IClashSpell {

	public RocketSpell(ClashGame game, ClashPlayer player, int level) {
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

}
