package me.signatured.clashroyale.spawnable.structure;

import java.util.concurrent.TimeUnit;

import org.bukkit.Location;

import lombok.Getter;
import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.ClashRoyale;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.spawnable.ClashRarity;
import me.signatured.clashroyale.spawnable.types.ISpawnStructure;
import me.signatured.clashroyale.task.ClashTask;

@Getter
public abstract class SpawnStructure extends ClashStructure implements ISpawnStructure {

	private Location spawnLoc;
	private long lastSpawnTime;
	
	private SpawnTask spawnTask;
	
	public SpawnStructure(ClashGame game, ClashPlayer player, int level, ClashRarity rarity) {
		super(game, player, level, rarity);
	}

	@Override
	public void spawn(Location loc) {
		
	}
	
	@Override
	public void despawn() {
		spawnTask.cancel();
	}
	
	@Override
	public void onDeath() {
		
	}

	@Override
	public void tick() {
		if (!canSpawn())
			return;
		
		
	}
	
	@Override
	public double getRange() {
		return -1;
	}
	
	private boolean canSpawn() {
		return TimeUnit.SECONDS.toMillis((long) getSpawnSpeed()) + lastSpawnTime < System.currentTimeMillis();
	}
	
	public class SpawnTask extends ClashTask {
		
		private long startTime;
		private long lifeTime;
		
		public SpawnTask(SpawnStructure structure) {
			super(ClashRoyale.getInstance());
			startTime = System.currentTimeMillis();
			lifeTime = TimeUnit.SECONDS.toMillis(getLifetime());
		}

		@Override
		public void run() {
			if (System.currentTimeMillis() - startTime > lifeTime) {
				despawn();
				return;
			}
			
			tick();
		}

		@Override
		public void enable() {
			this.runTaskTimer(getPlugin(), 0, 1);
		}

	}

}
