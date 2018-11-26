package com.luxoft.training.java2.module4;

import static com.luxoft.training.Logger.log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

/**
 * 1) Имплементируйте методы и верните их значения.
 * 		Как отличаются полученные результаты? 
 *
 */
public class CollectionTutor1 {
	String [] animals =
        {"Корова", "Гусь", "Кошка", "Собака", "Слон",
        "Заяц", "Змея", "Курица", "Лошадь", "Человек",
        "Корова", "Змея"};
	
	/**
	 * Метод должен возвращать ArrayList со всеми животными
	 */
	public List<String> getAnimalsList() {
		ArrayList<String> animalsList = new ArrayList<String>();
		for (String s:animals) {
			animalsList.add(s);
		}
		return animalsList;
	}
	
	/**
	 * Метод должен возвращать Set со всеми животными  
	 */
	public Set<String> getAnimalsSet() {
		Set<String> animalsList = new HashSet<String>();
		for (String s:animals) {
			animalsList.add(s);
		}
		return animalsList;
	}
	
	/**
	 * Метод должен возвращать упорядоченный по алфавиту набор строк.
	 * Используйте для этого TreeSet. 
	 */
	public Set<String> getAnimalsOrderedSet() {
		Set<String> animalsList = new TreeSet<String>();
		for (String s:animals) {
			animalsList.add(s);
		}
		return animalsList;
	}
	
	/**
	 * Метод должен брать коллекцию строк c
	 * и возвращать одну строку, состоящую из элементов коллекции, соединенных запятой
	 */
	public String joinByCycle(Collection<?> c) {
		StringBuilder builder = new StringBuilder();
		for (Object s: c) {
			builder.append(s);
			if (builder.length()>0) builder.append(", ");
		}
		return builder.toString();
	}
	
	/**
	 * Метод должен брать коллекцию строк c
	 * и возвращать одну строку, состоящую из 
	 * элементов коллекции, соединенных запятой,
	 * используя цикл for
	 */
	public String getCollectionString(Collection<?> c) {
		Iterator<?> iterator = c.iterator();
		StringBuilder builder = new StringBuilder();
		while (iterator.hasNext()) {
			Object s = iterator.next();
			if (builder.length()>0) builder.append(", ");
			builder.append(s);
		}
		return builder.toString();
	}
	
	/**
	 * Метод должен брать коллекцию строк c
	 * и возвращать одну строку, состоящую из 
	 * элементов коллекции, соединенных запятой,
	 * используя итератор
	 */
	public String joinByIterator(Collection<?> c) {
		Iterator<?> iterator = c.iterator();
		StringBuilder builder = new StringBuilder();
		while (iterator.hasNext()) {
			Object s = iterator.next();
			if (builder.length()>0) builder.append(", ");
			builder.append(s);
		}
		return builder.toString();
	}
	
	
	@Test
	public void testCollections() {
		log("getAnimalsList: "+joinByCycle(Arrays.asList(animals)));
		
		log("getAnimalsList: "+joinByCycle(getAnimalsList()));
		log("getAnimalsSet: "+joinByCycle(getAnimalsSet()));
		log("getAnimalsOrderedSet: "+joinByCycle(getAnimalsOrderedSet()));

		log("getAnimalsList by iterator: "+joinByIterator(getAnimalsList()));
	}
	
}

