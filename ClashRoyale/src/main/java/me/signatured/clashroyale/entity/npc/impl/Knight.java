package me.signatured.clashroyale.entity.npc.impl;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.entity.npc.ClashNpc;
import me.signatured.clashroyale.entity.npc.NpcType;
import me.signatured.clashroyale.game.ClashGame;

public class Knight extends ClashNpc {

	public Knight(ClashGame game, ClashPlayer player, int level) {
		super(game, player, NpcType.KNIGHT, level);
	}

}
