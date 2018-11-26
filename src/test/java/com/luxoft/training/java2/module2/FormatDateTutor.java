package com.luxoft.training.java2.module2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;
import java.util.Locale;
import static com.luxoft.training.Logger.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class FormatDateTutor {

	/**
	 * Возвращает дату в формате dd.mm.yy
	 * Использует Formatter
	 */
	public String getDateByFormatter(Date date) {
		return null;
	}

	/**
	 * Возвращает дату в формате "10 of April, 2013"
	 * Использует Formatter
	 */
	public String getDateString(Date date) {
		return null;
	}
	
	/**
	 * Возвращает дату в формате "10.04.13"
	 * Используйте SimpleDateFormat
	 */
	public String getDateBySimpleDateFormat(Date date) {
		return null;
	}
	
	/**
	 * Возвращает дату типа Date, полученную из строки в формате dd.mm.yy
	 * Использует SimpleDateFormat метод parse()
	 */
	public Date parseDDMMYY(String s) {
		return null;
	}
	
	@Test
	public void testFormatDate() {
		Calendar cal = Calendar.getInstance();
		cal.set(2013, 4, 1); // 1st of May, 2013
		Date date = cal.getTime();
		
		String dateByFormatter = getDateByFormatter(date);
		log("dateByFormatter:"+dateByFormatter);
		assertEquals(dateByFormatter, "01.05.13");
		
		String dateBySimpleDateFormat = getDateBySimpleDateFormat(date);
		log("dateBySimpleDateFormat:"+dateBySimpleDateFormat);
		assertEquals(dateBySimpleDateFormat, "01.05.13");

		System.out.println(getDateString(new Date()));
		//formatNumber();
	}
	
	@Test
	public void testParseDate() {
		Calendar cal = Calendar.getInstance();
		cal.set(2013, 4, 1, 0, 0, 0); // 1st of May, 2013
		cal.set(Calendar.MILLISECOND, 0);
		Date date = cal.getTime();
		Date d = parseDDMMYY("01.05.13");
		assertEquals(date, d);
	}
}
