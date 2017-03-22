package me.signatured.clashroyale.spawnable.npc.impl.groups;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.arena.ArenaType;
import me.signatured.clashroyale.card.annotation.GenerateCard;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.spawnable.ClashRarity;
import me.signatured.clashroyale.spawnable.npc.GroupNpc;

@GenerateCard(key = "GROUP_BARBARIANS", name = "Barbarians", rarity = ClashRarity.COMMON, arena = ArenaType.ARENA_3, cost = 5)
public class Barbarians extends GroupNpc {

	public Barbarians(ClashGame game, ClashPlayer player, int level) {
		super(game, player, level, 4);
	}

	@Override
	public String getNpcKey() {
		return "NPC_BARBARIAN";
	}

}
