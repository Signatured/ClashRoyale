package me.signatured.clashroyale.spawnable.npc.impl.groups;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.card.annotation.GenerateCard;
import me.signatured.clashroyale.game.ClashArena;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.spawnable.ClashRarity;
import me.signatured.clashroyale.spawnable.npc.GroupNpc;

@GenerateCard(key = "GROUP_SKELETONS", name = "Skeletons", rarity = ClashRarity.COMMON, arena = ClashArena.ARENA_2, cost = 1)
public class Skeletons extends GroupNpc {

	public Skeletons(ClashGame game, ClashPlayer player, int level) {
		super(game, player, level, 3);
	}

	@Override
	public String getNpcKey() {
		return "NPC_SKELETON";
	}

}
