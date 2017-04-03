package me.signatured.clashroyale.mechanics;

import java.util.List;

import org.bukkit.Location;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.spawnable.ClashSpawnable;
import me.signatured.clashroyale.spawnable.structure.ClashStructure;
import me.signatured.clashroyale.spawnable.types.IDamageableSpawnable;
import me.signatured.clashroyale.util.ClashUtil;
import me.signatured.clashroyale.util.ParticleBuilder;
import net.minecraft.server.v1_11_R1.EnumParticle;

@Data
public class ClashExplosion {
	
	private int radius;
	private int areaDamage;
	private int towerDamage;
	private ExplosionSize explosionSize;
	
	public void expload(ClashPlayer damage, Location loc) {
		ParticleBuilder.of(explosionSize.getParticle(), loc).send();
		List<ClashSpawnable> inRange = ClashUtil.getSpawnablesInRange(damage, loc, radius);
		
		for (ClashSpawnable s : inRange) {
			IDamageableSpawnable damageable = (IDamageableSpawnable) s;
			
			damageable.damage(s instanceof ClashStructure && ((ClashStructure)s).isCrownTower() ? towerDamage : areaDamage);
		}
	}
	
	@Getter
	@AllArgsConstructor
	public enum ExplosionSize {
		NORMAL(EnumParticle.EXPLOSION_NORMAL),
		LARGE(EnumParticle.EXPLOSION_LARGE),
		HUGE(EnumParticle.EXPLOSION_HUGE);
		
		private EnumParticle particle;
	}
}
