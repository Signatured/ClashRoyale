package me.signatured.clashroyale.spawnable.npc.impl.groups;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.card.annotation.GenerateCard;
import me.signatured.clashroyale.game.ClashArena;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.spawnable.ClashRarity;
import me.signatured.clashroyale.spawnable.npc.GroupNpc;

@GenerateCard(key = "GROUP_GUARDS", name = "Guards", rarity = ClashRarity.EPIC, arena = ClashArena.ARENA_7, cost = 3)
public class Guards extends GroupNpc {

	public Guards(ClashGame game, ClashPlayer player, int level) {
		super(game, player, level, 3);
	}

	@Override
	public String getNpcKey() {
		return "NPC_GUARD";
	}

}
