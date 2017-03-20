package me.signatured.clashroyale.spawnable.npc.impl.groups;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.card.annotation.GenerateCard;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.game.arena.ClashArena;
import me.signatured.clashroyale.spawnable.ClashRarity;
import me.signatured.clashroyale.spawnable.npc.GroupNpc;

@GenerateCard(key = "GROUP_SPEAR_GOBLINS", name = "Spear Goblins", rarity = ClashRarity.COMMON, arena = ClashArena.ARENA_1, cost = 2)
public class SpearGoblins extends GroupNpc  {

	public SpearGoblins(ClashGame game, ClashPlayer player, int level) {
		super(game, player,  level, 3);
	}

	@Override
	public String getNpcKey() {
		return "NPC_SPEAR_GOBLIN";
	}

}
