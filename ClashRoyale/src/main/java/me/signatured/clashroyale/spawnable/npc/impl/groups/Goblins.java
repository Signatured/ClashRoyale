package me.signatured.clashroyale.spawnable.npc.impl.groups;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.card.annotation.GenerateCard;
import me.signatured.clashroyale.game.ClashArena;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.spawnable.ClashRarity;
import me.signatured.clashroyale.spawnable.npc.GroupNpc;
import me.signatured.clashroyale.spawnable.npc.NpcType;

@GenerateCard(key = "GROUP_GOBLINS", name = "Goblins", rarity = ClashRarity.COMMON, arena = ClashArena.ARENA_1, cost = 2)
public class Goblins extends GroupNpc {

	public Goblins(ClashGame game, ClashPlayer player, int level) {
		super(game, player, NpcType.GOBLINS, level, 3);
	}

}
