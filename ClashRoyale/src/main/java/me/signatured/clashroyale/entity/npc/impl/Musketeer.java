package me.signatured.clashroyale.entity.npc.impl;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.entity.npc.ClashNpc;
import me.signatured.clashroyale.entity.npc.NpcType;
import me.signatured.clashroyale.game.ClashGame;

public class Musketeer extends ClashNpc {

	public Musketeer(ClashGame game, ClashPlayer player, int level) {
		super(game, player, NpcType.MUSKETEER, level);
		flags().setAttackFlying(true);
	}

}
