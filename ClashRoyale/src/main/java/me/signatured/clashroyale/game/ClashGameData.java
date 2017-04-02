package me.signatured.clashroyale.game;

import org.bukkit.Location;

import lombok.Data;
import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.arena.ArenaData;
import me.signatured.clashroyale.card.CardDeck;
import me.signatured.clashroyale.card.PlayerCard;
import me.signatured.clashroyale.task.ElixirTask;
import me.signatured.clashroyale.util.ClashUtil;

@Data
public class ClashGameData {
	
	private int id;
	private ClashGame game;
	private ClashPlayer player;
	private CardDeck selectedDeck;
	private PlayerCard[] cards = new PlayerCard[4];
	private PlayerCard nextCard;
	private ArenaData data;
	private int crowns;
	private double elixir = 5;
	
	private ElixirTask elixirTask;
	
	public ClashGameData(ClashGame game, ClashPlayer player, int id) {
		this.game = game;
		this.player = player;
		this.selectedDeck = player.getDeck();
		
		createHand();
	}
	
	public void useCard(Location loc, int index) {
		PlayerCard used = cards[index];
		int cost = used.getCard().getCost();
		
		if (cost > elixir) {
			player.message("You need " + cost + " elixir to use " + used.getCard().getName());
			return;
		}
		
		elixir -= cost;
		used.spawn(loc);
		
		cards[index] = nextCard;
		nextCard = getNewCard();
		
		//TODO: give new card
	}
	
	public void giveHand() {
		if (!player.isOnline())
			return;
		
		for (int i = 0; i < 4; i++)
			player.getInventory().setItem(i, cards[i].getGameSkull(game));
		
		player.getInventory().setItem(8, nextCard.getSkull());
	}
	
	public void addElixer(double amount) {
		elixir = Math.min(elixir + amount, 10);
	}
	
	public void addCrown() {
		crowns++;
	}
	
	public boolean maxCrowns() {
		return crowns >= 3;
	}
	
	private void createHand() {
		for (int i = 0; i < 4; i++) 
			cards[i] = getNewCard();
		
		nextCard = getNewCard();
	}
	
	private PlayerCard getNewCard() {
		return ClashUtil.getRandomEntry(selectedDeck.getCards(), cards);
	}
}
