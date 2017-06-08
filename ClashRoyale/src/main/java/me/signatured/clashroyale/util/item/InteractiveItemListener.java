package me.signatured.clashroyale.util.item;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class InteractiveItemListener implements Listener {
	
	@EventHandler
	public void onInteract(PlayerInteractEvent event) {
		InteractiveItem.getItems().forEach(i -> i.onInteractEvent(event));
	}
}
