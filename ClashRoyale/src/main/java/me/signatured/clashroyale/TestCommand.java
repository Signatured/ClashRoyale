package me.signatured.clashroyale;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import me.signatured.clashroyale.game.ClashGame;
import me.signatured.clashroyale.util.C;

public class TestCommand extends Command {

	protected TestCommand() {
		super("test");
	}

	@Override
	public boolean execute(CommandSender sender, String arg1, String[] arg2) {
		ClashPlayer player1 = ClashPlayer.of("Signatured");
		ClashPlayer player2 = ClashPlayer.of("Wolverine");
		
		ClashGame game = new ClashGame(player1, player2);
		game.loadArena();
		
		sender.sendMessage(C.GREEN + "Setting up arena...");
		return true;
	}
	
}
