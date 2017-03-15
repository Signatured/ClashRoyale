package me.signatured.clashroyale.spawnable.npc.impl;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.card.annotation.GenerateCard;
import me.signatured.clashroyale.game.ClashArena;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.spawnable.ClashRarity;
import me.signatured.clashroyale.spawnable.npc.ClashNpc;
import me.signatured.clashroyale.spawnable.npc.NpcType;

@GenerateCard(key = "NPC_ELECTRO_WIZARD", name = "Electro Wizard", rarity = ClashRarity.LEGENDARY, arena = ClashArena.ARENA_7, cost = 4)
public class ElectroWizard extends ClashNpc {

	public ElectroWizard(ClashGame game, ClashPlayer player, int level) {
		super(game, player, NpcType.ELECTRO_WIZARD, level);
	}

}
