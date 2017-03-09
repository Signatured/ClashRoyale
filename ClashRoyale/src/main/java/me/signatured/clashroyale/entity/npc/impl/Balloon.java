package me.signatured.clashroyale.entity.npc.impl;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.entity.npc.ClashNpc;
import me.signatured.clashroyale.entity.npc.NpcType;
import me.signatured.clashroyale.game.ClashGame;

public class Balloon extends ClashNpc {

	public Balloon(ClashGame game, ClashPlayer player, NpcType npcType, int level) {
		super(game, player, npcType, level);
		flags().setFlying(true);
		flags().setAttackFlying(true);
	}

}
