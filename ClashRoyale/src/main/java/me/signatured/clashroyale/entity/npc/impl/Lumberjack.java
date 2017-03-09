package me.signatured.clashroyale.entity.npc.impl;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.entity.npc.ClashNpc;
import me.signatured.clashroyale.entity.npc.NpcType;
import me.signatured.clashroyale.game.ClashGame;

public class Lumberjack extends ClashNpc {

	public Lumberjack(ClashGame game, ClashPlayer player, int level) {
		super(game, player, NpcType.LUMBERJACK, level);
	}

}
