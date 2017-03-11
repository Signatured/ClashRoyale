package me.signatured.clashroyale.card;

import java.util.List;

import lombok.Data;

@Data
public class CardDeck {
	
	private String name;
	private final ClashCard[] cards = new ClashCard[8];
	
	public CardDeck(String name) {
		this.name = name;
	}
	
	public void load(List<ClashCard> list) {
		for (int i = 0; i < list.size(); i++)
			cards[i] = list.get(i);
	}
}
