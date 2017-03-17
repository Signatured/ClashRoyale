package me.signatured.clashroyale;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.Getter;
import me.signatured.clashroyale.card.CardDeck;
import me.signatured.clashroyale.card.ClashCard;
import me.signatured.clashroyale.game.ClashArena;
import me.signatured.clashroyale.game.ClashGame;

@Data
public class ClashPlayer {
	
	@Getter
	private static List<ClashPlayer> players = new ArrayList<>();
	
	private ClashGame game;
	private List<ClashCard> ownedCards = new ArrayList<>();
	private CardDeck[] decks = new CardDeck[3];
	private int selectedDeck = 0;
	
	private ClashArena arena;
	private int trophies;
}
