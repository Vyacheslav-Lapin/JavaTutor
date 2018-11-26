package com.luxoft.training.java2.module3;
import static com.luxoft.training.Logger.log;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class ExecutorServiceTutor2 {
	Integer counter = 0;
	Object lock = new Object();
	Object lock2 = new Object();
	Set<String> currentThreads = new HashSet<String>();

	public void sleep(long timeout) {
		try {
			Thread.sleep(timeout);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	class TestThread implements Runnable {
		String threadName;
		
		public TestThread(String threadName) {
			this.threadName = threadName;
		}
		
		@Override
		public void run() {
			synchronized(lock2) {
				currentThreads.add(threadName);
			}
			Thread.yield();
			for (int i=0;i<10;i++) {
				synchronized(lock) {
					counter++;
					log(threadName+":"+i+":"+counter);
				}
				Thread.yield();
			}
			sleep(10);
			Thread.yield();
			synchronized (lock2) {
				StringBuilder currentThreadsStr = new StringBuilder();
				for (String str : currentThreads) {
					currentThreadsStr.append(str).append(", ");
				}
				log("size:"+currentThreads.size()+
						", current thread pool: "+currentThreadsStr.toString()+
						" finished thread "+threadName);
				currentThreads.remove(threadName);
			}
		}
	}
	
	@Test
	public void testThread() {
		long start = new Date().getTime();

		List<Thread> threads = new ArrayList<Thread>();
		for (int i=0;i<100;i++) {
			threads.add(new Thread(new TestThread("t"+i)));
		}

		//ExecutorService executorService = Executors.newSingleThreadExecutor();
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		//ExecutorService executorService = Executors.newCachedThreadPool();
		for (int i=0;i<100;i++) {
			executorService.execute(threads.get(i));
		}
		
		executorService.shutdown();
		try {
			executorService.awaitTermination(1, TimeUnit.MINUTES);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		executorService.shutdownNow();

		long time =new Date().getTime()-start;
		log("Time of work:"+time);
	}

}
