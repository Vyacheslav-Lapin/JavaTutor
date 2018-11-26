package com.luxoft.training.java2.module9;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Test;

public class LogHierarchyTutor {
	Logger logger = Logger.getLogger(LoggerLevelTutor.class.getName());

	@Test
	public void log() {
		Logger base = Logger.getLogger("org.jdom");
		Logger elt = Logger.getLogger("org.jdom.Element");
		Logger attr = Logger.getLogger("org.jdom.Attribute");
		// base == elt.getParent()

		elt.info("Displayed");
		attr.info("Displayed");
		base.setLevel(Level.SEVERE);
		elt.info("Hidden");
		attr.info("Hidden");
		elt.setLevel(Level.INFO);
		elt.info("Displayed");
		elt.fine("Fine");
		attr.severe("Severe");

		elt.setLevel(null);
		elt.info("Hidden");
	}
}
