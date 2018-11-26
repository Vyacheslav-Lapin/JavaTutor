package com.luxoft.training.java2.module3;
import static com.luxoft.training.Logger.*;

import org.junit.Test;

/**
 * 1) Почему счет counter не доходит до 100 (на быстрой машине попробуйте до 1000)?
 * 2) Как меняет вызов потоков добавление yield()?
 */
public class ThreadTutor {

	class TestThread implements Runnable {
		String threadName;
		
		public TestThread(String threadName) {
			this.threadName = threadName;
		}
		
		@Override
		public void run() {
			for (int i=0;i<100;i++) {
				log(threadName+":"+i);
				Thread.yield();
			}
		}
	}
	
	@Test
	public void testThread() {
		Thread t1 =new Thread(new TestThread("t1"));
		Thread t2 = new Thread(new TestThread("t2"));
	    System.out.println("Starting threads");
		t1.start();
		t2.start();
	}

}
