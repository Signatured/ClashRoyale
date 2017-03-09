package me.signatured.clashroyale.entity.npc.impl;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.entity.npc.ClashNpc;
import me.signatured.clashroyale.entity.npc.NpcType;
import me.signatured.clashroyale.game.ClashGame;

public class BabyDragon extends ClashNpc {

	public BabyDragon(ClashGame game, ClashPlayer owner, int level) {
		super(game, owner, NpcType.BABY_DRAGON, level);
		flags().setFlying(true);
		flags().setAttackFlying(true);
	}

}
