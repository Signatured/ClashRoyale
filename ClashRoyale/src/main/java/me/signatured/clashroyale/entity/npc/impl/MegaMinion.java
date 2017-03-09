package me.signatured.clashroyale.entity.npc.impl;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.entity.npc.ClashNpc;
import me.signatured.clashroyale.entity.npc.NpcType;
import me.signatured.clashroyale.game.ClashGame;

public class MegaMinion extends ClashNpc {

	public MegaMinion(ClashGame game, ClashPlayer player, int level) {
		super(game, player, NpcType.MEGA_MINION, level);
		flags().setFlying(true);
		flags().setAttackFlying(true);
	}

}
