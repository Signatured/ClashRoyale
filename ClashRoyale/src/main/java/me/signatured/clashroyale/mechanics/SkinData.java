package me.signatured.clashroyale.mechanics;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;

import lombok.Getter;
import me.signatured.clashroyale.util.item.ItemBuilder;

@Getter
public class SkinData {
	
	@Getter
	private static List<SkinData> datas = new ArrayList<>();
	
	private String key;
	private String uuid;
	private String name;
	private String texture1;
	private String texture2;
	
	public SkinData(String key, String uuid, String name, String texture1, String texture2) {
		this.key = key;
		this.uuid = uuid;
		this.name = name;
		this.texture1 = texture1;
		this.texture2 = texture2;
		
		datas.add(this);
	}
	
	public static SkinData getData(String key) {
		return datas.stream().filter(d -> d.getKey().equalsIgnoreCase(key)).findAny().orElse(null);
	}
	
	public ItemStack getSkull() {
		System.out.println(key);
		ItemStack skull = ItemBuilder.of(Material.SKULL_ITEM).data(3).build();
		SkullMeta meta = (SkullMeta) skull.getItemMeta();
		
		GameProfile profile = new GameProfile(UUID.fromString(uuid), name);
		profile.getProperties().put("textures", new Property("textures", texture1, texture2));
		
		Field profileField = null;
        try {
            profileField = meta.getClass().getDeclaredField("profile");
            profileField.setAccessible(true);
            profileField.set(meta, profile);
        } catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException e1) {
            e1.printStackTrace();
        }
        
        skull.setItemMeta(meta);
        return skull;
	}
}
