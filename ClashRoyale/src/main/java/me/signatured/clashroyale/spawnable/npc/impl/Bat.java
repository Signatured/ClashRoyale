package me.signatured.clashroyale.spawnable.npc.impl;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.card.annotation.GenerateCard;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.spawnable.npc.ClashNpc;
import me.signatured.clashroyale.spawnable.npc.NpcType;

@GenerateCard(key = "NPC_BAT", name = "Bat", real = false)
public class Bat extends ClashNpc {

	public Bat(ClashGame game, ClashPlayer player, int level) {
		super(game, player, NpcType.BAT, level);
		flags().setFlying(true);
		flags().setAttackFlying(true);
	}

}
