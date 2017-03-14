package me.signatured.clashroyale.util.item;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import lombok.Getter;

public class InteractiveItemListener implements Listener {
	
	@Getter
	private static List<InteractiveItem> items = new ArrayList<>();
	
	public void register(InteractiveItem item) {
		items.add(item);
	}
	
	@EventHandler
	public void onInteract(PlayerInteractEvent event) {
		items.forEach(i -> i.onInteractEvent(event));
	}
}
