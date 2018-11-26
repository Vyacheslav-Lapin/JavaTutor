package com.luxoft.training.java2.module4;

import static com.luxoft.training.Logger.log;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.junit.Test;

/**
 * 1) Имплементрируйте метод joinByCycle(). Проверьте результат.
 * 		Имплементируйте методы getAnimalsList(), getAnimalsSet(), getAnimalsOrderedSet()
 * 		и верните их значения.
 * 		Как отличаются полученные результаты? 
 * 		Имплементируйте метод joinByIterator()
 */
public class CollectionTutor {
	String [] animals =
        {"Корова", "Гусь", "Кошка", "Собака", "Слон",
        "Заяц", "Змея", "Курица", "Лошадь", "Человек",
        "Корова", "Змея"};
	
	/**
	 * Метод должен возвращать ArrayList со всеми животными
	 */
	public List<String> getAnimalsList() {
		return null;
	}
	
	/**
	 * Метод должен возвращать Set со всеми животными  
	 */
	public Set<String> getAnimalsSet() {
		return null;
	}
	
	/**
	 * Метод должен возвращать упорядоченный по алфавиту набор строк.
	 * Используйте для этого TreeSet. 
	 */
	public Set<String> getAnimalsOrderedSet() {
		return null;
	}

	class Animal {
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
	 * Метод должен возвращать Set экземпляров класса Animal.
	 * Для этого необходимо, что класс Animal имплементировал интерфейс Comparable 
	 */
	public Set<Animal> getAnimalsOrderedByNameSet() {
		return null;
	}
	
	/**
	 * Метод должен брать коллекцию строк c
	 * и возвращать одну строку, состоящую из 
	 * элементов коллекции, соединенных запятой,
	 * используя цикл for
	 */
	public String joinByCycle(Collection<?> c) {
		return null;
	}
	
	/**
	 * Метод должен брать коллекцию строк c
	 * и возвращать одну строку, состоящую из 
	 * элементов коллекции, соединенных запятой,
	 * используя итератор
	 */
	public String joinByIterator(Collection<?> c) {
		return null;
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

