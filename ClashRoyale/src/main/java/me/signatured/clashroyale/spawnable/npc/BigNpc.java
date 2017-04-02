package me.signatured.clashroyale.spawnable.npc;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Skeleton.SkeletonType;

import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.game.ClashGame;

public abstract class BigNpc extends ClashNpc {

	public BigNpc(ClashGame game, ClashPlayer player, int level) {
		super(game, player, level);
	}
	
	@Override
	public void spawn(Location loc) {
		super.spawn(loc);
		
		Skeleton skeleton = (Skeleton) getNpc().getEntity();
		skeleton.setSkeletonType(SkeletonType.WITHER);
	}
	
	@Override
	public EntityType getEntityType() {
		return EntityType.SKELETON;
	}
}
