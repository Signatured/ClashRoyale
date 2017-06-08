package me.signatured.clashroyale.spawnable.npc.impl.groups;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.arena.ArenaType;
import me.signatured.clashroyale.card.annotation.GenerateCard;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.spawnable.ClashRarity;
import me.signatured.clashroyale.spawnable.npc.GroupNpc;

@GenerateCard(key = "GROUP_ARCHERS", name = "Archers", rarity = ClashRarity.COMMON, arena = ArenaType.ARENA_1, cost = 3, defaultCard = true)
public class Archers extends GroupNpc {
	
	public Archers(ClashGame game, ClashPlayer player, Integer level) {
		super(game, player, level, 2);
	}

	@Override
	public String getNpcKey() {
		return "NPC_ARCHER";
	}
}
