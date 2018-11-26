package com.luxoft.training.java2.module3;
import static com.luxoft.training.Logger.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * Добавили синхронизационный блок. 
 * Но почему счетчик не синхронизирован?
 */
public class SynchronizedTutor3 {
	Integer counter = 0;

	class TestThread implements Runnable {
		String threadName;
		
		public TestThread(String threadName) {
			this.threadName = threadName;
		}
		
		@Override
		public void run() {
			for (int i=0;i<10;i++) {
				synchronized(counter) {
					counter++;
					log(threadName+":"+i+":"+counter); //+System.identityHashCode(counter)
					Thread.yield();
				}
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
	    System.out.println("Waiting for threads");
	    try {
			for (int i=0;i<100;i++) {
				threads.get(i).join();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
