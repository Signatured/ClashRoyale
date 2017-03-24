package me.signatured.clashroyale.task.countdown;

import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.util.C;
import me.signatured.clashroyale.util.Duration;
import me.signatured.clashroyale.util.Title;

public class OvertimeCountdown extends ClashCountdown {

	public OvertimeCountdown(ClashGame game) {
		super(game, Duration.mins(3));
		
		title(new Title(C.DRED + "Sudden Death", C.YELLOW + "- Next Crown WINS -").setStayTime(4), getTime());
		title(new Title(C.DRED + "+180s", C.YELLOW + "Extra Time").setStayTime(2), getTime() - 3);
		title(new Title(C.YELLOW + "Battle Ends In...").setStayTime(3), 12);
		for (int i = 6; i <= 10; i++)
			title(new Title(C.YELLOW + i), i);
		for (int i = 2; i <= 5; i++)
			title(new Title(C.RED + i), i);
		
		title(new Title(C.DRED + 1), 1);
		
		onEnd(() -> game.end());
	}
	
}
