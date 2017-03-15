package me.signatured.clashroyale.spawnable.npc.impl.groups;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.card.annotation.GenerateCard;
import me.signatured.clashroyale.game.ClashArena;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.spawnable.ClashRarity;
import me.signatured.clashroyale.spawnable.npc.GroupNpc;
import me.signatured.clashroyale.spawnable.npc.NpcType;

@GenerateCard(key = "GROUP_MINIONS", name = "Minions", rarity = ClashRarity.COMMON, arena = ClashArena.ARENA_2, cost = 3)
public class Minions extends GroupNpc {

	public Minions(ClashGame game, ClashPlayer player, int level) {
		super(game, player, NpcType.MINIONS, level, 3);
	}

}
