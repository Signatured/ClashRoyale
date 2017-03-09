package me.signatured.clashroyale.entity.npc.impl;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.entity.npc.ClashNpc;
import me.signatured.clashroyale.entity.npc.NpcType;
import me.signatured.clashroyale.game.ClashGame;

public class Archer extends ClashNpc {

	public Archer(ClashGame game, ClashPlayer owner, int level) {
		super(game, owner, NpcType.ARCHER, level);
		flags().setAttackFlying(true);
	}

}
