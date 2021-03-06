package com.luxoft.training.java2.module2;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Formatter;
import java.util.Locale;

import org.junit.Test;

public class FormatNumberTutor1 {
	
	/**
	 * Должен выводить число в формате "111.12" или "3.14"
	 * (2 знака после запятой, разделенные точкой)
	 */
	public String fomatNumber(double n) {
		Formatter fmt = new Formatter(Locale.US);
		Formatter f = fmt.format("%.2f", n);
		return f.toString();
	}

	public void formatNumber() {
        long n = 461012;
        System.out.format("%d%n", n);      //  -->  "461012"
        System.out.format("%08d%n", n);    //  -->  "00461012"
        System.out.format("%+8d%n", n);    //  -->  " +461012"
        System.out.format("%,8d%n", n);    // -->  " 461,012"
        System.out.format("%+,8d%n%n", n); //  -->  "+461,012"
        
        double pi = Math.PI;

        System.out.format("%f%n", pi);       // -->  "3.141593"
        System.out.format("%.3f%n", pi);     // -->  "3.142"
        System.out.format("%10.3f%n", pi);   // -->  "     3.142"
        System.out.format("%-10.3f%n", pi);  // -->  "3.142"
        System.out.format(Locale.FRANCE,
                          "%-10.4f%n%n", pi); // -->  "3,1416"

        Calendar c = Calendar.getInstance();
        System.out.format("%tB %te, %tY%n", c, c, c); // -->  "May 29, 2006"
        System.out.format("%tl:%tM %tp%n", c, c, c);  // -->  "2:34 am"
        System.out.format("%tD%n", c);    // -->  "05/29/06"
	}
	
	@Test
	public void testFormatNumber() {
		String number = fomatNumber(Math.PI);
		assertEquals("3.14", number);
		System.out.println(number);
		formatNumber();

	}
}
