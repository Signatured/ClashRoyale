package me.signatured.clashroyale.spawnable.structure.impl;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.spawnable.ClashRarity;
import me.signatured.clashroyale.spawnable.structure.NpcStructure;

public class KingTower extends NpcStructure {

	public KingTower(ClashGame game, ClashPlayer player, int level) {
		super(game, player, level, ClashRarity.COMMON);
	}

	@Override
	public String getNpcKey() {
		return "NPC_TOWER_KING";
	}

	@Override
	public int getLifetime() {
		return -1;
	}

}
