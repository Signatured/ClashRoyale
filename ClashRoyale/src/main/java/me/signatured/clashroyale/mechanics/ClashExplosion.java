package me.signatured.clashroyale.mechanics;

import java.util.List;

import org.bukkit.Location;

import lombok.Data;
import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.spawnable.ClashSpawnable;
import me.signatured.clashroyale.spawnable.structure.ClashStructure;
import me.signatured.clashroyale.spawnable.types.IDamageableSpawnable;
import me.signatured.clashroyale.util.ClashUtil;
import me.signatured.clashroyale.util.ParticleBuilder;
import net.minecraft.server.v1_8_R3.EnumParticle;

@Data
public class ClashExplosion {
	
	private int radius;
	private int areaDamage;
	private int towerDamage;
	
	public void expload(ClashPlayer damage, Location loc) {
		ParticleBuilder.of(EnumParticle.EXPLOSION_LARGE, loc).send();
		List<ClashSpawnable> inRange = ClashUtil.getSpawnablesInRange(damage, loc, radius);
		
		for (ClashSpawnable s : inRange) {
			IDamageableSpawnable damageable = (IDamageableSpawnable) s;
			
			damageable.damage(s instanceof ClashStructure && ((ClashStructure)s).isCrownTower() ? towerDamage : areaDamage);
		}
	}
}
