package me.signatured.clashroyale.spawnable.structure;

import java.util.concurrent.TimeUnit;

import org.bukkit.Location;

import lombok.Getter;
import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.ClashRoyale;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.spawnable.ClashRarity;
import me.signatured.clashroyale.spawnable.npc.NpcType;
import me.signatured.clashroyale.task.ClashTask;

@Getter
public abstract class SpawnStructure extends ClashStructure {

	private NpcType npcType;
	private Location spawnLoc;
	private int spawnAmount;
	private int spawnSpeed;
	private long lastSpawnTime;
	
	private SpawnTask spawnTask;
	
	public SpawnStructure(ClashGame game, ClashPlayer player, int level, ClashRarity rarity, int lifeTime, NpcType npcType,
			int spawnAmount, int spawnSpeed) {
		super(game, player, level, rarity, lifeTime);
		this.npcType = npcType;
		this.spawnAmount = spawnAmount;
		this.spawnSpeed = spawnSpeed;
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
	
	private boolean canSpawn() {
		return TimeUnit.SECONDS.toMillis(spawnSpeed) + lastSpawnTime < System.currentTimeMillis();
	}
	
	public class SpawnTask extends ClashTask {
		
		private long startTime;
		private long lifeTime;
		
		public SpawnTask(SpawnStructure structure) {
			super(ClashRoyale.getInstance());
			startTime = System.currentTimeMillis();
			lifeTime = TimeUnit.SECONDS.toMillis(getLifeTime());
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
