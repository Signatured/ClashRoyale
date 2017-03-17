package me.signatured.clashroyale.util.item;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemBuilder {
	
	private ItemStack item;
	
	public ItemBuilder(ItemStack item) {
		this.item = item;
	}
	
	public ItemBuilder(Material material) {
		item = new ItemStack(material);
	}
	
	public static ItemBuilder of(Material material) {
		return new ItemBuilder(material);
	}
	
	public static ItemBuilder of(ItemStack item) {
		return new ItemBuilder(item);
	}
	
	public ItemBuilder name(String name) {
		editMeta(m -> m.setDisplayName(name));
		return this;
	}
	
	public ItemBuilder lore(List<String> lore) {
		editMeta(m -> m.setLore(lore));
		return this;
	}
	
	public ItemBuilder lore(String... lore) {
		return lore(Arrays.asList(lore));
	}
	
	public ItemBuilder type(Material type) {
		item.setType(type);
		return this;
	}
	
	public ItemBuilder durability(Number data) {
		item.setDurability(data.shortValue());
		return this;
	}
	
	public ItemBuilder data(Number data) {
		return durability(data);
	}
	
	public ItemBuilder amount(int amount) {
		item.setAmount(amount);
		return this;
	}
	
	public ItemBuilder setSafeAmount(int amount) {
		if (amount > item.getMaxStackSize())
			return amount(item.getMaxStackSize());
		if (amount < 1)
			return amount(1);
		return amount(amount);
	}
	
	public ItemStack build() {
		return item;
	}
	
	private void editMeta(Consumer<ItemMeta> consumer) {
		ItemMeta meta = item.getItemMeta();
		consumer.accept(meta);
		item.setItemMeta(meta);
	}
}