package me.signatured.clashroyale.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lombok.Data;
import lombok.Getter;
import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.task.ElixirTask;
import me.signatured.clashroyale.task.GameTimeTask;

@Data
public class ClashGame {
	
	@Getter
	private static List<ClashGame> games = new ArrayList<>();
	
	private ClashGameData player1;
	private ClashGameData player2;
	private ClashGameData winner;
	private GameState state;
	
	private GameTimeTask gameTask;
	private ElixirTask elixirTask;
	
	public ClashGame(ClashPlayer player1, ClashPlayer player2) {
		this.player1 = new ClashGameData(this, player1);
		this.player2 = new ClashGameData(this, player2);
		
		elixirTask = new ElixirTask(this);
		state = GameState.IDLE;
		
		games.add(this);
	}
	
	public ClashGameData getData(ClashPlayer player) {
		return getDatas().stream().filter(d -> d.getPlayer().equals(player)).findAny().orElse(null);
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
		state = GameState.ENDED;
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
	
	private List<ClashGameData> getDatas() {
		return Arrays.asList(player1, player2);
	}
	
	public enum GameState {
		IDLE, REGULATION, OVERTIME, ENDED;
	}
}
