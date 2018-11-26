package com.luxoft.training.java2.module3;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Test;

/**
 * Добавим счетчик, подсчитывающий количество вызовов.
 * Почему счетчик показывает разные значения?
 * Как это исправить?
 * 
 * Попробуйте закомментировать обращение к yield().
 * Как изменится значение?
 */
public class AtomicCounterTutor1 {
	int counter=0;

	class TestThread implements Runnable {
		String threadName;
		
		public TestThread(String threadName) {
			this.threadName = threadName;
		}
		
		@Override
		public void run() {
			for (int i=0;i<100;i++) {
				counter++;
				Thread.yield();
			}
		}
	}
	
	@Test
	public void testThread() {
		List<Thread> threads = new ArrayList<Thread>();
		for (int i=0;i<10;i++) {
			threads.add(new Thread(new TestThread("t"+i)));
		}
	    System.out.println("Starting threads");
		for (int i=0;i<10;i++) {
			threads.get(i).start();
		}
	    try {
			for (int i=0;i<10;i++) {
				threads.get(i).join();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	    System.out.println("Counter="+counter);

	}

}
