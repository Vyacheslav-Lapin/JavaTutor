package com.luxoft.training.java2.module4;

import static com.luxoft.training.Logger.log;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import org.junit.Test;

/**
 * 1) Реализуйте методы fillAnimalsLengthMap() и printMap().
 * 		Изучите результаты работы программы.
 * 2) Реализуйте методы fillLengthAnimalsMap() и printMapOfSets()
 * 		Изучите результаты работы программы.
 */
public class MapTutor {
	Map<String,Integer> animalsLengthMap = new HashMap<String, Integer>();
	
	Map<Integer,Set<String>> lengthAnimalsMap = new HashMap<Integer,Set<String>>();
	
	String [] animals =
        {"Корова", "Гусь", "Кошка", "Собака", "Слон",
			"Человек", "Заяц", "Змея", "Курица", "Лошадь", 
        "Корова", "Змея"};

	/**
	 * заполняет таблицу animalsLengthMap значениями
	 * animal => animal.length()
	 * например
	 * "Корова" => 6
	 * "Змея" => 4
	 */
	public void fillAnimalsLengthMap() {
	}
	
	/**
	 * Выводит на печать содержимое animalsLengthMap,
	 * перечисляя ключ и значение
	 */
	public void printMap(Map<?,?> map) {
	}
	
	/**
	 * Заполняет таблицу lengthAnimalsMap значениями 
	 * длина названия животного => список животных с такой длиной названия
	 * например
	 * 4 => Змея, Слон, Гусь
	 * 5 => Кошка
	 * 6 => Лошадь, Собака, Корова
	 */
	public void fillLengthAnimalsMap() {
	}
	
	/**
	 * печатает содержимое таблицы lengthAnimalsMap,
	 * выводя ключ и список значений
	 */
	public void printMapOfSets(Map<Integer,Set<String>> map) {
	}
	
	@Test
	public void testMap() {
		fillAnimalsLengthMap();
		log("== printMap animalsLengthMap");
		printMap(animalsLengthMap);
		
		log("== printMap treemap animalsLengthMap");
		SortedMap<String, Integer> sortedMap = new TreeMap<String,Integer>(animalsLengthMap);
		printMap(sortedMap);
		
		log("== print lengthAnimalsMap");
		fillLengthAnimalsMap();
		printMapOfSets(lengthAnimalsMap);
		
		SortedMap<Integer,Set<String>> sortedMap2 = new TreeMap<Integer,Set<String>>(lengthAnimalsMap);

		log("== sortedMap headSet where key<6");
		printMapOfSets(sortedMap2.headMap(6));
		
		log("== sortedMap subMap 5..7");
		printMapOfSets(sortedMap2.subMap(5,7));
		
	}
}
