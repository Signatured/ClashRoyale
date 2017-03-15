package me.signatured.clashroyale.spawnable.npc.impl.groups;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.card.annotation.GenerateCard;
import me.signatured.clashroyale.game.ClashArena;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.spawnable.ClashRarity;
import me.signatured.clashroyale.spawnable.npc.GroupNpc;
import me.signatured.clashroyale.spawnable.npc.NpcType;

@GenerateCard(key = "GROUP_FIRE_SPIRITS", name = "Fire Sprirts", rarity = ClashRarity.COMMON, arena = ClashArena.ARENA_5, cost = 2)
public class FireSpirits extends GroupNpc {

	public FireSpirits(ClashGame game, ClashPlayer player, int level) {
		super(game, player, NpcType.FIRE_SPIRITS, level, 2);
	}

}
