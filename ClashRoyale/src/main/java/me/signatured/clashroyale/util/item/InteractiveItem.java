package me.signatured.clashroyale.util.item;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import lombok.Getter;

public class InteractiveItem {
	
	@Getter
	private static List<InteractiveItem> items = new ArrayList<>();
	
	@Getter
	private ItemStack item;
	private List<Consumer<PlayerInteractEvent>> interactHandlers = new ArrayList<>();
	
	public InteractiveItem(ItemStack item) {
		this.item = item;
		items.add(this);
	}
	
	public static InteractiveItem of(ItemStack item) {
		return new InteractiveItem(item);
	}
	
	public InteractiveItem onInteract(Consumer<PlayerInteractEvent> handler) {
		interactHandlers.add(handler);
		return this;
	}
	
	public void onInteractEvent(PlayerInteractEvent event) {
		if (!event.hasItem())
			return;
		
		if (isItem(event.getItem())) {
			event.setCancelled(true);
			event.getPlayer().updateInventory();
			interactHandlers.forEach(ih -> ih.accept(event));
		}
	}
	
	public boolean isItem(ItemStack item) {
		return this.item.equals(item);
	}
}
