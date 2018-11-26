package com.luxoft.training.java2.module1;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;
import static com.luxoft.training.Logger.log;

import org.junit.Test;


public class SystemCurrentTimeTutor {

	/**
	 * getTimeInMillis() должен возвращать текущее время в миллисекундах
	 */
	public long getTimeInMillis() {
		return System.currentTimeMillis();
	}
	
	/**
	 * профайлер должен вычислять, сколько миллисекунд заняло 
	 * выполнение метода Runnable.run()
	 * 
	 * @param run
	 * @return
	 */
	public long profiler(Runnable run) {
		run.run();
		return 0;
	}
	
	/**
	 * Метод должен возвращать дату по миллисекундам
	 */
	public Date getDate(long timeInMillis) {
		return new Date();
	}
	
	/**
	 * метод должен возвращать дату, к которой прибавлено (или отнято) plusDays дней
	 */
	public Date getDatePlus(Date date, int plusDays) {
		return new Date();
	}
	
	@Test
	public void testGetDate() {
		Date date = getDate(1363877852603l);
		log(date.toString());
		assertEquals(date.getTime(), 1363877852603l);
		Date dateOfBeginning = getDate(0);
		log(dateOfBeginning.toString());
		assertEquals(dateOfBeginning.getTime(), 0);
	}
	
	@Test
	public void testGetDatePlus() {
		// create date for 1.04.2013, 12:30
		Calendar cal = Calendar.getInstance();
		cal.set(2013, 3, 1, 12, 30, 0);
		cal.clear(Calendar.MILLISECOND);
		// create date for 3.04.2013, 12:30
		Calendar cal2 = Calendar.getInstance();
		cal2.set(2013, 3, 3, 12, 30, 0);
		cal2.clear(Calendar.MILLISECOND);
		Date datePlus = getDatePlus(cal.getTime(), 2);
		log(cal.getTime().toString());
		log(datePlus.toString());
		log(cal2.getTime().toString());
		log(datePlus.getTime()+":"+cal2.getTimeInMillis());
		assertEquals("datePlus() возвращает неверную дату", 
				datePlus, cal2.getTime());
	}
	
	@Test
	public void testGetTimeInMillis() {
		assertTrue(
			"getTimeInMillis() должен возвращать время в миллисекундах",
			getTimeInMillis()>1363877852603l);
	}
	
	@Test
	public void testForProfiler() {
		assertTrue(noOperationProfiler()==0);
		assertTrue(forProfiler()>0);
	}
	
	public long noOperationProfiler() {
		return profiler(new Runnable() {
			public void run() {}
		});
	}
	
	public long forProfiler() {
		return profiler(new Runnable() {
			@Override
			public void run() {
				for (int i=0;i<100000000;i++);
			}
		});
	}
	
	public static void main(String[] args) {
		SystemCurrentTimeTutor systemClass = new SystemCurrentTimeTutor();
		log(systemClass.getTimeInMillis());
	}
	
}
