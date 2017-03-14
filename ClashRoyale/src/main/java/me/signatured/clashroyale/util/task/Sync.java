package me.signatured.clashroyale.util.task;

import lombok.Getter;
import me.signatured.clashroyale.ClashRoyale;

public class Sync {
	
	@Getter
	private TaskBuilder builder;
	
	public Sync() {
		builder = TaskBuilder.sync(ClashRoyale.getInstance());
	}
	
	public static TaskBuilder get() {
		return new Sync().getBuilder();
	}
}
