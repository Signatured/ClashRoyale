package me.signatured.clashroyale.util;

import org.bukkit.ChatColor;

/**
 * Chat colors in string form for easy chatcolor combining
 * 
 * @author Signatured
 *
 */
public class C {
	
	public static final String BLACK = ChatColor.BLACK.toString();
	public static final String DBLUE = ChatColor.DARK_BLUE.toString();
	public static final String DGREEN = ChatColor.DARK_GREEN.toString();
	public static final String DAQUA = ChatColor.DARK_AQUA.toString();
	public static final String DRED = ChatColor.DARK_RED.toString();
	public static final String DPURPLE = ChatColor.DARK_PURPLE.toString();
	public static final String GOLD = ChatColor.GOLD.toString();
	public static final String GRAY = ChatColor.GRAY.toString();
	public static final String DGRAY = ChatColor.DARK_GRAY.toString();
	public static final String BLUE = ChatColor.BLUE.toString();
	public static final String GREEN = ChatColor.GREEN.toString();
	public static final String AQUA = ChatColor.AQUA.toString();
	public static final String RED = ChatColor.RED.toString();
	public static final String LPURPLE = ChatColor.LIGHT_PURPLE.toString();
	public static final String YELLOW = ChatColor.YELLOW.toString();
	public static final String WHITE = ChatColor.WHITE.toString();
	public static final String MAGIC = ChatColor.MAGIC.toString();
	public static final String PURPLE = LPURPLE;
	public static final String CYAN = AQUA;
	public static final String ORANGE = GOLD;
	public static final String R = ChatColor.RESET.toString();
	public static final String B = ChatColor.BOLD.toString();
	public static final String S = ChatColor.STRIKETHROUGH.toString();
	public static final String U = ChatColor.UNDERLINE.toString();
	public static final String I = ChatColor.ITALIC.toString();
	
	public static String translate(String message) {
		return ChatColor.translateAlternateColorCodes('&', message);
	}
}
