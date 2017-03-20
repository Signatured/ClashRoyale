package me.signatured.clashroyale.util.shape;

import java.util.Random;

import org.bukkit.Location;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Cuboid {
		
	private Location corner1;
	private Location corner2;

	public boolean contains(Location location) {
		if (location == null)
			throw new IllegalArgumentException("location can't be null");
		if (corner1 == null)
			throw new NullPointerException("corner1 can't be null");
		if (location.getWorld() != corner1.getWorld())
			return false;

		if (corner2 == null) {
			if (corner1.getBlockX() != location.getBlockX())
				return false;
			if (corner1.getBlockY() != location.getBlockY())
				return false;
			if (corner1.getBlockZ() != location.getBlockZ())
				return false;
			return true;
		}
		if (!isWithinCoords(corner1.getBlockX(), corner2.getBlockX(), location.getBlockX()))
			return false;
		if (!isWithinCoords(corner1.getBlockY(), corner2.getBlockY(), location.getBlockY()))
			return false;
		if (!isWithinCoords(corner1.getBlockZ(), corner2.getBlockZ(), location.getBlockZ()))
			return false;
		return true;
	}
	
	public Location getRandomLoc() {
		double x = random(corner1.getX(), corner2.getX());
		double y = random(corner1.getY(), corner2.getY());
		double z = random(corner1.getZ(), corner2.getZ());
		Location location = new Location(corner1.getWorld(), x, y, z);
		return location;
	}

	private boolean isWithinCoords(double coord1, double coord2, double value) {
		if (coord1 > coord2)
			return (value <= coord1 && value >= coord2);
		return (value <= coord2 && value >= coord1);
	}
	
	private double random(double d1, double d2) {
		Random random = new Random();
		double min = (d1 > d2) ? d2 : d1;
		double max = (d1 > d2) ? d1 : d2;
		return min + (random.nextDouble() * ((max - min) + 1));
	}
}
