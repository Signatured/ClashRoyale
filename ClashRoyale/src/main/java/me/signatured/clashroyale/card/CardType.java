package me.signatured.clashroyale.card;

import lombok.AllArgsConstructor;
import lombok.Getter;
import me.signatured.clashroyale.entity.ClashRarity;
import me.signatured.clashroyale.entity.ClashSpawnable;
import me.signatured.clashroyale.entity.npc.impl.Archer;
import me.signatured.clashroyale.entity.npc.impl.BabyDragon;
import me.signatured.clashroyale.entity.npc.impl.Balloon;
import me.signatured.clashroyale.entity.npc.impl.Bomber;
import me.signatured.clashroyale.entity.npc.impl.Bowler;
import me.signatured.clashroyale.entity.npc.impl.DarkPrince;
import me.signatured.clashroyale.entity.npc.impl.DartGoblin;
import me.signatured.clashroyale.entity.npc.impl.ElectroWizard;
import me.signatured.clashroyale.entity.npc.impl.Giant;
import me.signatured.clashroyale.entity.npc.impl.GiantSkeleton;
import me.signatured.clashroyale.entity.npc.impl.Golem;
import me.signatured.clashroyale.entity.npc.impl.HogRider;
import me.signatured.clashroyale.entity.npc.impl.IceGolem;
import me.signatured.clashroyale.entity.npc.impl.IceSpirit;
import me.signatured.clashroyale.entity.npc.impl.IceWizard;
import me.signatured.clashroyale.entity.npc.impl.InfernoDragon;
import me.signatured.clashroyale.entity.npc.impl.Knight;
import me.signatured.clashroyale.entity.npc.impl.LavaHound;
import me.signatured.clashroyale.entity.npc.impl.Lumberjack;
import me.signatured.clashroyale.entity.npc.impl.MegaMinion;
import me.signatured.clashroyale.entity.npc.impl.Miner;
import me.signatured.clashroyale.entity.npc.impl.MiniPekka;
import me.signatured.clashroyale.entity.npc.impl.Musketeer;
import me.signatured.clashroyale.entity.npc.impl.Pekka;
import me.signatured.clashroyale.entity.npc.impl.Prince;
import me.signatured.clashroyale.entity.npc.impl.Princess;
import me.signatured.clashroyale.entity.npc.impl.RoyaleGiant;
import me.signatured.clashroyale.entity.npc.impl.Sparky;
import me.signatured.clashroyale.entity.npc.impl.SpearGoblin;
import me.signatured.clashroyale.entity.npc.impl.Valkyrie;
import me.signatured.clashroyale.entity.npc.impl.Witch;
import me.signatured.clashroyale.entity.npc.impl.Wizard;
import me.signatured.clashroyale.entity.npc.impl.groups.Barbarians;
import me.signatured.clashroyale.entity.npc.impl.groups.EliteBarbarians;
import me.signatured.clashroyale.entity.npc.impl.groups.FireSpirits;
import me.signatured.clashroyale.entity.npc.impl.groups.Goblins;
import me.signatured.clashroyale.entity.npc.impl.groups.Guards;
import me.signatured.clashroyale.entity.npc.impl.groups.MinionHorde;
import me.signatured.clashroyale.entity.npc.impl.groups.Minions;
import me.signatured.clashroyale.entity.npc.impl.groups.SkeletonArmy;
import me.signatured.clashroyale.entity.npc.impl.groups.Skeletons;
import me.signatured.clashroyale.entity.npc.impl.groups.ThreeMusketeers;
import me.signatured.clashroyale.entity.structure.impl.BarbarianHut;
import me.signatured.clashroyale.entity.structure.impl.BomberTower;
import me.signatured.clashroyale.entity.structure.impl.Cannon;
import me.signatured.clashroyale.entity.structure.impl.ElixirCollector;
import me.signatured.clashroyale.entity.structure.impl.Furnace;
import me.signatured.clashroyale.entity.structure.impl.GoblinHut;
import me.signatured.clashroyale.entity.structure.impl.InfernoTower;
import me.signatured.clashroyale.entity.structure.impl.Mortar;
import me.signatured.clashroyale.entity.structure.impl.Tesla;
import me.signatured.clashroyale.entity.structure.impl.Tombstone;
import me.signatured.clashroyale.entity.structure.impl.XBow;
import me.signatured.clashroyale.spell.impl.ArrowsSpell;
import me.signatured.clashroyale.spell.impl.CloneSpell;
import me.signatured.clashroyale.spell.impl.FireballSpell;
import me.signatured.clashroyale.spell.impl.FreezeSpell;
import me.signatured.clashroyale.spell.impl.GoblinBarrelSpell;
import me.signatured.clashroyale.spell.impl.GraveyardSpell;
import me.signatured.clashroyale.spell.impl.LightningSpell;
import me.signatured.clashroyale.spell.impl.PoisonSpell;
import me.signatured.clashroyale.spell.impl.RageSpell;
import me.signatured.clashroyale.spell.impl.RocketSpell;
import me.signatured.clashroyale.spell.impl.TheLogSpell;
import me.signatured.clashroyale.spell.impl.TornadoSpell;
import me.signatured.clashroyale.spell.impl.ZapSpell;

@Getter
@AllArgsConstructor
public enum CardType {
	
	ARCHER("Archer", Archer.class, ClashRarity.COMMON, 3),
	ARROWS("Arrows", ArrowsSpell.class, ClashRarity.COMMON, 3),
	BABY_DRAGON("Baby Dragon", BabyDragon.class, ClashRarity.EPIC, 4),
	BALLOON("Balloon", Balloon.class, ClashRarity.EPIC, 5),
	BARBARIAN_HUT("Barbarian Hut", BarbarianHut.class, ClashRarity.RARE, 7),
	BARBARIANS("Barbarians", Barbarians.class, ClashRarity.COMMON, 5),
	BOMBER("Bomber", Bomber.class, ClashRarity.COMMON, 3),
	BOMBER_TOWER("Bomber Tower", BomberTower.class, ClashRarity.RARE, 5),
	BOWLER("Bowler", Bowler.class, ClashRarity.EPIC, 5),
	CANNON("Cannon", Cannon.class, ClashRarity.COMMON, 3),
	CLONE_SPELL("Clone Spell", CloneSpell.class, ClashRarity.EPIC, 3),
	DARK_PRINCE("Dark Prince", DarkPrince.class, ClashRarity.EPIC, 4),
	DART_GOBLIN("Dart Goblin", DartGoblin.class, ClashRarity.RARE, 3),
	ELECTRO_WIZARD("Electro Wizard", ElectroWizard.class, ClashRarity.LEGENDARY, 4),
	ELITE_BARBARIANS("Elite Barbarians", EliteBarbarians.class, ClashRarity.COMMON, 6),
	ELIXIR_COLLECTOR("Elixir Collector", ElixirCollector.class, ClashRarity.RARE, 5),
	FIRE_SPIRITS("Fire Spirits", FireSpirits.class, ClashRarity.COMMON, 2),
	FIREBALL("Fireball", FireballSpell.class, ClashRarity.RARE, 4),
	FREEZE("Freeze", FreezeSpell.class, ClashRarity.EPIC, 4),
	FURNACE("Furnace", Furnace.class, ClashRarity.RARE, 4),
	GIANT("Giant", Giant.class, ClashRarity.RARE, 5),
	GIANT_SKELETON("Giant Skeleton", GiantSkeleton.class, ClashRarity.EPIC, 6),
	GOBLIN_BARREL("Goblin Barrel", GoblinBarrelSpell.class, ClashRarity.EPIC, 3),
	GOBLIN_HUT("Goblin Hut", GoblinHut.class, ClashRarity.RARE, 5),
	GOBLINS("Goblins", Goblins.class, ClashRarity.COMMON, 2),
	GOLEM("Golem", Golem.class, ClashRarity.EPIC, 8),
	GRAVEYARD("Graveyard", GraveyardSpell.class, ClashRarity.LEGENDARY, 5),
	GUARDS("Guards", Guards.class, ClashRarity.EPIC, 3),
	HOG_RIDER("Hog Rider", HogRider.class, ClashRarity.RARE, 4),
	ICE_SPIRIT("Ice Spirit", IceSpirit.class, ClashRarity.COMMON, 1),
	ICE_WIZARD("Ice Wizard", IceWizard.class, ClashRarity.LEGENDARY, 3),
	ICE_GOLEM("Ice Golem", IceGolem.class, ClashRarity.RARE, 2),
	INFERNO_DRAGON("Inferno Dragon", InfernoDragon.class, ClashRarity.LEGENDARY, 4),
	INFERNO_TOWER("Inferno Tower", InfernoTower.class, ClashRarity.RARE, 5),
	KNIGHT("Knight", Knight.class, ClashRarity.COMMON, 3),
	LAVA_HOUND("Lava Hound", LavaHound.class, ClashRarity.LEGENDARY, 7),
	LIGHTNING("Ligntning", LightningSpell.class, ClashRarity.EPIC, 6),
	LUMBERJACK("Lumberjack", Lumberjack.class, ClashRarity.LEGENDARY, 4),
	MEGA_MINION("Mega Minion", MegaMinion.class, ClashRarity.RARE, 3),
	MINER("Miner", Miner.class, ClashRarity.LEGENDARY, 3),
	MINI_PEKKA("Mini P.E.K.K.A.", MiniPekka.class, ClashRarity.RARE, 4),
	MINION_HORDE("Minion Horde", MinionHorde.class, ClashRarity.COMMON, 5),
	MINIONS("Minions", Minions.class, ClashRarity.COMMON, 3),
	MORTAR("Mortar", Mortar.class, ClashRarity.COMMON, 4),
	MUSKETEER("Musketeer", Musketeer.class, ClashRarity.RARE, 4),
	PEKKA("P.E.K.K.A", Pekka.class, ClashRarity.EPIC, 7),
	POISON_SPELL("Poison Spell", PoisonSpell.class, ClashRarity.EPIC, 4),
	PRINCE("Prince", Prince.class, ClashRarity.EPIC, 5),
	PRINCESS("Princess", Princess.class, ClashRarity.LEGENDARY, 3),
	RAGE("Rage", RageSpell.class, ClashRarity.EPIC, 2),
	ROCKET("Rocket", RocketSpell.class, ClashRarity.RARE, 6),
	ROYALE_GIANT("Royale Giant", RoyaleGiant.class, ClashRarity.COMMON, 6),
	SKELETON_ARMY("Skeleton Army", SkeletonArmy.class, ClashRarity.EPIC, 3),
	SKELETONS("Skeletons", Skeletons.class, ClashRarity.COMMON, 1),
	SPARKY("Sparky", Sparky.class, ClashRarity.LEGENDARY, 6),
	SPEAR_GOBLIN("Spear Goblin", SpearGoblin.class, ClashRarity.COMMON, 2),
	TESLA("Tesla", Tesla.class, ClashRarity.COMMON, 4),
	THE_LOG("The Log", TheLogSpell.class, ClashRarity.LEGENDARY, 2),
	THREE_MUSKETEERS("Three Musketeers", ThreeMusketeers.class, ClashRarity.RARE, 9),
	TOMBSTONE("Tombstone", Tombstone.class, ClashRarity.RARE, 3),
	TORNADO("Tornado", TornadoSpell.class, ClashRarity.EPIC, 3),
	VALKYRIE("Valkyrie", Valkyrie.class, ClashRarity.RARE, 4),
	WITCH("Witch", Witch.class, ClashRarity.EPIC, 5),
	WIZARD("Wizard", Wizard.class, ClashRarity.RARE, 5),
	X_BOW("X-Bow", XBow.class, ClashRarity.EPIC, 6),
	ZAP("Zap", ZapSpell.class, ClashRarity.COMMON, 2);
	
	private String cardName;
	private Class<? extends ClashSpawnable> spawnableClass;
	private ClashRarity rarity;
	private int elixirCost;
	
	public ClashCard createCard(int level, int number) {
		return new ClashCard(this, level, number);
	}
}
