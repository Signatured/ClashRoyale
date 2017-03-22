package me.signatured.clashroyale.spawnable.spell.impl;

import org.bukkit.Location;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.arena.ArenaType;
import me.signatured.clashroyale.card.annotation.GenerateCard;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.spawnable.ClashRarity;
import me.signatured.clashroyale.spawnable.spell.ClashSpell;
import me.signatured.clashroyale.spawnable.types.IClashSpell;

@GenerateCard(key = "SPELL_FIREBALL", name = "Fireball", rarity = ClashRarity.RARE, arena = ArenaType.ARENA_1, cost = 4)
public class FireballSpell extends ClashSpell implements IClashSpell {

	public FireballSpell(ClashGame game, ClashPlayer player, int level) {
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
