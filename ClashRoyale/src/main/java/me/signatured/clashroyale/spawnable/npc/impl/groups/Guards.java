package me.signatured.clashroyale.spawnable.npc.impl.groups;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.card.annotation.GenerateCard;
import me.signatured.clashroyale.game.ClashArena;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.spawnable.ClashRarity;
import me.signatured.clashroyale.spawnable.npc.GroupNpc;
import me.signatured.clashroyale.spawnable.npc.NpcType;

@GenerateCard(key = "GROUP_GUARDS", name = "Guards", rarity = ClashRarity.EPIC, arena = ClashArena.ARENA_7, cost = 3)
public class Guards extends GroupNpc {

	public Guards(ClashGame game, ClashPlayer player, int level) {
		super(game, player, NpcType.GUARDS, level, 3);
	}

}
