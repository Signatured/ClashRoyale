package me.signatured.clashroyale.task.countdown;

import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.util.C;
import me.signatured.clashroyale.util.Duration;
import me.signatured.clashroyale.util.Title;

public class GameCountdown extends ClashCountdown {

	public GameCountdown(ClashGame game) {
		super(game, Duration.mins(2));
		
		title(new Title(C.GREEN + "FIGHT", "", 10, 20, 10), getTime());
		title(new Title(C.YELLOW + "Battle Ends In...", "", 10, 20 * 3, 10), 12);
		for (int i = 6; i <= 10; i++)
			title(new Title(C.YELLOW + i, "", 0, 25, 0), i);
		for (int i = 2; i <= 5; i++)
			title(new Title(C.RED + i, "", 0, 25, 0), i);
		
		title(new Title(C.DRED + 1, "", 0, 25, 0), 1);
		
		onEnd(() -> {
			if (!game.isWinner()) {
				game.startOvertime();
				return;
			}
			
			game.end();
		});
	}
	
}
