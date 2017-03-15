package me.signatured.clashroyale.spawnable.npc.impl;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.card.annotation.GenerateCard;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.spawnable.npc.ClashNpc;
import me.signatured.clashroyale.spawnable.npc.NpcType;

@GenerateCard(key = "NPC_TOWER_ARCHER", name = "Tower Archer", real = false)
public class TowerArcher extends ClashNpc {

	public TowerArcher(ClashGame game, ClashPlayer owner, int level) {
		super(game, owner, NpcType.ARENA_TOWER_NPC, level);
	}

}
