package me.signatured.clashroyale.card;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.mechanics.SkinData;
import me.signatured.clashroyale.spawnable.ClashSpawnable;
import me.signatured.clashroyale.util.C;
import me.signatured.clashroyale.util.ClashUtil;
import me.signatured.clashroyale.util.item.InteractiveItem;
import me.signatured.clashroyale.util.item.ItemBuilder;

@Data
@Builder
@AllArgsConstructor
public class PlayerCard {
	
	private ClashPlayer player;
	private ClashCard card;
	private int level, amount;

	public void spawn(Location loc) {
		ClashSpawnable cs = card.create(player, player.getGame(), level);
		cs.spawn(loc);
	}
	
	public ItemStack getSkull() {
		SkinData data = SkinData.getData(card.getKey());
		ItemBuilder ib = (data != null) ? ItemBuilder.of(data.getSkull()) : ItemBuilder.of(Material.PLAYER_HEAD);
		
		ib.setName(card.getRarity().getColor() + card.getName() + " (" + card.getCost() + " Elixir)");
		ib.setLore(C.GRAY + "Right click in your", C.GRAY + "territory to place!");
		
		return ib.build();
	}
	
	public ItemStack getGameSkull(ClashGame game) {
		InteractiveItem interactive = InteractiveItem.of(getSkull());
		interactive.onInteract(e -> {
			Block targetBlock = ClashUtil.getTargetBlock(e.getPlayer(), 100);
			if (targetBlock == null)
				return;
			
			if (!game.inProgress()) {
				player.message(C.RED + "You can only use this when the game is in progress!");
				return;
			}
			
			Location placed = targetBlock.getLocation().clone().add(0, 1, 0);
			if (!game.canPlace(player, placed)) {
				player.message(C.RED + "You can only place on territory you own!");
				return;
			}
			
			spawn(placed);
		});
		
		return interactive.getItem();
	}
}