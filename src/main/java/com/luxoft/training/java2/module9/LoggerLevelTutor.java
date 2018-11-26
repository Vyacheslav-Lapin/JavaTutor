package com.luxoft.training.java2.module9;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Filter;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.junit.Test;

public class LoggerLevelTutor {


	@Test
	public void logLevels() {
		Logger logger = Logger.getLogger(LoggerLevelTutor.class.getName());
		logger.setLevel(Level.ALL);
		try {
			logger.addHandler(new FileHandler("files/log.xml"));
			FileHandler fileHandler = new FileHandler("files/log.log");
			logger.addHandler(fileHandler);
			fileHandler.setFormatter(new SimpleFormatter());
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		logger.setFilter(new Filter() {
			public boolean isLoggable(LogRecord rec) {
				if (rec.getMessage().contains("filter")) {
					return false;
				}
				return true;
			}
		});
		logger.severe("Major disaster");
		logger.warning("Potential problem");
		logger.info("Standard output");
		logger.config("Some config notes");
		logger.fine("Fine detail");
		logger.finer("Finer detail");
		logger.finest("Finest detail");
	  }

}
