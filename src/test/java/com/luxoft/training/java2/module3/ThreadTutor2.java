package com.luxoft.training.java2.module3;
import static com.luxoft.training.Logger.*;

import org.junit.Test;

/**
 * 1) Теперь счет доходит до 100, почему?
 * 2) Установите приоритеты потоков. 
 *     Обратите внимание, как изменился порядок вызовов. 
 *     Обратите внимание на вероятностный характер указаний приоритета.
 *  3) Попробуйте вместо Thread.yield() использовать Thread.sleep() с разными интервалами
 */
public class ThreadTutor2 {
	
	class TestThread implements Runnable {
		String threadName;
		
		public TestThread(String threadName) {
			this.threadName = threadName;
		}
		
		@Override
		public void run() {
			for (int i=0;i<100;i++) {
				log(threadName+":"+i);
				//Thread.yield();
			}
		}
	}
	
	@Test
	public void testThread() {
		Thread t1 =new Thread(new TestThread("t1"));
		Thread t2 = new Thread(new TestThread("t2"));
		t2.setPriority(Thread.MAX_PRIORITY);
		t1.setPriority(Thread.MIN_PRIORITY);
	    System.out.println("Starting threads");
		t1.start();
		t2.start();
		
	    System.out.println("Waiting for threads");
	    try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
