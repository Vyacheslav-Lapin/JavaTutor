package com.luxoft.training.java2.module1;

import static org.junit.Assert.*;
import static com.luxoft.training.Logger.log;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class RegExpTutor1 {

	class Email {
		String name;
		String domainName;
		String domainZone;
	}
	
	public Email getEmail(String emailString) {
		Email email = new Email();
		Pattern pattern = 
				Pattern.compile(
						"^([A-Za-z\\.-0-9]{2,})@([A-Za-z\\.-0-9]{2,})\\.([A-Za-z]{2,3})$");
		Matcher matcher = pattern.matcher(emailString);
		matcher.find();
		email.name=matcher.group(1);
		email.domainName=matcher.group(2);
		email.domainZone=matcher.group(3);
		return email;
	}
	
	/**
	 * Возвращает список строк по текстовому представлению строк:
	 * принимает строку
	 * "Список животных: Корова, Гусь, Кошка, Собака, Слон, Заяц, Змея, Курица, Лошадь, Человек."
	 * и возвращает массив из отдельных животных
	 */
	public String[] getAnimalsArray(String animalsString) {
		Pattern pattern = 
				Pattern.compile(
						" ([А-Яа-я]{2,})[,\\.]");
		Matcher matcher = pattern.matcher(animalsString);
		String[] animals = new String[100];
		int i=0;
		while (matcher.find()) {
			String group = matcher.group(1);
			log(group);
			animals[i++] = group;
		}
		String[] animalsTruncated = new String[i];
		System.arraycopy(animals, 0, animalsTruncated, 0, i);
		return animalsTruncated;
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
