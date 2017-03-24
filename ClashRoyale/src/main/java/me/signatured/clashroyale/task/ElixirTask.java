package me.signatured.clashroyale.task;

import me.signatured.clashroyale.ClashRoyale;
import me.signatured.clashroyale.game.ClashGame;

public class ElixirTask extends ClashTask {

	private ClashGame game;
	
	public ElixirTask(ClashGame game) {
		super(ClashRoyale.getInstance());
		this.game = game;
		
		enable();
	}

	@Override
	public void run() {
		if (!game.isDoubleElixir())
			game.addElixir(1.0 / 56); // 0.01785 elixir per tick, 1 elixir every 2.8 seconds
		else
			game.addElixir(2 * (1.0 / 56)); // 0.0357 elixir per tick, 2 elixir every 2.8 seconds
	}

	@Override
	public void enable() {
		this.runTaskTimer(getPlugin(), 0, 1);
	}

}
