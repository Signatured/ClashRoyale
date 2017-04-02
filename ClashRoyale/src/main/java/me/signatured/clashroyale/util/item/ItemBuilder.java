package me.signatured.clashroyale.util.item;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

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
	
	public ItemBuilder enchant(Enchantment enchant, int level) {
		item.addEnchantment(enchant, level);
		return this;
	}
	
	public ItemBuilder enchant(Enchantment enchant) {
		return enchant(enchant, 1);
	}
	
	@SuppressWarnings("deprecation")
	public ItemBuilder color(DyeColor color) {
		switch (item.getType()) {
		
		case LEATHER_HELMET:
		case LEATHER_CHESTPLATE:
		case LEATHER_LEGGINGS:
		case LEATHER_BOOTS:
			LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
			meta.setColor(color.getColor());
			item.setItemMeta(meta);
			break;
		
		case WOOL: 
		case CARPET:
		case STAINED_GLASS:
		case STAINED_GLASS_PANE:
			item.setDurability(color.getData());
			break;
		case INK_SACK:
		case STAINED_CLAY:
		case CLAY:
			item.setDurability(color.getDyeData());
			break;
		
		default:
			break;	
		}
		
		return this;
	}
	
	public ItemBuilder hideEnchant() {
		editMeta(m -> m.addItemFlags(ItemFlag.HIDE_ENCHANTS));
		return this;
	}
	
	public ItemBuilder hideAttributes() {
		editMeta(m -> m.addItemFlags(ItemFlag.HIDE_ATTRIBUTES));
		return this;
	}
	
	public ItemBuilder unbreakable() {
		editMeta(m -> m.addItemFlags(ItemFlag.HIDE_UNBREAKABLE));
		return this;
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
