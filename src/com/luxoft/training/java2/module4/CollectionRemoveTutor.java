package com.luxoft.training.java2.module4;

import static com.luxoft.training.Logger.log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.Test;

/**
 * 1) Удалите все вхождения слова "Корова" и выведите результат
 * 2) Удалите все вхождения, в которых 4 буквы и выведите результат
 */
public class CollectionRemoveTutor {
	String [] animals =
        {"Корова", "Гусь", "Кошка", "Собака", "Слон",
        "Заяц", "Змея", "Курица", "Лошадь", "Человек",
        "Корова", "Змея"};
	
	public String joinByCycle(Collection<?> c) {
		StringBuilder builder = new StringBuilder();
		for (Object s: c) {
			builder.append(s);
			if (builder.length()>0) builder.append(", ");
		}
		return builder.toString();
	}
	
	public List<String> getAnimals() {
		return new ArrayList<String>(Arrays.asList(animals));
	}
	
	@Test
	public void testRemove() {
		List<String> list;
		
		list = getAnimals();
		// удалите все вхождения "Корова"
		log("list after remove: "+joinByCycle(list));

		list = getAnimals();
		// удалите все вхождения, в которых 4 буквы
		log("list after remove 4 letters animals: "+joinByCycle(list));
	}
	
}

