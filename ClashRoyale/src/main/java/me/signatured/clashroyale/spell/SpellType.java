package me.signatured.clashroyale.spell;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SpellType {
	
	ARROWS("Arrows Spell"),
	CLONE("Clone Spell"),
	FREEZE("Freeze"),
	FIREBALL("Fireball"),
	GOBLIN_BARREL("Goblin Barrel"),
	GRAVEYARD("Graveyard"),
	LIGHTNING("Lightning"),
	MIRROR("Mirror"),
	POISON("Poison"),
	RAGE("Rage"),
	ROCKET("Rocket"),
	THE_LOG("The Log"),
	TORNADO("Tornado"),
	ZAP("Zap");
	
	private String name;
}
