package com.luxoft.training.java2.module9;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.junit.Test;

public class LoggerConfigTutor {
	static Logger logger = Logger.getLogger(LoggerConfigTutor.class.getName());
	
	// place -Djava.util.logging.config.file=logger.properties to VM arguments
	@Test
	public void logTest() {
		logger.severe("severe");
		logger.info("info");
		logger.fine("fine");
		logger.finest("finest");
	}
	
	public static void main(String[] args) {
		try {
			LogManager.getLogManager().readConfiguration(
					new FileInputStream("logger.properties"));
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		logger.severe("severe");
		logger.info("info");
		logger.finest("finest");		
	}
}
