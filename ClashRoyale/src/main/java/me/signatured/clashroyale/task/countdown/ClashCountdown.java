package me.signatured.clashroyale.task.countdown;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;

import org.bukkit.Sound;

import me.signatured.clashroyale.ClashRoyale;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.task.ClashTask;
import me.signatured.clashroyale.util.ClashUtil;
import me.signatured.clashroyale.util.Duration;
import me.signatured.clashroyale.util.Title;

public class ClashCountdown extends ClashTask {
	
	private ClashGame game;
	private int time;
	private HashMap<Integer, List<Runnable>> runnables = new HashMap<>();
	private List<Consumer<Integer>> consumers = new ArrayList<>();
	private Runnable onEnd;
	private Runnable onCancel;

	public ClashCountdown(ClashGame game, int time) {
		super(ClashRoyale.getInstance());
		
		this.game = game;
		this.time = time;
	}
	
	public ClashCountdown(ClashGame game, Duration dur) {
		this(game, dur.secs());
	}

	@Override
	public void run() {
		if (runnables.get(time) != null)
			runnables.get(time).forEach(r -> r.run());
		
		consumers.forEach(c -> c.accept(time));
		
		if (time <= 0) {
			if (onEnd != null)
				onEnd.run();
			
			cancel();
			return;
		}
		
		time--;
	}
	
	public void cancel() {
		if (onCancel != null)
			onCancel.run();
		
		super.cancel();
	}

	public ClashCountdown title(Title title, int... at) {
		for (int time : at)
			at(time, () -> game.title(title));
		return this;
	}
	
	public ClashCountdown sound(Sound sound, int... at) {
		for (int time : at)
			at(time, () -> game.sound(sound));
		return this;
	}
	
	public ClashCountdown actionbar(String message, int... at) {
		for (int time : at)
			at(time, () -> game.actionbar(message));
		return this;
	}
	
	public ClashCountdown onEnd(Runnable runnable) {
		onEnd = runnable;
		return this;
	}
	
	public ClashCountdown onCancel(Runnable runnable) {
		onCancel = runnable;
		return this;
	}
	
	public ClashCountdown at(int time, Runnable runnable) {
		if (runnables.get(time) == null)
			runnables.put(time, new ArrayList<>());
		runnables.get(time).add(runnable);
		return this;
	}
	
	public ClashCountdown every(Consumer<Integer> consumer) {
		consumers.add(consumer);
		return this;
	}
	
	public int getTime() {
		return time;
	}
	
	public String getFormattedTime() {
		return ClashUtil.getTime(Duration.secs(time).ms());
	}
	
	@Override
	public void enable() {
		this.runTaskTimer(getPlugin(), 0, 20);
	}
	
}
