package me.signatured.clashroyale.entity.npc.impl;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.entity.npc.ClashNpc;
import me.signatured.clashroyale.entity.npc.NpcType;
import me.signatured.clashroyale.game.ClashGame;

public class RoyaleGiant extends ClashNpc {

	public RoyaleGiant(ClashGame game, ClashPlayer player, int level) {
		super(game, player, NpcType.ROYALE_GIANT, level);
		flags().setStructuresOnly(true);
	}

}
