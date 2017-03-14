package me.signatured.clashroyale.util.task;

import lombok.Getter;
import me.signatured.clashroyale.ClashRoyale;

public class Async {
	
	@Getter
	private TaskBuilder builder;
	
	public Async() {
		builder = TaskBuilder.async(ClashRoyale.getInstance());
	}
	
	public static TaskBuilder get() {
		return new Async().getBuilder();
	}
}
