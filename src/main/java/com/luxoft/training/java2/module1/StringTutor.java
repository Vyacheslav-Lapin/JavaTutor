package com.luxoft.training.java2.module1;

import static org.junit.Assert.*;
import static com.luxoft.training.Logger.log;

import org.junit.Test;

public class StringTutor  {

	/**
	 * Замените все null в assertEquals на true или false
	 */
	@Test
	public void testStringEquals() {
		String s1 = "aaa";
		String s2 = "aaa";
		String s3 = new String("aaa");
		log("адрес объекта s1: "+System.identityHashCode(s1));
		log("адрес объекта s2: "+System.identityHashCode(s2));
		assertEquals(s1==s2, null);
		assertEquals(s1.equals(s2), null);
		log("адрес объекта s3: "+System.identityHashCode(s3));
		assertEquals(s1==s3, null);
		// метод intern() позволяет получить строку из пула строк 
		String s4 = s3.intern();
		log("адрес объекта s4: "+System.identityHashCode(s4));
		assertEquals(s1==s4, null);
		// тестируем пересоздание объекта каждый раз при изменении
		s3 = s3+"bbb";
		log("адрес измененного объекта s3: "+System.identityHashCode(s3));
		s3 = s3.substring(0, 3); // s3 снова "aaa"
		assertEquals(s3==s1, null);
		assertEquals(s3.equals(s1), null);
		assertEquals(s3.intern()==s1, null);
	}
	
	/**
	 *  Убедитесь, что приветствие greeting имеет вид
	 *  Привет, Иван Иванов!
	 *  или
	 *  Привет,Петр Первый!
	 *  т.е. начинается на Привет, заканчивается на !
	 *  и содержит 2 слова для имени и фамилии,
	 *  причем имя и фамилия не короче 3 букв
	 *  и начинаются с большой буквы
	 */
	public boolean checkGreeting(String greeting) {
		return true;
	}
	
	@Test
	public void testCheckGreeting() {
		assertTrue(checkGreeting("Привет, Иван Иванов!"));
		assertTrue(checkGreeting("Привет,Петр Первый!"));
		assertTrue(checkGreeting("Привет, Петр Первый!"));
		assertTrue(checkGreeting("Привет, Петр Первый !"));
		
		assertFalse("В начале должно быть слово Привет и запятая",
				checkGreeting("Здравствуйте, Петр Первый!"));
		assertFalse("В конце должен быть восклицательный знак",
				checkGreeting("Привет, Петр Первый"));
		assertFalse("Имя слишком короткое",
				checkGreeting("Привет, Ли Сунь!"));
		assertFalse("Фамилия слишком короткая",
				checkGreeting("Привет, Куй Ли!"));
		assertFalse("Должны быть указаны и имя, и фамилия",
				checkGreeting("Привет, Петр!"));
		assertFalse("Первая буква имени должна быть заглавной", 
				checkGreeting("Привет, петр Первый!"));
		assertFalse("Первая буква фамилии должна быть заглавной",
				checkGreeting("Привет, Петр первый!"));
	}
}