package com.luxoft.training.java2.module2;

import static com.luxoft.training.Logger.*;
import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

public class FileTutor1 {

	/**
	 * Метод должен создавать папку test и в ней - файл test/test.txt
	 * Также выведите в лог полный путь к созданному файлу
	 */
	public void createFile() {
		File dir = new File("test");
		dir.mkdir();
		File f = new File("test/test.txt");
		try {
			log("Файл создан? "+f.createNewFile());
		} catch (IOException e) {
			e.printStackTrace();
		}
		log(f.getAbsolutePath());
	}
	
	/**
	 * Метод должен удалять папку test и файл test/test.txt
	 */
	public void deleteFile() {
		File f = new File("test/test.txt");
		f.delete();
		File dir = new File("test");
		dir.delete();
	}
	
	
	@Test
	public void testCreateFile() {
		createFile();
		File f = new File("test/test.txt");
		assertTrue(f.exists());
	}
	
	@Test
	public void testDeleteFile() {
		deleteFile();
		File f = new File("test/test.txt");
		assertFalse(f.exists());
		assertFalse(new File("test").exists());
	}


}
