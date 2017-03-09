package me.signatured.clashroyale.entity.structure;

import java.util.concurrent.TimeUnit;

import org.bukkit.Location;

import lombok.Getter;
import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.ClashRoyale;
import me.signatured.clashroyale.entity.npc.ClashNpc;
import me.signatured.clashroyale.entity.npc.NpcType;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.task.ClashTask;

@Getter
public class SpawnStructure extends ClashStructure {

	private NpcType npcType;
	private Location spawnLoc;
	private int spawnAmount;
	private int spawnSpeed;
	private long lastSpawnTime;
	
	private SpawnTask task;
	
	public SpawnStructure(ClashGame game, ClashPlayer player, StructureType structureType, Location towerLoc,
			NpcType npcType, Location spawnLoc, int spawnAmount, int spawnSpeed) {
		super(game, player, structureType, towerLoc);
		this.npcType = npcType;
		this.spawnLoc = spawnLoc;
		this.spawnAmount = spawnAmount;
		this.spawnSpeed = spawnSpeed;
	}

	@Override
	public void spawn() {
		//TODO: Load schematic
		task = new SpawnTask(this);
	}
	
	@Override
	public void despawn() {
		task.cancel();
	}

	@Override
	public void tick() {
		if (!canSpawn())
			return;
		
		//TODO: Spawn spawnAmount amount
		int npcLevel = getStructureType().getRarity().getSpawnNpcLevel(getLevel());
		ClashNpc npc = (ClashNpc) npcType.create(getGame(), getPlayer(), npcLevel);
		npc.spawn();
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
			lifeTime = TimeUnit.SECONDS.toMillis(getStructureType().getLifeTime());
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
