package me.signatured.clashroyale.util;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_11_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

import net.minecraft.server.v1_11_R1.EnumParticle;
import net.minecraft.server.v1_11_R1.PacketPlayOutWorldParticles;

public class ParticleBuilder {
	
	private EnumParticle particle;
	private float x, y, z;
	private float xOffset, yOffset, zOffset;
	private float speed;
	private int amount;
	private World world;
	
	public ParticleBuilder(EnumParticle particle) {
		this.particle = particle;
	}
	
	public ParticleBuilder(EnumParticle particle, Location loc) {
		this(particle);
	}
	
	public static ParticleBuilder of(EnumParticle particle) {
		return new ParticleBuilder(particle);
	}
	
	public static ParticleBuilder of(EnumParticle particle, Location loc) {
		return new ParticleBuilder(particle, loc);
	}
	
	public ParticleBuilder at(Location loc) {
		x = (float) loc.getX();
		y = (float) loc.getY();
		z = (float) loc.getZ();
		world = loc.getWorld();
		return this;
	}
	
	public ParticleBuilder speed(float speed) {
		this.speed = speed;
		return this;
	}
	
	public ParticleBuilder amount(int amount) {
		this.amount = amount;
		return this;
	}
	
	public ParticleBuilder setOffsetX(float xOffset) {
		this.xOffset = xOffset;
		return this;
	}
	
	public ParticleBuilder setOffsetY(float yOffset) {
		this.yOffset = yOffset;
		return this;
	}
	
	public ParticleBuilder setOffsetZ(float zOffset) {
		this.zOffset = zOffset;
		return this;
	}
	
	public void send(Player player) {
		 ((CraftPlayer) player).getHandle().playerConnection.sendPacket(create());
	}
	
	public void send() {
		world.getPlayers().forEach(this::send);
	}
	
	public PacketPlayOutWorldParticles create() {
		return new PacketPlayOutWorldParticles(particle, true, x, y, z, xOffset, yOffset, zOffset, speed, amount, null);
	}
}
