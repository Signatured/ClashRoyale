package me.signatured.clashroyale.spawnable.structure.impl;

import org.bukkit.Location;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.arena.ArenaType;
import me.signatured.clashroyale.card.annotation.GenerateCard;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.spawnable.ClashRarity;
import me.signatured.clashroyale.spawnable.structure.ClashStructure;
import me.signatured.clashroyale.spawnable.types.IProduceStructure;

@GenerateCard(key = "STRUCTURE_ELIXIR_COLLECTOR", name = "Elixir Collector", rarity = ClashRarity.RARE, arena = ArenaType.ARENA_6, cost = 5)
public class ElixirCollector extends ClashStructure implements IProduceStructure {

	public ElixirCollector(ClashGame game, ClashPlayer player, int level) {
		super(game, player, level, ClashRarity.RARE);
	}

	@Override
	public void spawn(Location loc) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void despawn() {
		
	}
	
	@Override
	public void onDeath() {
		
	}

	@Override
	public void tick() {
		//TODO: Give elixer when time
	}

	@Override
	public int getLifetime() {
		return 70;
	}

	@Override
	public double getProduceSpeed() {
		return 8.5;
	}

	@Override
	public int getBaseHealth() {
		return 580;
	}

}
