package me.signatured.clashroyale.game;

import lombok.Data;
import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.task.ElixirTask;
import me.signatured.clashroyale.task.GameTimeTask;

@Data
public class ClashGame {
	
	private ClashGameData player1;
	private ClashGameData player2;
	private ClashGameData winner;
	private GameState state;
	
	private GameTimeTask gameTask;
	private ElixirTask elixirTask;
	
	public ClashGame(ClashPlayer player1, ClashPlayer player2) {
		//TODO: Handle ClashGameData
		
		elixirTask = new ElixirTask(this);
		state = GameState.IDLE;
	}
	
	public boolean isWinner() {
		if (winner == null)
			findWinner();
		
		return winner != null;
	}
	
	public void addElixir(double amount) {
		player1.addElixer(amount);
		player2.addElixer(amount);
	}
	
	public void start() {
		state = GameState.REGULATION;
	}
	
	public void startOvertime() {
		state = GameState.OVERTIME;
	}
	
	public void end() {
		
	}
	
	public boolean inProgress() {
		return regulation() || overtime();
	}
	
	public boolean regulation() {
		return state == GameState.REGULATION;
	}
	
	public boolean overtime() {
		return state == GameState.OVERTIME;
	}
	
	public boolean ended() {
		return state == GameState.ENDED;
	}
	
	private void findWinner() {
		if (player1.maxCrowns() || player2.maxCrowns()) {
			winner = (player1.maxCrowns()) ? player1 : player2;
			return;
		}
		
		if (overtime() && (player1.getCrowns() > player2.getCrowns() || player1.getCrowns() < player2.getCrowns())) {
			winner = (player1.getCrowns() > player2.getCrowns()) ? player1 : player2;
			return;
		}
		
		if (ended()) {
			if (player1.getCrowns() == player2.getCrowns())
				return;
			
			winner = (player1.getCrowns() > player2.getCrowns()) ? player1 : player2;
			return;
		}
	}
	
	public enum GameState {
		IDLE, REGULATION, OVERTIME, ENDED;
	}
}
