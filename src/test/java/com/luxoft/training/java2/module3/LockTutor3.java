package com.luxoft.training.java2.module3;

import static com.luxoft.training.Logger.log;

import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.junit.Test;

public class LockTutor3 {
	Thread t1, t2, t3, t4;
	Object monitor = new Object();
	int runningThreadNumber = 1;
	StringBuilder stringBuilder = new StringBuilder("");
	public static long ITERATIONS = 2000000;

	class WritingThread implements Runnable {
		String threadName;
		Lock lock;

		public WritingThread(String threadName, Lock lock) {
			this.threadName = threadName;
			this.lock = lock;
		}

		@Override
		public void run() {
			for (int i = 0; i < ITERATIONS; i++) {
				if (lock.tryLock()) {
					stringBuilder.append(threadName);
					Thread.yield();
					stringBuilder.append(threadName);
					Thread.yield();
					stringBuilder.append(",");
					lock.unlock();
				}
				Thread.yield();
			}
		}
	}

	class ReadingThread implements Runnable {
		String threadName;
		Lock lock;

		public ReadingThread(String threadName, Lock lock) {
			this.threadName = threadName;
			this.lock = lock;
		}

		@Override
		public void run() {
			for (int i = 0; i < 20; i++) {
				lock.lock();
				//log(threadName+" is locked");
				String s = stringBuilder.toString();
				int len = s.length();
				int l = len>50?len-50:0;
				log(threadName+":len="+len+":"+s.substring(l));
				Thread.yield();
				//log(threadName+" is unlocked");
				lock.unlock();
				Thread.yield();
			}
		}
	}

	@Test
	public void testThread() {
		long start = new Date().getTime();
		ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
		t1 = new Thread(new WritingThread("1", lock.writeLock()));
		t2 = new Thread(new WritingThread("2", lock.writeLock()));
		t3 = new Thread(new ReadingThread("r1", lock.readLock()));
		t4 = new Thread(new ReadingThread("r2", lock.readLock()));

		System.out.println("Starting threads");
		t1.start();
		t2.start();
		t3.start();
		t4.start();

		System.out.println("Waiting for threads");
		try {
			t1.join();
			t2.join();
			t3.join();
			t4.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long time =new Date().getTime()-start;
		log("Time of work:"+time);
	}

}
