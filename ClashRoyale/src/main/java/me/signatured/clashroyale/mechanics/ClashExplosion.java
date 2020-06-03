package me.signatured.clashroyale.mechanics;

import lombok.*;
import me.signatured.clashroyale.*;
import me.signatured.clashroyale.spawnable.*;
import me.signatured.clashroyale.spawnable.structure.*;
import me.signatured.clashroyale.spawnable.types.*;
import me.signatured.clashroyale.util.*;
import org.bukkit.*;

import java.util.*;

@Data
public class ClashExplosion {
	
	private int radius;
	private int areaDamage;
	private int towerDamage;
	private ExplosionSize explosionSize;
	
	public void expload(ClashPlayer damage, Location loc) {
		ParticleBuilder.of(explosionSize.getParticle()).location(loc).spawn();
		List<ClashSpawnable> inRange = ClashUtil.getSpawnablesInRange(damage, loc, radius);
		
		for (ClashSpawnable s : inRange) {
			IDamageableSpawnable damageable = (IDamageableSpawnable) s;
			
			damageable.damage(s instanceof ClashStructure && ((ClashStructure)s).isCrownTower() ? towerDamage : areaDamage);
		}
	}
	
	@Getter
	@AllArgsConstructor
	public enum ExplosionSize {
		NORMAL(Particle.EXPLOSION_NORMAL),
		LARGE(Particle.EXPLOSION_LARGE),
		HUGE(Particle.EXPLOSION_HUGE);
		
		private Particle particle;
	}
}
