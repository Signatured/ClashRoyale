package me.signatured.clashroyale.card.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import me.signatured.clashroyale.card.CardList;
import me.signatured.clashroyale.game.arena.ClashArena;
import me.signatured.clashroyale.spawnable.ClashRarity;

/**
 * All spawnable classes need to be tagged with this annotation so
 * {@link CardList} can add the class to the list of cards
 * 
 * @author Conner Pait
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value = ElementType.TYPE)
public @interface GenerateCard {
	
	String key();
	String name();
	ClashRarity rarity() default ClashRarity.COMMON;
	ClashArena arena() default ClashArena.ARENA_1;
	int cost() default 1;
	boolean real() default true;
}
