package me.signatured.clashroyale.util;

import org.bukkit.*;
import org.bukkit.entity.*;

public class Title {
	private String title,subTitle;
	private int fadeIn,stay,fadeOut;

	public Title(String title, String subtitle, int fadeIn, int stay, int fadeOut) {
		this.title = title;
		this.subTitle = subtitle;
		this.fadeIn = fadeIn;
		this.stay = stay;
		this.fadeOut = fadeOut;
	}


	public void send(Player player) {
		player.sendTitle(title, subTitle, fadeIn, stay, fadeOut);
	}

	public void broadcast() {
		Bukkit.getOnlinePlayers().forEach(this::send);
	}

	public static void clearTitle(Player p) {
		p.sendTitle("", "", 0, 0, 0);
	}

	public String getTitle() {
		return this.title;
	}

	public String getSubTitle() {
		return subTitle;
	}

	public int getFadeIn() {
		return fadeIn;
	}

	public int getFadeOut() {
		return fadeOut;
	}

	public int getStay() {
		return stay;
	}
}
