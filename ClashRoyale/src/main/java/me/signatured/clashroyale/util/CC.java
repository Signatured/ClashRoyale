package me.signatured.clashroyale.util;

import org.bukkit.*;

import java.util.stream.*;

/**
 * Representation of a shortened Bukkit ChatColor enum.
 * @author Brittan Thomas
 */
public enum CC {
	/**
	 * Represents black.
	 */
	BLACK('0', 0x00, ChatColor.BLACK, 0x000000),
	/**
	 * Represents dark blue.
	 */
	DARK_BLUE('1', 0x1, ChatColor.DARK_BLUE, 0x0000AA),
	/**
	 * Represents dark green.
	 */
	DARK_GREEN('2', 0x2, ChatColor.DARK_GREEN, 0x00AA00),
	/**
	 * Represents dark blue (aqua).
	 */
	DARK_AQUA('3', 0x3, ChatColor.DARK_AQUA, 0x00AAAA),
	/**
	 * Represents dark red.
	 */
	DARK_RED('4', 0x4, ChatColor.DARK_RED, 0xAA0000),
	/**
	 * Represents dark purple.
	 */
	DARK_PURPLE('5', 0x5, ChatColor.DARK_PURPLE, 0xAA00AA),
	/**
	 * Represents gold.
	 */
	GOLD('6', 0x6, ChatColor.GOLD, 0xFFAA00),
	/**
	 * Represents gray.
	 */
	GRAY('7', 0x7, ChatColor.GRAY, 0xAAAAAA),
	/**
	 * Represents dark gray.
	 */
	DARK_GRAY('8', 0x8, ChatColor.DARK_GRAY, 0x555555),
	/**
	 * Represents blue.
	 */
	BLUE('9', 0x9, ChatColor.BLUE, 0x5555FF),
	/**
	 * Represents green.
	 */
	GREEN('a', 0xA, ChatColor.GREEN, 0x55FF55),
	/**
	 * Represents aqua.
	 */
	AQUA('b', 0xB, ChatColor.AQUA, 0x55FFFF),
	/**
	 * Represents red.
	 */
	RED('c', 0xC, ChatColor.RED, 0xFF5555),
	/**
	 * Represents light purple.
	 */
	LIGHT_PURPLE('d', 0xD, ChatColor.LIGHT_PURPLE, 0xFF55FF),
	/**
	 * Represents yellow.
	 */
	YELLOW('e', 0xE, ChatColor.YELLOW, 0xFFFF55),
	/**
	 * Represents white.
	 */
	WHITE('f', 0xF, ChatColor.WHITE, 0xFFFFFF),
	/**
	 * Represents magical characters that change around randomly.
	 */
	MAGIC('k', 0x10, true, ChatColor.MAGIC, null),
	/**
	 * Makes the text bold.
	 */
	BOLD('l', 0x11, true, ChatColor.BOLD, null),
	/**
	 * Makes a line appear through the text.
	 */
	STRIKETHROUGH('m', 0x12, true, ChatColor.STRIKETHROUGH, null),
	/**
	 * Makes the text appear underlined.
	 */
	UNDERLINE('n', 0x13, true, ChatColor.UNDERLINE, null),
	/**
	 * Makes the text italic.
	 */
	ITALIC('o', 0x14, true, ChatColor.ITALIC, null),
	/**
	 * Resets all previous chat colors or formats.
	 */
	RESET('r', 0x15, ChatColor.RESET, null);

	/**
	 * The special character which prefixes all chat colour codes. Use this if
	 * you need to dynamically convert colour codes from your custom format.
	 */
	public static final char COLOR_CHAR = '\u00A7';

	public String prefix() {
		return bold() + "(!) " + this;
	}

	/**
	 * Strips the specified message of all color codes.
	 * @param message - the message to strip of color.
	 * @return the message string without any coloring.
	 */
	public static String strip(final String message) {
		if (message == null)
			return null;

		return ChatColor.stripColor(message);
	}

	/**
	 * Shortened version of {@link ChatColor#translateAlternateColorCodes(char, String)}.
	 * @param alternate - the alternate color code character to replace the original.
	 * @param message - the message containing the alternate code character to be swapped.
	 * @return the message with all alternate characters swapped for the original.
	 */
	public static String translate(char alternate, String message) {
		return ChatColor.translateAlternateColorCodes(alternate, message);
	}

	/**
	 * Instantiates a new formatting code.
	 * @param format - the format
	 * @param id - the id
	 */
	private CC(char format, int id, ChatColor bukkit, Integer rgb) {
		this(format, id, false, bukkit, rgb);
	}

	/** Instantiates a new formatting code.
	 * @param format - the format
	 * @param id - the id
	 * @param formatting - the formatting
	 */
	private CC(char format, int id, boolean formatting, ChatColor bukkit, Integer rgb) {
		this.format = format;
		this.id = id;
		this.formatting = formatting;
		this.bukkit = bukkit;
		this.rgb = rgb;
		string = new String(new char[] { COLOR_CHAR, format });
	}

	public final Integer rgb;

	/**
	 * The character unique to this chat format.
	 */
	private char format;

	/**
	 * Gets the character unique to this chat format.
	 * @return the character unique to this chat format
	 */
	public char getFormat() {
		return format;
	}

	/**
	 * The identifying number for this color.
	 */
	private int id;

	/**
	 * Gets the identifying number for this color.
	 * @return the identifying number for this color
	 */
	public int getId() {
		return id;
	}

	/**
	 * If this code is a format code as opposed to a color code.
	 */
	private boolean formatting;

	/**
	 * Checks if is if this code is a format code as opposed to a color code.
	 * @return the if this code is a format code as opposed to a color code
	 */
	public boolean isFormatting() {
		return formatting;
	}

	/**
	 * This formatting code compiled into a string for sending.
	 */
	private String string;

	/* (non-Javadoc)
	 * @see java.lang.Enum#toString()
	 */
	@Override
	public String toString() {
		return string;
	}

	public final ChatColor bukkit;

	/**
	 * Gets this chat color with the {@link #BOLD} code suffixed.
	 * @return this chat color with the {@link #BOLD} code suffixed.
	 */
	public String bold() {
		return toString() + BOLD.toString();
	}

	public String magic() {
		return toString() + MAGIC.toString();
	}

	public String underline() {
		return toString() + UNDERLINE.toString();
	}

	/**
	 * Gets this chat color with the {@link #STRIKETHROUGH} code suffixed.
	 * @return this chat color with the {@link #STRIKETHROUGH} code suffixed.
	 */
	public String strike() {
		return strikethrough();
	}

	/**
	 * Gets this chat color with the {@link #STRIKETHROUGH} code suffixed.
	 * @return this chat color with the {@link #STRIKETHROUGH} code suffixed.
	 */
	public String strikethrough() {
		return toString() + STRIKETHROUGH.toString();
	}

	/**
	 * Gets this chat color with the {@link #ITALIC} code suffixed.
	 * @return this chat color with the {@link #ITALIC} code suffixed.
	 */
	public String ital() {
		return italic();
	}

	/**
	 * Gets this chat color with the {@link #ITALIC} code suffixed.
	 * @return this chat color with the {@link #ITALIC} code suffixed.
	 */
	public String italics() {
		return italic();
	}

	/**
	 * Gets this chat color with the {@link #ITALIC} code suffixed.
	 * @return this chat color with the {@link #ITALIC} code suffixed.
	 */
	public String italic() {
		return toString() + ITALIC.toString();
	}

	/**
	 * Gets this chat color with the {@link #RESET} code prefixed.
	 * @return this chat color with the {@link #RESET} code prefixed.
	 */
	public String reset() {
		return RESET.toString() + toString();
	}

	/*
	 * Shorthand versions of original values.
	 */

	/**
	 * Shorthand representation of DARK_BLUE.
	 */
	public static CC DBLUE = DARK_BLUE;

	/**
	 * Shorthand representation of DARK_GREEN.
	 */
	public static CC DGREEN = DARK_GREEN;

	/**
	 * Shorthand representation of DARK_AQUA.
	 */
	public static CC DAQUA = DARK_AQUA;

	/**
	 * Shorthand representation of DARK_RED.
	 */
	public static CC DRED = DARK_RED;

	/**
	 * Shorthand representation of DARK_PURPLE.
	 */
	public static CC DPURPLE = DARK_PURPLE;

	/**
	 * Shorthand representation of LIGHT_PURPLE.
	 */
	public static CC LPURPLE = LIGHT_PURPLE;

	/**
	 * Shorthand representation of LIGHT_PURPLE.
	 */
	public static CC PINK = LIGHT_PURPLE;

	/**
	 * Shorthand representation of DARK_GRAY.
	 */
	public static CC DGRAY = DARK_GRAY;

	/**
	 * Shorthand representation of BOLD.
	 */
	public static CC B = BOLD;

	/**
	 * Shorthand representation of UNDERLINE.
	 */
	public static CC U = UNDERLINE;

	/**
	 * Shorthand representation of ITALIC.
	 */
	public static CC I = ITALIC;

	/**
	 * Alternate representation of ITALIC.
	 */
	public static CC ITALICS = ITALIC;

	/**
	 * Shorthand representation of RESET.
	 */
	public static CC R = RESET;

	/**
	 * Shorthand representation of STRIKETHROUGH.
	 */
	public static CC S = STRIKETHROUGH;

	public static CC fromColor(DyeColor color) {
		switch (color) {
			case GREEN:
				return DARK_GREEN;
			case BLACK:
				return BLACK;
			case BLUE:
				return BLUE;
			case CYAN:
				return AQUA;
			case GRAY:
				return GRAY;
			case LIGHT_BLUE:
				return AQUA;
			case LIME:
				return GREEN;
			case MAGENTA:
				return DARK_PURPLE;
			case ORANGE:
				return GOLD;
			case PINK:
				return LIGHT_PURPLE;
			case PURPLE:
				return DARK_PURPLE;
			case RED:
				return RED;
			case LIGHT_GRAY:
				return WHITE;
			case WHITE:
				return WHITE;
			case YELLOW:
				return YELLOW;
			default:
				return null;
		}
	}

	public static CC fromChatColor(ChatColor color) {
		return Stream.of(values()).filter(c -> c.bukkit.equals(color)).findAny().orElse(null);
	}

}
