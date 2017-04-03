package me.signatured.clashroyale.task.countdown;

import org.bukkit.Sound;

import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.util.C;
import me.signatured.clashroyale.util.Title;

public class StartCountdown extends ClashCountdown {

	public StartCountdown(ClashGame game) {
		super(game, 10);
		
		title(new Title(C.GREEN + "10"), 10);
		title(new Title(C.YELLOW + "5"), 5);
		title(new Title(C.YELLOW + "4"), 4);
		title(new Title(C.RED + "3"), 3);
		title(new Title(C.RED + "2"), 2);
		title(new Title(C.DRED + "1"), 1);
		
		sound(Sound.UI_BUTTON_CLICK, 10);
		for (int i = 1; i <= 5; i++)
			sound(Sound.UI_BUTTON_CLICK, i);
		
		onEnd(() -> game.start());
	}
	
}
