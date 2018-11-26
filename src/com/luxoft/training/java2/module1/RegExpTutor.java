package com.luxoft.training.java2.module1;

import static org.junit.Assert.*;
import static com.luxoft.training.Logger.log;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class RegExpTutor {

	class Email {
		String name;
		String domainName;
		String domainZone;
	}
	
	public Email getEmail(String emailString) {
		return null;
	}
	
	/**
	 * Возвращает список строк по текстовому представлению строк:
	 * принимает строку
	 * "Список животных: Корова, Гусь, Кошка, Собака, Слон, Заяц, Змея, Курица, Лошадь, Человек."
	 * и возвращает массив из отдельных животных
	 */
	public String[] getAnimalsArray(String animalsString) {
		return null;
	}
	
	@Test
	public void testGetEmail() {
		Email email = getEmail("ivanov@mail.ru");
		assertEquals("ivanov", email.name);
		assertEquals("mail", email.domainName);
		assertEquals("ru", email.domainZone);
		
	}
	
	@Test
	public void testGetAnimalsArray() {
		String [] animals =
	        {"Корова", "Гусь", "Кошка", "Собака", "Слон",
	        "Заяц", "Змея", "Курица", "Лошадь", "Человек"};
		String animalsString = "Список животных: Корова, Гусь, Кошка, Собака, Слон, "+
				"Заяц, Змея, Курица, Лошадь, Человек.";
		assertArrayEquals(animals, getAnimalsArray(animalsString));
	}

}
