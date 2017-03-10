package me.signatured.clashroyale;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;

import lombok.Getter;
import me.signatured.clashroyale.entity.structure.StructureType;

public class ClashRoyale extends JavaPlugin implements Listener {
	
	@Getter
	private static ClashRoyale instance;
	
	@Override
	public void onLoad() {
		instance = this;
	}
	
	@Override
	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(this, this);
	}
	
	@EventHandler
	public void onInteract(PlayerInteractEvent e) throws Exception {
		StructureType.ARENA_TOWER.getSchematic().place(e.getPlayer().getLocation());
	}
}
