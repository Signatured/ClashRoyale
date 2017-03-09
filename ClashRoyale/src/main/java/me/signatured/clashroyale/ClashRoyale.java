package me.signatured.clashroyale;

import org.bukkit.plugin.java.JavaPlugin;

import lombok.Getter;

public class ClashRoyale extends JavaPlugin {
	
	@Getter
	private static ClashRoyale instance;
	
	@Override
	public void onLoad() {
		instance = this;
	}
}
