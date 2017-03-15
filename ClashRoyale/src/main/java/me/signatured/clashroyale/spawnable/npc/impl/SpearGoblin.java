package me.signatured.clashroyale.spawnable.npc.impl;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.card.annotation.GenerateCard;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.spawnable.npc.ClashNpc;
import me.signatured.clashroyale.spawnable.npc.NpcType;

@GenerateCard(key = "NPC_SPEAR_GOBLIN", name = "Spear Goblin", real = false)
public class SpearGoblin extends ClashNpc {

	public SpearGoblin(ClashGame game, ClashPlayer player, int level) {
		super(game, player, NpcType.SPEAR_GOBLIN, level);
		flags().setAttackFlying(true);
	}

}
