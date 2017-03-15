package me.signatured.clashroyale.spawnable.npc.impl;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.card.annotation.GenerateCard;
import me.signatured.clashroyale.game.ClashArena;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.spawnable.ClashRarity;
import me.signatured.clashroyale.spawnable.npc.ClashNpc;
import me.signatured.clashroyale.spawnable.npc.NpcType;

@GenerateCard(key = "NPC_DART_GOBLIN", name = "Dart Goblin", rarity = ClashRarity.RARE, arena = ClashArena.ARENA_9, cost = 3)
public class DartGoblin extends ClashNpc {

	public DartGoblin(ClashGame game, ClashPlayer player, int level) {
		super(game, player, NpcType.DART_GOBLIN, level);
		flags().setAttackFlying(true);
	}

}
