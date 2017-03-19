package me.signatured.clashroyale.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class Duration {
	
	@Getter
	@AllArgsConstructor
	public static enum Unit {
		MILLISECOND(1), 
		TICK(50), 
		SECOND(1000), 
		MINUTE(60000), 
		HOUR(3600000), 
		DAY(86400000), 
		WEEK(604800000),
		YEAR(31536000000L);
		
		final long milliseconds;
	}
	
	private final long milliseconds;
	
	public Duration(long amount, Unit unit) {
		milliseconds = (amount * unit.getMilliseconds());
	}

	public Duration(double amount, Unit unit) {
		milliseconds = (long)(amount * unit.getMilliseconds());
	}
	
	public static Duration ms(long ms) {
		return new Duration(ms, Unit.MILLISECOND);
	}
	
	public static Duration ms(double ms) {
		return new Duration(ms, Unit.MILLISECOND);
	}
	
	public static Duration ticks(long ticks) {
		return new Duration(ticks, Unit.TICK);
	}
	
	public static Duration ticks(double ticks) {
		return new Duration(ticks, Unit.TICK);
	}
	
	public static Duration secs(long secs) {
		return new Duration(secs, Unit.SECOND);
	}
	
	public static Duration secs(double secs) {
		return new Duration(secs, Unit.SECOND);
	}
	
	public static Duration mins(long mins) {
		return new Duration(mins, Unit.MINUTE);
	}
	
	public static Duration mins(double mins) {
		return new Duration(mins, Unit.MINUTE);
	}
	
	public static Duration hours(long hours) {
		return new Duration(hours, Unit.HOUR);
	}
	
	public static Duration hours(double hours) {
		return new Duration(hours, Unit.HOUR);
	}
	
	public static Duration days(long days) {
		return new Duration(days, Unit.DAY);
	}
	
	public static Duration days(double days) {
		return new Duration(days, Unit.DAY);
	}
	
	public static Duration weeks(long weeks) {
		return new Duration(weeks, Unit.WEEK);
	}
	
	public static Duration weeks(double weeks) {
		return new Duration(weeks, Unit.WEEK);
	}
	
	public static Duration years(long years) {
		return new Duration(years, Unit.YEAR);
	}
	
	public static Duration years(double years) {
		return new Duration(years, Unit.YEAR);
	}
	
	public long ms() {
		return milliseconds;
	}
	
	public int ticks() {
		return (int) getValue(Unit.TICK);
	}
	
	public int secs() {
		return (int) getValue(Unit.SECOND);
	}
	
	public int mins() {
		return (int) getValue(Unit.MINUTE);
	}
	
	public int hours() {
		return (int) getValue(Unit.HOUR);
	}
	
	public int days() {
		return (int) getValue(Unit.DAY);
	}
	
	public int weeks() {
		return (int) getValue(Unit.WEEK);
	}
	
	public int years() {
		return (int) getValue(Unit.YEAR);
	}
	
	public long getValue(Unit unit) {
		return ms() / unit.getMilliseconds();
	}
}
