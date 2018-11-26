package com.luxoft.training.java2.module2;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class FileStreamTutor {
	private static final String FILES_TEST_PATH = "files/test.txt";
	private static final String TEST_LINE = "test line";

	/**
	 * Записывает в файл FILES_TEST_PATH строку TEST_LINE,  
	 * преобразуя строку в массив байтов.
	 * Для записи используйте класс FileOutputStream.
	 */
	public void writeToFile() {
	}
	
	/**
	 * Считывает строку из файла и возвращает ее, используя FileInputStream.
	 * @return
	 */
	public String readFromFile() {
		return null;
	}
	
	@Test
	public void testFileStream() {
		writeToFile();
		String s = readFromFile();
		assertEquals(TEST_LINE, s);
	}
	
	@Before
	public void createFile() {
		File f1 = new File(FILES_TEST_PATH);
		try {
			f1.delete();
			f1.createNewFile();
		} catch (IOException e1) {
			e1.printStackTrace();
		}		
	}
	
}
