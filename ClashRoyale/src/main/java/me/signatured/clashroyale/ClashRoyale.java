package me.signatured.clashroyale;

import java.lang.reflect.Field;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.world.WorldInitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.java.JavaPlugin;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;

import lombok.Getter;
import me.signatured.clashroyale.card.CardList;
import me.signatured.clashroyale.util.item.InteractiveItemListener;
import me.signatured.clashroyale.util.item.ItemBuilder;

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
		Bukkit.getPluginManager().registerEvents(this, this);
	}
	
	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		GameProfile profile = new GameProfile(UUID.fromString("ae9344ec-cf2d-34f9-807c-262e3efda8da"), "skin9692");
		profile.getProperties().put("textures", new Property("textures",
				"eyJ0aW1lc3RhbXAiOjE0OTEwNzc5NDQ4OTcsInByb2ZpbGVJZCI6ImIwZDRiMjhiYzFkNzQ4ODlhZjBlODY2MWNlZTk2YWFiIiwicHJvZmlsZU5hbWUiOiJZZWxlaGEiLCJzaWduYXR1cmVSZXF1aXJlZCI6dHJ1ZSwidGV4dHVyZXMiOnsiU0tJTiI6eyJ1cmwiOiJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlL2I4NDQ3MGY4MjAxZjdjNTM4ODc1ZjU4YTVjNjE1NGMxNTBiYzRkMmJmOWM5YmFiZmI0ZTU4MTA5NmZjZDZkMCJ9fX0=",
				"RKNS21mpPxGvU4E6cxt/AxqJhTMDOTwBwmNUn2gu4xTWrLMz/aBlGGiNiVmIl+KNJd9odKpnWR+6TpP95ABQrT+WGCWOJwqQmdDz8Dn6UART4KktfMkbDUCDXDBzcxSGrPD61wRgGjhHFbz+pPj76MiYhC2bWOF85FMeAHviui+k/QBdGdfXdv1js1yr3aikXQKeozyJ+fWCrSaA6qov6CYy7u6gTTQDoaM4J00if99qq2V9xkCl+giEDgV/18mbVWufJ/Y+iN0a3B5nPq0EjNsX2/ABG+Svud0Mcjxs/cvL8FngPpks2tgiNTHNAdc03oS4G8ZbqDXH7CSZedwH5OI6WPk0jKBw0yJfUM7J6D87Cs5ZhUVtAHaabR2KIjulbQit3ByWQyGQMd7cYEfGbGd4hSENn2ZADq9EVaNRWXWPFYlsAX/x7eafbBwlEvmVUKGYyTyv5sbfZevuuX/TPSKtDkyR+LCXs8Hk3LJ3OZnLVhKIEVm3GWJE5mxE83WcVCRqBFxDENqaNq+qorH2CxGl4o52rFhI0GwvcmRbZ0wvWBRh9DzLyQyCDJtNPP2JkcX5MRchMHtH+ynetjVajk1wRXqjEcIX7R8kS0ZRySxZT5f3+Txw0mK926uE9/IwWRrO+icwKYOxKn90XfmFPQpnBxDq9mbk+/Q6PF1LuLc="));
		
		ItemStack skull = ItemBuilder.of(Material.SKULL_ITEM).data(3).build();
		SkullMeta meta = (SkullMeta) skull.getItemMeta();
		
		Field profileField = null;
        try {
            profileField = meta.getClass().getDeclaredField("profile");
            profileField.setAccessible(true);
            profileField.set(meta, profile);
        } catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException e1) {
            e1.printStackTrace();
        }
        
        skull.setItemMeta(meta);
        e.getPlayer().getInventory().addItem(skull);
	}
}
