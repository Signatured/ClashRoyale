package me.signatured.clashroyale.spawnable.npc.impl.groups;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.card.annotation.GenerateCard;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.spawnable.npc.GroupNpc;
import me.signatured.clashroyale.spawnable.npc.NpcType;

@GenerateCard(key = "NPC_MINI_GOLEMS", name = "Mini Golems", real = false)
public class MiniGolems extends GroupNpc {

	public MiniGolems(ClashGame game, ClashPlayer player, int level) {
		super(game, player, NpcType.MINI_GOLEMS, level, 2);
	}

}
