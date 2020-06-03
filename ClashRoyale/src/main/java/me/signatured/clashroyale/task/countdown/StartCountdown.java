package me.signatured.clashroyale.task.countdown;

import org.bukkit.Sound;

import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.util.C;
import me.signatured.clashroyale.util.Title;

public class StartCountdown extends ClashCountdown {

	public StartCountdown(ClashGame game) {
		super(game, 12);
		
		title(new Title(C.GREEN + "10", "", 0, 40, 0), 10);
		title(new Title(C.YELLOW + "5", "", 0, 25, 0), 5);
		title(new Title(C.YELLOW + "4", "", 0, 25, 0), 4);
		title(new Title(C.RED + "3", "", 0, 25, 0), 3);
		title(new Title(C.RED + "2", "", 0, 25, 0), 2);
		title(new Title(C.DRED + "1", "", 0, 25, 0), 1);
		
		sound(Sound.UI_BUTTON_CLICK, 10);
		for (int i = 1; i <= 5; i++)
			sound(Sound.UI_BUTTON_CLICK, i);
		
		onEnd(() -> game.start());
	}
	
}
