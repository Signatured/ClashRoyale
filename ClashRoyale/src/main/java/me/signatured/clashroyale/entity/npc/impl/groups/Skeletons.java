package me.signatured.clashroyale.entity.npc.impl.groups;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.entity.npc.GroupNpc;
import me.signatured.clashroyale.entity.npc.NpcType;
import me.signatured.clashroyale.game.ClashGame;

public class Skeletons extends GroupNpc {

	public Skeletons(ClashGame game, ClashPlayer player, int level) {
		super(game, player, NpcType.SKELETONS, level, 3);
	}

}
