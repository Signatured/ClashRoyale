package me.signatured.clashroyale.arena;

import org.bukkit.World;
import org.bukkit.WorldCreator;

import com.boydti.fawe.bukkit.wrapper.AsyncWorld;
import com.boydti.fawe.util.TaskManager;

import lombok.Getter;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.util.ClashUtil;
import me.signatured.clashroyale.util.task.Sync;

@Getter
public class Arena {
	
	private static int id = 0;
	
	private ClashGame game;
	private ArenaType type;
	private World world;
	private boolean loaded = false;
	
	public Arena(ClashGame game, ArenaWorld arenaWorld) {
		this.game = game;
		this.type = arenaWorld.getType();
		
		loadWorld(arenaWorld);
	}
	
	private void loadWorld(ArenaWorld arenaWorld) {
		TaskManager.IMP.async(new Runnable() {
			@Override
			public void run() {
				int arenaId = id++;
				
				ClashUtil.copyWorld(arenaWorld.getWorld().getName(), "ARENA_" + arenaId, "uid.dat", "session.dat");
				AsyncWorld arenaWorld = AsyncWorld.create(new WorldCreator("ARENA_" + arenaId));
				arenaWorld.commit();
				
				world = arenaWorld.getBukkitWorld();
				finish();
			}
		});
	}
	
	//TODO: TP players to arena, start short countdown
	private void finish() {
		Sync.get().run(() -> {
			loaded = true;
		});
	}
}
