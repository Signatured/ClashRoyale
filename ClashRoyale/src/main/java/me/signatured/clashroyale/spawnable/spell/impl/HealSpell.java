package me.signatured.clashroyale.spawnable.spell.impl;

import org.bukkit.Location;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.arena.ArenaType;
import me.signatured.clashroyale.card.annotation.GenerateCard;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.spawnable.ClashRarity;
import me.signatured.clashroyale.spawnable.spell.ClashSpell;
import me.signatured.clashroyale.spawnable.types.IAOESpell;

@GenerateCard(key = "SPELL_HEAL", name = "Heal", rarity = ClashRarity.RARE, arena = ArenaType.ARENA_10, cost = 3)
public class HealSpell extends ClashSpell implements IAOESpell {

	public HealSpell(ClashGame game, ClashPlayer player, int level) {
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
		return MovementType.AIR_AND_GROUND;
	}

	@Override
	public double getRadius() {
		return 3;
	}

	@Override
	public double getDuration() {
		return 3;
	}

}
