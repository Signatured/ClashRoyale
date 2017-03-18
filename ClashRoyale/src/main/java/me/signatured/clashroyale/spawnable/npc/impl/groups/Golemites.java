package me.signatured.clashroyale.spawnable.npc.impl.groups;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.card.annotation.GenerateCard;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.spawnable.npc.GroupNpc;

@GenerateCard(key = "NPC_GOLEMITES", name = "Golemites", real = false)
public class Golemites extends GroupNpc {

	public Golemites(ClashGame game, ClashPlayer player, int level) {
		super(game, player, level, 2);
	}

	@Override
	public String getNpcKey() {
		return "NPC_GOLEMITE";
	}

}
