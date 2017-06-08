package me.signatured.clashroyale.card;

import java.util.List;

import lombok.Data;
import me.signatured.clashroyale.ClashPlayer;

@Data
public class CardDeck {
	
	private final PlayerCard[] cards = new PlayerCard[8];
	
	public static CardDeck loadDefaultDeck(ClashPlayer player) {
		CardDeck deck = new CardDeck();
		List<ClashCard> list = CardList.getInstance().getDefault();
		
		for (int i = 0; i < list.size(); i++)
			deck.getCards()[i] = new PlayerCard(player, list.get(i), 1, 0);
		
		return deck;
	}
	
	public void load(List<PlayerCard> list) {
		for (int i = 0; i < list.size(); i++)
			cards[i] = list.get(i);
	}
}
