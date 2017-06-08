package me.signatured.clashroyale.util;

/**
 * A class that "expires" after a certain amount of time.
 */
public class Expiration {

	private long expiration = 0;
	
	public Expiration(Duration duration) {
		expireIn(duration);
	}
	
	public Expiration(long milliseconds) {
		expireIn(milliseconds);
	}

	/**
	 * Expires after the given number of milliseconds.
	 *
	 * @param milliseconds The number of milliseconds to expire after.
	 * @return This instance.
	 */
	public Expiration expireIn(long milliseconds) {
		expiration = System.currentTimeMillis() + milliseconds;
		return this;
	}

	/**
	 * Expires after the given Duration of time.
	 *
	 * @param duration The time to expire after.
	 * @return This instance.
	 */
	public Expiration expireIn(Duration duration) {
		return expireIn(duration.ms());
	}

	/**
	 * Expires now - any subsequent calls to {@link #isExpired()} will return
	 * true.
	 */
	public void expireNow() {
		expiration = 0;
	}

	/**
	 * @return True if the expiration time has been reached.
	 */
	public boolean isExpired() {
		return System.currentTimeMillis() >= expiration;
	}

	/**
	 * @return The timestamp to expire at.
	 */
	public long getExpiration() {
		return expiration;
	}

	/**
	 * @return A Duration spanning the length of time remaining.
	 */
	public Duration getRemaining() {
		return Duration.ms(expiration - System.currentTimeMillis());
	}
}
