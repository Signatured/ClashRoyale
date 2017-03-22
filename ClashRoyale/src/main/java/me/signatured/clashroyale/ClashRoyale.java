package me.signatured.clashroyale;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.world.WorldInitEvent;
import org.bukkit.plugin.java.JavaPlugin;

import lombok.Getter;
import me.signatured.clashroyale.card.CardList;
import me.signatured.clashroyale.util.item.InteractiveItemListener;

public class ClashRoyale extends JavaPlugin implements Listener {
	
	@Getter
	private static ClashRoyale instance;
	
	@Override
	public void onLoad() {
		instance = this;
		new CardList();
	}
	
	@EventHandler(priority=EventPriority.HIGHEST)
	public void worldLoad(WorldInitEvent e) {
		e.getWorld().setKeepSpawnInMemory(false);
	}
	
	@Override
	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(new InteractiveItemListener(), this);
	}
}
