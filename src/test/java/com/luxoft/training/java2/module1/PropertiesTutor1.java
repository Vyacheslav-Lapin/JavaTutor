package com.luxoft.training.java2.module1;

import static org.junit.Assert.*;
import static com.luxoft.training.Logger.log;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.junit.Test;

public class PropertiesTutor1 {

	/**
	 * Возвращает значение системного свойства java.version
	 */
	public String getJavaVersion() {
		return System.getProperty("java.version");
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
		Properties props = new Properties();
		String executionPath = System.getProperty("user.dir");
		try {
			InputStream is = new FileInputStream(executionPath+File.separator+
					"files"+File.separator+"props.properties");
			props.load(is);
		} catch (IOException e) {
			log(e);
		}		
		return props;
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
