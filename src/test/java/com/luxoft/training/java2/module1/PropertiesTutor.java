package com.luxoft.training.java2.module1;

import static org.junit.Assert.*;
import static com.luxoft.training.Logger.log;

import java.util.Properties;

import org.junit.Test;

public class PropertiesTutor {

	/**
	 * Возвращает значение системного свойства java.version
	 */
	public String getJavaVersion() {
		return null;
	}
	
	@Test
	public void testJavaVersion() {
		String version = getJavaVersion();
		log(getJavaVersion());
		assertTrue(version.startsWith("1."));
	}

	/**
	 * Загружает properties-файл из папки files/props.properties 
	 * и возвращает загруженные properties  
	 * @return
	 */
	public Properties getProperties() {
		return new Properties();
	}
	
	@Test
	public void testGetProperties() {
		Properties props = getProperties();
		log("country="+props.getProperty("country"));
		log("color="+props.getProperty("color"));
		assertEquals("Australia", props.getProperty("country"));
		assertEquals("red", props.getProperty("color"));
	}
	
}
