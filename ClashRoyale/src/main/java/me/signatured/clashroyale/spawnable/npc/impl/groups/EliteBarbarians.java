package me.signatured.clashroyale.spawnable.npc.impl.groups;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.card.annotation.GenerateCard;
import me.signatured.clashroyale.game.ClashArena;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.spawnable.ClashRarity;
import me.signatured.clashroyale.spawnable.npc.GroupNpc;
import me.signatured.clashroyale.spawnable.npc.NpcType;

@GenerateCard(key = "GROUP_ELITE_BARBARIANS", name = "Elite Barbarians", rarity = ClashRarity.COMMON, arena = ClashArena.ARENA_7, cost = 6)
public class EliteBarbarians extends GroupNpc {

	public EliteBarbarians(ClashGame game, ClashPlayer player, int level) {
		super(game, player, NpcType.ELITE_BARBARIANS, level, 2);
	}

}
