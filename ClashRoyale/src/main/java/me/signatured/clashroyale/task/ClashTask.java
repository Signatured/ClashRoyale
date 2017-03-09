package me.signatured.clashroyale.task;

import org.bukkit.scheduler.BukkitRunnable;

import lombok.Getter;
import me.signatured.clashroyale.ClashRoyale;

public abstract class ClashTask extends BukkitRunnable {
	
	@Getter
	private ClashRoyale plugin;
	
	public ClashTask(ClashRoyale plugin) {
		this.plugin = plugin;
	}
	
	public abstract void enable();
}
