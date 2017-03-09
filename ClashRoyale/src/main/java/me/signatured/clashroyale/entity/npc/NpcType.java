package me.signatured.clashroyale.entity.npc;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import lombok.AllArgsConstructor;
import lombok.Getter;
import me.signatured.clashroyale.ClashPlayer;
import me.signatured.clashroyale.entity.ClashSpawnable;
import me.signatured.clashroyale.entity.npc.impl.Archer;
import me.signatured.clashroyale.entity.npc.impl.BabyDragon;
import me.signatured.clashroyale.entity.npc.impl.Balloon;
import me.signatured.clashroyale.entity.npc.impl.Barbarian;
import me.signatured.clashroyale.entity.npc.impl.Bomber;
import me.signatured.clashroyale.entity.npc.impl.Bowler;
import me.signatured.clashroyale.entity.npc.impl.DarkPrince;
import me.signatured.clashroyale.entity.npc.impl.DartGoblin;
import me.signatured.clashroyale.entity.npc.impl.ElectroWizard;
import me.signatured.clashroyale.entity.npc.impl.EliteBarbarian;
import me.signatured.clashroyale.entity.npc.impl.Executioner;
import me.signatured.clashroyale.entity.npc.impl.FireSpirit;
import me.signatured.clashroyale.entity.npc.impl.Giant;
import me.signatured.clashroyale.entity.npc.impl.GiantSkeleton;
import me.signatured.clashroyale.entity.npc.impl.Goblin;
import me.signatured.clashroyale.entity.npc.impl.Golem;
import me.signatured.clashroyale.entity.npc.impl.Guard;
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
import me.signatured.clashroyale.entity.npc.impl.MiniGolem;
import me.signatured.clashroyale.entity.npc.impl.MiniPekka;
import me.signatured.clashroyale.entity.npc.impl.Minion;
import me.signatured.clashroyale.entity.npc.impl.Musketeer;
import me.signatured.clashroyale.entity.npc.impl.Pekka;
import me.signatured.clashroyale.entity.npc.impl.Prince;
import me.signatured.clashroyale.entity.npc.impl.Princess;
import me.signatured.clashroyale.entity.npc.impl.RoyaleGiant;
import me.signatured.clashroyale.entity.npc.impl.Skeleton;
import me.signatured.clashroyale.entity.npc.impl.Sparky;
import me.signatured.clashroyale.entity.npc.impl.SpearGoblin;
import me.signatured.clashroyale.entity.npc.impl.TowerArcher;
import me.signatured.clashroyale.entity.npc.impl.TowerKing;
import me.signatured.clashroyale.entity.npc.impl.Valkyrie;
import me.signatured.clashroyale.entity.npc.impl.Witch;
import me.signatured.clashroyale.entity.npc.impl.Wizard;
import me.signatured.clashroyale.entity.npc.impl.groups.Barbarians;
import me.signatured.clashroyale.entity.npc.impl.groups.EliteBarbarians;
import me.signatured.clashroyale.entity.npc.impl.groups.FireSpirits;
import me.signatured.clashroyale.entity.npc.impl.groups.Goblins;
import me.signatured.clashroyale.entity.npc.impl.groups.Guards;
import me.signatured.clashroyale.entity.npc.impl.groups.MiniGolems;
import me.signatured.clashroyale.entity.npc.impl.groups.MinionHorde;
import me.signatured.clashroyale.entity.npc.impl.groups.Minions;
import me.signatured.clashroyale.entity.npc.impl.groups.SkeletonArmy;
import me.signatured.clashroyale.entity.npc.impl.groups.Skeletons;
import me.signatured.clashroyale.entity.npc.impl.groups.SpearGoblins;
import me.signatured.clashroyale.entity.npc.impl.groups.ThreeMusketeers;
import me.signatured.clashroyale.game.ClashGame;

@Getter
@AllArgsConstructor
public enum NpcType {
	
	ARCHER("Archer", Archer.class, 125, 41, 5),
	ARENA_TOWER_NPC("Arena Tower Archer", TowerArcher.class, 100, 100, 5),
	BABY_DRAGON("Baby Dragon", BabyDragon.class, 100, 100, 5),
	BARBARIAN("Barbarian", Barbarian.class, 100, 100, 5),
	BARBARIANS("Barbarians", Barbarians.class, 100, 100, 5),
	BOMBER("Bomber", Bomber.class, 100, 100, 5),
	BOWLER("Bowler", Bowler.class, 100, 100, 5),
	BALLOON("Balloon", Balloon.class, 100, 100, 5),
	DARK_PRINCE("Dark Prince", DarkPrince.class, 100, 100, 5),
	DART_GOBLIN("Dart Goblin", DartGoblin.class, 100, 100, 5),
	ELECTRO_WIZARD("Electro Wizard", ElectroWizard.class, 100, 100, 5),
	ELITE_BARBARIAN("Elite Barbarian", EliteBarbarian.class, 100, 100, 5),
	ELITE_BARBARIANS("Elite Barbarians", EliteBarbarians.class, 100, 100, 5),
	EXECUTIONER("Executioner", Executioner.class, 100, 100, 5),
	FIRE_SPIRIT("Fire Spirit", FireSpirit.class, 100, 100, 5),
	FIRE_SPIRITS("Fire Spirits", FireSpirits.class, 100, 100, 5),
	GIANT("Giant", Giant.class, 100, 100, 5),
	GIANT_SKELETON("Giant Skeleton", GiantSkeleton.class, 100, 100, 5),
	GOBLIN("Goblin", Goblin.class, 100, 100, 5),
	GOBLINS("Goblins", Goblins.class, 100, 100, 5),
	GOLEM("Golem", Golem.class, 100, 100, 5),
	MINI_GOLEM("Mini Golem", MiniGolem.class, 100, 100, 5),
	MINI_GOLEMS("Mini Golems", MiniGolems.class, 100, 100, 5),
	GUARD("Guard", Guard.class, 100, 100, 5),
	GUARDS("Guards", Guards.class, 100, 100, 5),
	HOG_RIDER("Hog Rider", HogRider.class, 100, 100, 5),
	ICE_SPIRIT("Ice Spirit", IceSpirit.class, 100, 100, 5),
	ICE_WIZARD("Ice Wizard", IceWizard.class, 100, 100, 5),
	ICE_GOLEM("Ice Golem", IceGolem.class, 100, 100, 5),
	INFERNO_DRAGON("Inferno Dragon", InfernoDragon.class, 100, 100, 5),
	KING_TOWER_NPC("King Tower Cannoner", TowerKing.class, 100, 100, 5),
	KNIGHT("Knight", Knight.class, 100, 100, 5),
	LAVA_HOUND("Lava Hound", LavaHound.class, 100, 100, 5),
	LUMBERJACK("Lumberjack", Lumberjack.class, 100, 100, 5),
	MEGA_MINION("Mega Minion", MegaMinion.class, 100, 100, 5),
	MINER("Miner", Miner.class, 100, 100, 5),
	MINI_PEKKA("Mini P.E.K.K.A", MiniPekka.class, 100, 100, 5),
	MINION("Minion", Minion.class, 100, 100, 5),
	MINIONS("Minions", Minions.class, 100, 100, 5),
	MINION_HORDE("Minion Horde", MinionHorde.class, 100, 100, 5),
	MUSKETEER("Musketeer", Musketeer.class, 100, 100, 5),
	PEKKA("P.E.K.K.A", Pekka.class, 100, 100, 5),
	PRINCE("Prince", Prince.class, 100, 100, 5),
	PRINCESS("Princess", Princess.class, 100, 100, 5),
	ROYALE_GIANT("Royale Giant", RoyaleGiant.class, 100, 100, 5),
	SKELETON("Skeleton", Skeleton.class, 100, 100, 5),
	SKELETON_ARMY("Skeleton Army", SkeletonArmy.class, 100, 100, 5),
	SKELETONS("Skeletons", Skeletons.class, 100, 100, 5),
	SPARKY("Sparky", Sparky.class, 100, 100, 5),
	SPEAR_GOBLIN("Spear Goblin", SpearGoblin.class, 100, 100, 5),
	SPEAR_GOBLINS("Spear Goblins", SpearGoblins.class, 100, 100, 5),
	THREE_MUSKETEERS("Three Musketeers", ThreeMusketeers.class, 100, 100, 5),
	VALKYRIE("Valkyrie", Valkyrie.class, 100, 100, 5),
	WITCH("Witch", Witch.class, 100, 100, 5),
	WIZARD("Wizard", Wizard.class, 100, 100, 5);
	
	private String name;
	private Class<? extends ClashSpawnable> spawnableClass;
	private int baseHealth;
	private int baseDamage;
	private int range;
	
	public ClashSpawnable create(ClashGame game, ClashPlayer player, int level) {
		try {
			Constructor<? extends ClashSpawnable> constructor = spawnableClass.getConstructor(ClashGame.class, ClashPlayer.class, Integer.class);
			return constructor.newInstance(game, player, level);
		} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}

		return null;
	}
}
