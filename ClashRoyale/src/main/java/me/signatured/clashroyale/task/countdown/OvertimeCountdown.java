package me.signatured.clashroyale.task.countdown;

import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.util.C;
import me.signatured.clashroyale.util.Duration;
import me.signatured.clashroyale.util.Title;

public class OvertimeCountdown extends ClashCountdown {

	public OvertimeCountdown(ClashGame game) {
		super(game, Duration.mins(3));
		
		title(new Title(C.DRED + "Sudden Death", C.YELLOW + "- Next Crown WINS -", 10, 20 * 4, 10), getTime());
		title(new Title(C.DRED + "+180s", C.YELLOW + "Extra Time", 10, 20 * 2, 10), getTime() - 3);
		title(new Title(C.YELLOW + "Battle Ends In...", "", 10, 20 * 3, 10), 12);
		for (int i = 6; i <= 10; i++)
			title(new Title(C.YELLOW + i, "", 0, 25, 0), i);
		for (int i = 2; i <= 5; i++)
			title(new Title(C.RED + i, "", 0, 25, 0), i);
		
		title(new Title(C.DRED + 1, "", 0, 25, 0), 1);
		
		onEnd(() -> game.end());
	}
	
}
