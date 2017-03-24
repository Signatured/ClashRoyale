package me.signatured.clashroyale.task.countdown;

import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.util.C;
import me.signatured.clashroyale.util.Duration;
import me.signatured.clashroyale.util.Title;

public class GameCountdown extends ClashCountdown {

	public GameCountdown(ClashGame game) {
		super(game, Duration.mins(2));
		
		title(new Title(C.GREEN + "FIGHT").setStayTime(1), getTime());
		title(new Title(C.YELLOW + "Battle Ends In...").setStayTime(3), 12);
		for (int i = 6; i <= 10; i++)
			title(new Title(C.YELLOW + i), i);
		for (int i = 2; i <= 5; i++)
			title(new Title(C.RED + i), i);
		
		title(new Title(C.DRED + 1), 1);
		
		onEnd(() -> {
			if (!game.isWinner()) {
				game.startOvertime();
				return;
			}
			
			game.end();
		});
	}
	
}
