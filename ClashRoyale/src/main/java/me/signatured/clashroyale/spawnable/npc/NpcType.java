package me.signatured.clashroyale.spawnable.npc;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum NpcType {
	
	ARCHER(125, 41, 5),
	ARENA_TOWER_NPC(100, 100, 5),
	BABY_DRAGON(100, 100, 5),
	BANDIT(100, 100, 5),
	BARBARIAN(100, 100, 5),
	BARBARIANS(100, 100, 5),
	BAT(100, 100, 5),
	BOMBER(100, 100, 5),
	BOWLER(100, 100, 5),
	BALLOON(100, 100, 5),
	DARK_PRINCE(100, 100, 5),
	DART_GOBLIN(100, 100, 5),
	ELECTRO_WIZARD(100, 100, 5),
	ELITE_BARBARIAN(100, 100, 5),
	ELITE_BARBARIANS(100, 100, 5),
	EXECUTIONER(100, 100, 5),
	FIRE_SPIRIT(100, 100, 5),
	FIRE_SPIRITS(100, 100, 5),
	GIANT(100, 100, 5),
	GIANT_SKELETON(100, 100, 5),
	GOBLIN(100, 100, 5),
	GOBLINS(100, 100, 5),
	GOLEM(100, 100, 5),
	MINI_GOLEM(100, 100, 5),
	MINI_GOLEMS(100, 100, 5),
	GUARD(100, 100, 5),
	GUARDS(100, 100, 5),
	HOG_RIDER(100, 100, 5),
	ICE_SPIRIT(100, 100, 5),
	ICE_WIZARD(100, 100, 5),
	ICE_GOLEM(100, 100, 5),
	INFERNO_DRAGON(100, 100, 5),
	KING_TOWER_NPC(100, 100, 5),
	KNIGHT(100, 100, 5),
	LAVA_HOUND(100, 100, 5),
	LUMBERJACK(100, 100, 5),
	MEGA_MINION(100, 100, 5),
	MINER(100, 100, 5),
	MINI_PEKKA(100, 100, 5),
	MINION(100, 100, 5),
	MINIONS(100, 100, 5),
	MINION_HORDE(100, 100, 5),
	MUSKETEER(100, 100, 5),
	NIGHT_WITCH(100, 100, 5),
	PEKKA(100, 100, 5),
	PRINCE(100, 100, 5),
	PRINCESS(100, 100, 5),
	ROYALE_GIANT(100, 100, 5),
	SKELETON(100, 100, 5),
	SKELETON_ARMY(100, 100, 5),
	SKELETONS(100, 100, 5),
	SPARKY(100, 100, 5),
	SPEAR_GOBLIN(100, 100, 5),
	SPEAR_GOBLINS(100, 100, 5),
	THREE_MUSKETEERS(100, 100, 5),
	VALKYRIE(100, 100, 5),
	WITCH(100, 100, 5),
	WIZARD(100, 100, 5);
	
	private final double LEVEL_MULT = 0.1;
	
	private int baseHealth;
	private int baseDamage;
	private int range;
	
	public int getCalcHealth(int level) {
		return (int) (baseHealth * (LEVEL_MULT * (level - 1))) + baseHealth;
	}
	
	public int getCalcDamage(int level) {
		return (int) (baseDamage * (LEVEL_MULT * (level - 1))) + baseDamage;
	}
	
}
