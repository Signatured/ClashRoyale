package me.signatured.clashroyale.task;

import java.time.Duration;

import me.signatured.clashroyale.ClashRoyale;
import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.util.Expiration;

public class GameTimeTask extends ClashTask {
	
	private ClashGame game;
	private Expiration expiration;

	public GameTimeTask() {
		super(ClashRoyale.getInstance());
		this.expiration = new Expiration(Duration.ofMinutes(2));
	}

	@Override
	public void run() {
		if (game.ended()) {
			cancel();
			return;
		}
		
		if (expiration.isExpired()) {
			if (game.regulation()) {
				if (!game.isWinner()) {
					expiration.expireIn(Duration.ofMinutes(1));
					game.startOvertime();
					return;
				}
				
				game.end();
				cancel();
				return;
			} else if (game.overtime()) {
				game.end();
				cancel();
				return;
			}
		}
	}
	
	public int getTimeLeft() {
		return (int) expiration.getRemaining().getSeconds();
	}

	@Override
	public void enable() {
		this.runTaskTimer(getPlugin(), 0, 1);
	}

}