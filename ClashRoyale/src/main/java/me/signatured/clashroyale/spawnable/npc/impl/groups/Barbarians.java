package me.signatured.clashroyale.spawnable.npc.impl.groups;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.card.annotation.GenerateCard;
import me.signatured.clashroyale.game.ClashArena;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.spawnable.ClashRarity;
import me.signatured.clashroyale.spawnable.npc.GroupNpc;
import me.signatured.clashroyale.spawnable.npc.NpcType;

@GenerateCard(key = "GROUP_BARBARIANS", name = "Barbarians", rarity = ClashRarity.COMMON, arena = ClashArena.ARENA_3, cost = 5)
public class Barbarians extends GroupNpc {

	public Barbarians(ClashGame game, ClashPlayer player, int level) {
		super(game, player, NpcType.BARBARIANS, level, 4);
	}

}
