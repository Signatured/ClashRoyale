package me.signatured.clashroyale.entity.structure;

import lombok.AllArgsConstructor;
import lombok.Getter;
import me.signatured.clashroyale.entity.ClashRarity;

@Getter
@AllArgsConstructor
public enum StructureType {
	
	ARENA_TOWER("Arena Tower", ClashRarity.COMMON, -1),
	BARBARIAN_HUT("Barbarian Hut", ClashRarity.RARE, 60),
	BOMBER_TOWER("Bomber Tower", ClashRarity.RARE, 40),
	CANNON("Cannon", ClashRarity.COMMON, 30),
	ELIXER_COLLECTOR("Elixer Collector", ClashRarity.RARE, 70),
	FURNACE("Furnace", ClashRarity.RARE, 50),
	GOBLIN_HUT("Goblin Hut", ClashRarity.RARE, 60),
	INFERNO_TOWER("Inferno Tower", ClashRarity.RARE, 40),
	KING_TOWER("King Tower", ClashRarity.RARE, -1),
	MORTAR("Mortar", ClashRarity.RARE, 40),
	TOMBSTONE("Tombstone", ClashRarity.RARE, 40),
	TESLA("Tesla", ClashRarity.RARE, 40),
	X_BOW("X-Bow", ClashRarity.RARE, 40);
	
	private String name;
	private ClashRarity rarity;
	private int lifeTime;
}
