package me.signatured.clashroyale;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerLoginEvent;

import me.signatured.clashroyale.arena.ArenaType;
import me.signatured.clashroyale.card.CardDeck;
import me.signatured.clashroyale.card.CardList;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.util.C;
import net.citizensnpcs.api.CitizensAPI;

//TODO: This is just for testing stuff for now
public class ClashListener implements Listener {
	
	@EventHandler
	public void onLogin(PlayerLoginEvent e) {
		ClashPlayer clashPlayer = ClashPlayer.of(e.getPlayer());
		
		if(clashPlayer == null)
			clashPlayer = new ClashPlayer(e.getPlayer());
		
		clashPlayer.setOwnedCards(CardList.getInstance().getDefault());
		clashPlayer.getDecks()[0] = CardDeck.loadDefaultDeck(clashPlayer);
		clashPlayer.setArena(ArenaType.ARENA_1);
	}
	
	@EventHandler
	public void onDamage(EntityDamageEvent e) {
		if (!(e.getEntity() instanceof Player))
			return;
		Player player = (Player) e.getEntity();
		
		if (CitizensAPI.getNPCRegistry().isNPC(player))
			return;
		
		e.setCancelled(true);
	}
	
	@EventHandler
	public void onCommand(PlayerCommandPreprocessEvent e) {
		if (e.getMessage().contains("test")) {
			ClashPlayer player1 = ClashPlayer.of("Signatured");
			ClashPlayer player2 = ClashPlayer.of("Wolverine");
			
			ClashGame game = new ClashGame(player1, player2);
			game.loadArena();
			
			e.getPlayer().sendMessage(C.GREEN + "Setting up arena...");
		}
	}
}
