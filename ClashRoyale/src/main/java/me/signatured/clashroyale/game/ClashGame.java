package me.signatured.clashroyale.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;

import lombok.Data;
import lombok.Getter;
import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.arena.Arena;
import me.signatured.clashroyale.arena.ArenaType;
import me.signatured.clashroyale.spawnable.ClashSpawnable;
import me.signatured.clashroyale.task.ElixirTask;
import me.signatured.clashroyale.task.countdown.GameCountdown;
import me.signatured.clashroyale.task.countdown.OvertimeCountdown;
import me.signatured.clashroyale.task.countdown.StartCountdown;
import me.signatured.clashroyale.util.Duration;
import me.signatured.clashroyale.util.Title;
import me.signatured.clashroyale.util.task.Async;
import me.signatured.clashroyale.util.task.Sync;
import me.signatured.clashroyale.util.task.TaskBuilder;

@Data
public class ClashGame {
	
	@Getter
	private static List<ClashGame> games = new ArrayList<>();
	
	private Arena arena;
	private ClashGameData player1;
	private ClashGameData player2;
	private ClashGameData winner;
	private GameState state;
	
	private StartCountdown startCountdown;
	private GameCountdown gameCountdown;
	private OvertimeCountdown overtimeCountdown;
	private ElixirTask elixirTask;
	
	private boolean doubleElixir = false;
	
	private List<ClashSpawnable> spawnables = new ArrayList<>();
	private List<TaskBuilder> gameTasks = new ArrayList<>();
	
	public ClashGame(ClashPlayer player1, ClashPlayer player2) {
		this.player1 = new ClashGameData(this, player1, 1);
		this.player2 = new ClashGameData(this, player2, 2);		
		this.startCountdown = new StartCountdown(this);
		this.gameCountdown = new GameCountdown(this);
		this.overtimeCountdown = new OvertimeCountdown(this);
		state = GameState.IDLE;
		
		games.add(this);
	}
	
	public ClashGameData getData(int id) {
		return getDatas().stream().filter(d -> d.getId() == id).findAny().orElse(null);
	}
	
	public ClashGameData getData(ClashPlayer player) {
		return getDatas().stream().filter(d -> d.getPlayer().equals(player)).findAny().orElse(null);
	}
	
	public boolean isWinner() {
		if (winner == null)
			findWinner();
		
		return winner != null;
	}
	
	public boolean canPlace(ClashPlayer player, Location loc) {
		return player1.getData().canPlace(player, loc) || player2.getData().canPlace(player, loc);
	}
	
	public void addElixir(double amount) {
		player1.addElixer(amount);
		player2.addElixer(amount);
	}
	
	public void loadArena() {
		new Arena(this, getArenaType().getArenaWorld());
	}
	
	//TODO: TP players to their spawn
	public void begin() {
		startCountdown.enable();
	}
	
	public void start() {
		state = GameState.REGULATION;
		elixirTask = new ElixirTask(this);
		gameCountdown.enable();
		
		sync().delay(Duration.mins(1).ticks()).run(() -> doubleElixir = true);
	}
	
	public void startOvertime() {
		state = GameState.OVERTIME;
		overtimeCountdown.enable();
	}
	
	//TODO: TP players, remove spawnables, unload world, award winner
	public void end() {
		state = GameState.ENDED;
		cancelTasks();
		removeSpawnables();
		
		sync().delay(Duration.secs(5)).run(() -> {
			//TODO: tp players, unload world
		});
	}
	
	public void title(Title title) {
		getPlayers().forEach(p -> p.title(title));
	}
	
	public void actionbar(String message) {
		getPlayers().forEach(p -> p.actionbar(message));
	}
	
	public void sound(Sound sound) {
		getPlayers().forEach(p -> p.sound(sound));
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
	
	public World getWorld() {
		return arena.getWorld();
	}
	
	public List<ClashGameData> getDatas() {
		return Arrays.asList(player1, player2);
	}
	
	public List<ClashPlayer> getPlayers() {
		return Arrays.asList(player1.getPlayer(), player2.getPlayer());
	}
	
	public TaskBuilder sync() {
		TaskBuilder builder = Sync.get();
		gameTasks.add(builder);
		
		return builder;
	}
	
	public TaskBuilder async() {
		TaskBuilder builder = Async.get();
		gameTasks.add(builder);
		
		return builder;
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
		}
	}
	
	private void cancelTasks() {
		gameCountdown.cancel();
		overtimeCountdown.cancel();
		elixirTask.cancel();
		
		gameTasks.forEach(t -> t.cancel());
	}
	
	private void removeSpawnables() {
		spawnables.stream().forEach(s -> s.despawn());
	}
	
	private ArenaType getArenaType() {
		ArenaType type1 = player1.getPlayer().getArena();
		ArenaType type2 = player2.getPlayer().getArena();
		
		return type1.getTrophyReq() > type2.getTrophyReq() ? type1 : type2;
	}
	
	public enum GameState {
		IDLE, REGULATION, OVERTIME, ENDED;
	}
}
