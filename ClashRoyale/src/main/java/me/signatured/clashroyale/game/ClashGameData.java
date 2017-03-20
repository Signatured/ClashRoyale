package me.signatured.clashroyale.game;

import lombok.Data;
import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.card.CardDeck;
import me.signatured.clashroyale.card.PlayerCard;
import me.signatured.clashroyale.game.arena.ClashArenaData;
import me.signatured.clashroyale.task.ElixirTask;
import me.signatured.clashroyale.util.ClashUtil;
import me.signatured.clashroyale.util.xml.ArenaLoader;

@Data
public class ClashGameData {
	
	private ClashGame game;
	private ClashPlayer player;
	private CardDeck selectedDeck;
	private PlayerCard[] cards = new PlayerCard[4];
	private PlayerCard nextCard;
	private ClashArenaData data;
	private int crowns;
	private double elixir = 5;
	
	private ElixirTask elixirTask;
	
	public ClashGameData(ClashGame game, ClashPlayer player) {
		this.game = game;
		this.player = player;
		this.selectedDeck = player.getDecks()[player.getSelectedDeck()];
		
		createHand();
	}
	
	public void createArenaData(int id) {
		data = ArenaLoader.getArenaData(player, game.getWorld(), id);
	}
	
	public void useCard(int index) {
		cards[index] = nextCard;
		nextCard = getNewCard();
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
		for (int i = 0; i < 4; i++) {
			PlayerCard card = ClashUtil.getRandomEntry(selectedDeck.getCards(), cards);
			cards[i] = card;
		}
		
		nextCard = getNewCard();
	}
	
	private PlayerCard getNewCard() {
		return ClashUtil.getRandomEntry(selectedDeck.getCards(), cards);
	}
}
