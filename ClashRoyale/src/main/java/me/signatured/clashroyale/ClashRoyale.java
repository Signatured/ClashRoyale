package me.signatured.clashroyale;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import lombok.Getter;
import me.signatured.clashroyale.util.item.InteractiveItemListener;

public class ClashRoyale extends JavaPlugin {
	
	@Getter
	private static ClashRoyale instance;
	
	@Override
	public void onLoad() {
		instance = this;
	}
	
	@Override
	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(new InteractiveItemListener(), this);
	}
}
