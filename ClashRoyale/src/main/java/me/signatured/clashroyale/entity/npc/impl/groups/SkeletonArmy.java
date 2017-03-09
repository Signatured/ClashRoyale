package me.signatured.clashroyale.entity.npc.impl.groups;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.entity.npc.GroupNpc;
import me.signatured.clashroyale.entity.npc.NpcType;
import me.signatured.clashroyale.game.ClashGame;

public class SkeletonArmy extends GroupNpc {

	public SkeletonArmy(ClashGame game, ClashPlayer player, int level) {
		super(game, player, NpcType.SKELETON_ARMY, level, 16);
	}

}
