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
public class CollectionRemoveTutor2 {
	String [] animals =
        {"Корова", "Гусь", "Кошка", "Собака", "Слон",
        "Заяц", "Змея", "Курица", "Лошадь", "Человек",
        "Корова", "Змея"};
	
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
	
	public List<String> getAnimals() {
		return new ArrayList<String>(Arrays.asList(animals));
	}
	
	@Test
	public void testRemove() {
		List<String> list;
		
		// удалите все вхождения "Корова": неправильная имплементация
		list = getAnimals();
		list.remove(new String("Корова"));
		log("list after remove: "+joinByCycle(list));

		// удалите все вхождения "Корова": правильная имплементация
		list = getAnimals();
		while(list.remove(new String("Корова")));
		log("list after remove: "+joinByCycle(list));
		
		// удалите все вхождения, в которых 4 буквы: неправильная имплементация
		try {
			list = getAnimals();
			for (String s: list) {
				if (s.length()==4) list.remove(s);
			}
			log("list after remove 4 letters animals: "+joinByCycle(list));
		} catch(ConcurrentModificationException e) {
			e.printStackTrace();
		}

		// удалите все вхождения, в которых 4 буквы: правильная имплементация
		list = getAnimals();
		Iterator<String> iterator = list.iterator();
		while (iterator.hasNext()) {
			String a = iterator.next();
			if (a.length()==4) iterator.remove();
		}
		log("list after remove 4 letters animals: "+joinByCycle(list));

	}
	
}

