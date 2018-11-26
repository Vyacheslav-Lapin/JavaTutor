package com.luxoft.training.java2.module4;

import static com.luxoft.training.Logger.log;

import java.util.Arrays;
import java.util.Collection;
import java.util.Set;

import org.junit.Test;

/**
 *	1) Имплементируйте метод Set<Animal> getAnimalsOrderedByNameSet()
 * 		и метод Set<Animal> getAnimalsOrderedByNameSetDesc()
 */
public class ComparableTutor {
	String [] animals =
        {"Корова", "Гусь", "Кошка", "Собака", "Слон",
        "Заяц", "Змея", "Курица", "Лошадь", "Человек",
        "Корова", "Змея"};
	
	class Animal{
		String name;
		public Animal(String name) {
			this.name = name;
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
		return null;
	}
	
	/**
	 * Метод должен возвращать Set экземпляров класса Animal,
	 * упорядоченный по имени в обратном порядке.
	 * Для этого используйте TreeSet и передайте ему в качестве параметра 
	 * имплементацию класса Comparator.
	 * 
	 */
	public Set<Animal> getAnimalsOrderedByNameSetDesc() {
		return null;
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

