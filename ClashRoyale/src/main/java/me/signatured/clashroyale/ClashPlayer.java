package me.signatured.clashroyale;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import me.signatured.clashroyale.card.CardDeck;
import me.signatured.clashroyale.card.ClashCard;

public class ClashPlayer {
	
	@Getter
	private static List<ClashPlayer> players = new ArrayList<>();
	
	private List<ClashCard> ownedCards = new ArrayList<>();
	private CardDeck[] decks = new CardDeck[3];
}
