package me.signatured.clashroyale.spawnable.npc;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.util.ClashUtil;

public abstract class SkinnedNpc extends ClashNpc {

	public SkinnedNpc(ClashGame game, ClashPlayer player, int level) {
		super(game, player, level);
	}
	
	@Override
	public void spawn(Location loc) {
		super.spawn(loc);
		
		SkinData data = SkinData.getData(getKey());
		ClashUtil.applySkin(getNpc(), data);
	}
	
	@Override
	public EntityType getEntityType() {
		return EntityType.PLAYER;
	}
	
}
