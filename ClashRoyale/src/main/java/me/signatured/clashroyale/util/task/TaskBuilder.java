package me.signatured.clashroyale.util.task;

import java.util.concurrent.TimeUnit;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scheduler.BukkitTask;

import lombok.Builder;

@Builder
public class TaskBuilder implements Runnable {
	
	static final TimeUnit TICKS = null;
	private TaskType type;
	private Runnable runnable;
	private long delay = 0L;
	private long interval = 0L;
	private long cycles = 0L;
	private Plugin plugin;
	private BukkitTask task;
	
	public static TaskBuilder sync(Plugin plugin) {
		return TaskBuilder.builder().type(TaskType.SYNC).plugin(plugin).build();
	}
	
	public static TaskBuilder async(Plugin plugin) {
		return TaskBuilder.builder().type(TaskType.ASYNC).plugin(plugin).build();
	}
	
	/**
	 * Delays the task launch by the given number of ticks.
	 * @param delay The time to delay in ticks.
	 */
	public TaskBuilder delay(long delay) {
		this.delay = delay;
		return this;
	}
	
	/**
	 * Launches the task at the given rate, regardless of how long
	 * the task takes to complete.
	 * @param rate The delay in ticks to wait between launches.
	 */
	public TaskBuilder interval(long interval) {
		this.interval = interval;
		return this;
	}
	
	public TaskBuilder cycles(long cycles) {
		this.cycles = cycles;
		return this;
	}
	
	public BukkitTask run(Runnable runnable) {
		this.runnable = runnable;
		BukkitScheduler sch = Bukkit.getScheduler();
		
		if (interval == 0 && cycles == 0) { //Only to be ran once
			if (delay == 0) {
				if (type == TaskType.SYNC)
					return task = sch.runTask(plugin, this);
				else if (type == TaskType.ASYNC)
					return task = sch.runTaskAsynchronously(plugin, this);
			} else {
				if (type == TaskType.SYNC)
					return task = sch.runTaskLater(plugin, this, delay);
				else if (type == TaskType.ASYNC)
					return task = sch.runTaskLaterAsynchronously(plugin, this, delay);
			}
		} else {
			if (type == TaskType.SYNC)
				return task = sch.runTaskTimer(plugin, this, delay, interval);
			else if (type == TaskType.ASYNC)
				return task = sch.runTaskTimerAsynchronously(plugin, this, delay, interval);
		}
		
		//Should never happen
		return null;
	}
	
	protected int count = 0;
	@Override
	public void run() {
		runnable.run();
		
		count++;
		
		if (cycles > 0 && count >= cycles)
			task.cancel();
	}

	public enum TaskType {
		SYNC,
		ASYNC;
	}
}
