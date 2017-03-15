package me.signatured.clashroyale.spawnable.npc.impl;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.card.annotation.GenerateCard;
import me.signatured.clashroyale.game.ClashArena;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.spawnable.ClashRarity;
import me.signatured.clashroyale.spawnable.npc.ClashNpc;
import me.signatured.clashroyale.spawnable.npc.NpcType;

@GenerateCard(key = "NPC_MUSKETEER", name = "Musketeer", rarity = ClashRarity.RARE, arena = ClashArena.ARENA_1, cost = 4)
public class Musketeer extends ClashNpc {

	public Musketeer(ClashGame game, ClashPlayer player, int level) {
		super(game, player, NpcType.MUSKETEER, level);
		flags().setAttackFlying(true);
	}

}
