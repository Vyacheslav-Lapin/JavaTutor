package com.luxoft.training.java2.module1;

import java.util.Locale;
import java.util.Scanner;

import org.junit.Test;

public class ScannerTutor {

	@Test
	public void testScanner() {
	    String numbers="2, 3.4,    5,6, 7.4, 9.1, 10.5, done";

	    Scanner scanner = new Scanner(numbers);
	    // Set delimiters to space and comma.
	    // ", *" tells Scanner to match a comma and zero or more spaces as
	    // delimiters.

	    scanner.useLocale(Locale.US);
	    scanner.useDelimiter(", *");
	    
	    // Read and sum numbers.
	    while (scanner.hasNext()) {
	      if (scanner.hasNextDouble()) {
	        System.out.println(scanner.nextDouble());
	      } else {
	        break;
	      }
	    }

	}
}
