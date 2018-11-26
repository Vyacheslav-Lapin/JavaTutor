package com.luxoft.training.java2.module4;

import static com.luxoft.training.Logger.log;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

/**
 *	1) Имплементируйте метод Set<Animal> getAnimalsOrderedByNameSet()
 * 		и метод Set<Animal> getAnimalsOrderedByNameSetDesc()
 */
public class ComparableTutor1 {
	String [] animals =
        {"Корова", "Гусь", "Кошка", "Собака", "Слон",
        "Заяц", "Змея", "Курица", "Лошадь", "Человек",
        "Корова", "Змея"};
	
	class Animal implements Comparable<Animal> {
		String name;
		public Animal(String name) {
			this.name = name;
		}
		@Override
		public int compareTo(Animal a) {
			return name.compareTo(a.name);
		}
		@Override
		public String toString() {
			return name;
		}
	}
	
	/**
	 * Метод должен возвращать Set экземпляров класса Animal,
	 * упорядоченный по имени.
	 * Для этого используйте TreeSet и имплементируйте в классе Animal 
	 * интерфейс Comparable. 
	 */
	public Set<Animal> getAnimalsOrderedByNameSet() {
		Set<Animal> animalsList = new TreeSet<Animal>();
		for (String s:animals) {
			animalsList.add(new Animal(s));
		}
		return animalsList;
	}
	
	/**
	 * Метод должен возвращать Set экземпляров класса Animal,
	 * упорядоченный по имени в обратном порядке.
	 * Для этого используйте TreeSet и передайте ему в качестве параметра 
	 * имплементацию класса Comparator.
	 * 
	 */
	public Set<Animal> getAnimalsOrderedByNameSetDesc() {
		Set<Animal> animalsList = new TreeSet<Animal>(new Comparator<Animal>() {
			@Override
			public int compare(Animal o1, Animal o2) {
				return -o1.name.compareTo(o2.name);
			}
		});
		for (String s:animals) {
			animalsList.add(new Animal(s));
		}
		return animalsList;
	}

	public String joinByCycle(Collection<?> c) {
		if (c==null) return "";
		StringBuilder builder = new StringBuilder();
		for (Object s: c) {
			builder.append(s);
			if (builder.length()>0) builder.append(", ");
		}
		return builder.toString();
	}
	
	@Test
	public void testCollections() {
		log("getAnimalsList: "+joinByCycle(Arrays.asList(animals)));
		
		log("getAnimalsOrderedByNameSet: "+joinByCycle(getAnimalsOrderedByNameSet()));
		log("getAnimalsOrderedByNameSetDesc: "+joinByCycle(getAnimalsOrderedByNameSetDesc()));
	}
	
}

