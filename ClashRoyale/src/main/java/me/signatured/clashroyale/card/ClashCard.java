package me.signatured.clashroyale.card;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ClashCard {
	
	private CardType type;
	private int level;
	private int number;
}
