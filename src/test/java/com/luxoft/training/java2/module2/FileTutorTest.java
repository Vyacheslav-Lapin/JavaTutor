package com.luxoft.training.java2.module2;

import static lombok.AccessLevel.PRIVATE;
import static org.junit.Assert.*;

import java.io.File;

import lombok.experimental.FieldDefaults;
import org.apache.logging.log4j.core.config.Order;
import org.junit.jupiter.api.Test;

@FieldDefaults(level = PRIVATE)
class FileTutorTest {

	static final String FILE_PATH = "./test/test.txt";
	FileTutor fileTutor = new FileTutor();
	
	@Test
	void testDeleteFile() {

		// given, when
		File file = fileTutor.createFile(FILE_PATH);

		assertTrue(file.exists());

		fileTutor.deleteFile(file);

		// then
		assertFalse(file.exists());
	}


}
