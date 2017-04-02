package me.signatured.clashroyale.card;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.reflections.Reflections;

import lombok.Getter;
import me.signatured.clashroyale.ClashRoyale;
import me.signatured.clashroyale.arena.ArenaType;
import me.signatured.clashroyale.card.annotation.GenerateCard;
import me.signatured.clashroyale.spawnable.ClashRarity;
import me.signatured.clashroyale.spawnable.ClashSpawnable;
import me.signatured.clashroyale.spawnable.npc.SkinData;

public class CardList {
	
	@Getter
	private static CardList instance;
	
	private List<ClashCard> cards = new ArrayList<>();
	private List<Class<? extends ClashSpawnable>> cardClazzes = new ArrayList<>();
	
	public CardList() {
		instance = this;
		load();
	}
	
	public List<ClashCard> list() {
		return cards;
	}
	
	public ClashCard find(String key) {
		return cards.stream().filter(c -> c.getKey().equals(key)).findAny().orElse(null);
	}
	
	public ClashCard find(Class<? extends ClashSpawnable> clazz) {
		return cards.stream().filter(c -> c.getSpawnClass().equals(clazz)).findAny().orElse(null);
	}
	
	public List<ClashCard> find(ClashRarity rarity) {
		return cards.stream().filter(c -> c.getRarity() == rarity && c.isReal()).collect(Collectors.toList());
	}
	
	public List<ClashCard> find(ArenaType arena) {
		return cards.stream().filter(c -> c.getArena() == arena && c.isReal()).collect(Collectors.toList());
	}
	
	@SuppressWarnings("unchecked")
	public void load() {
		System.out.println("Generating cards...");
		
		cardClazzes.clear();
		cards.clear();
		
		Reflections reflections = new Reflections("me.signatured.clashroyale.spawnable");
		Set<Class<?>> annotated = reflections.getTypesAnnotatedWith(GenerateCard.class);
		
		annotated.forEach(a -> cardClazzes.add((Class<? extends ClashSpawnable>) a));
		
		for (Class<? extends ClashSpawnable> clazz : cardClazzes) {
			GenerateCard gc = clazz.getAnnotation(GenerateCard.class);
			
			String key = gc.key();
			String name = gc.name();
			ClashRarity rarity = gc.rarity();
			ArenaType arena = gc.arena();
			int cost = gc.cost();
			boolean real = gc.real();
			
			add(new ClashCard(key, name, clazz, rarity, arena, cost, real));
			createSkin(key);
		}
		
		clean();
	}
	
	public void add(ClashCard card) {
		if (find(card.getKey()) != null) {
			System.err.println("[CardList] Ignoring card " + card.getName() + ", duplicate key: " + card.getKey());
			return;
		}
		
		cards.add(card);
		clean();
	}
	
	public Iterator<ClashCard> iterator() {
		return cards.iterator();
	}
	
	public void createSkin(String key) {
		if (!skinsDir().exists())
			skinsDir().mkdir();
		
		FileConfiguration skinConfig = null;
		File skinFile = null;
		
		skinFile = new File(skinsDir(), key + ".yml");
		skinConfig = YamlConfiguration.loadConfiguration(skinFile);
		
		new SkinData(key, skinConfig.getString("uuid"), skinConfig.getString("name"), skinConfig.getString("texture1"), skinConfig.getString("texture2"));
	}
	
	private void clean() {
		Iterator<ClashCard> it = iterator();
		
		while (it.hasNext()) {
			ClashCard next = it.next();
			
			if (next == null) {
				it.remove();
				continue;
			}
			
			if (hasProblem(next)) {
				System.err.println("[CardList] Problem encountered for " + next.getSpawnClass());
				it.remove();
			}
		}
	}
	
	private boolean hasProblem(ClashCard card) {
		return card.getKey() == null || card.getName() == null;
	}
	
	private File skinsDir() {
		return new File(ClashRoyale.getInstance().getDataFolder().getAbsolutePath() + File.separator + "Skins");
	}
}
