package me.signatured.clashroyale.spawnable.npc.impl.groups;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.card.annotation.GenerateCard;
import me.signatured.clashroyale.game.ClashArena;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.spawnable.ClashRarity;
import me.signatured.clashroyale.spawnable.npc.GroupNpc;

@GenerateCard(key = "GROUP_THREE_MUSKETEERS", name = "Three Musketeers", rarity = ClashRarity.RARE, arena = ClashArena.ARENA_7, cost = 9)
public class ThreeMusketeers extends GroupNpc {

	public ThreeMusketeers(ClashGame game, ClashPlayer player, int level) {
		super(game, player, level, 3);
	}

	@Override
	public String getNpcKey() {
		return "NPC_MUSKETEER";
	}

}
