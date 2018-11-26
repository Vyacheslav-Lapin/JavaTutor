package com.luxoft.training.java2.module4;

	import static com.luxoft.training.Logger.log;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.junit.Test;

public class SynchronizedListTutor1 {
	static String [] animals =
	    {"Корова", "Гусь", "Кошка", "Собака", "Слон",
	    "Заяц", "Змея", "Курица", "Лошадь", "Человек",
	    "Корова", "Змея"};
	Object lock = new Object();
	//List<String> randomAnimals = new ArrayList<String>();
	List<String> randomAnimals = Collections.synchronizedList(new ArrayList<String>());
	
	public String getRandomAnimal() {
		int index = (int)(Math.random()*animals.length);
		return animals[index];
	}
	
	class TestThread implements Runnable {
		String threadName;
		
		public TestThread(String threadName) {
			this.threadName = threadName;
		}
		
		@Override
		public void run() {
			for (int i=0;i<100000;i++) {
				randomAnimals.add(getRandomAnimal());
			}
		}
		
	}
	
	public void print(Collection<?> c) {
		StringBuilder builder = new StringBuilder();
		Iterator<?> iterator = c.iterator();
		while(iterator.hasNext()) {
			 builder.append(iterator.next());
			 builder.append(" ");
		}
		log(builder.toString());
	}

	@Test
	public void testThread() {
		List<Thread> threads = new ArrayList<Thread>();
		for (int i=0;i<100;i++) {
			threads.add(new Thread(new TestThread("t"+i)));
		}
	    System.out.println("Starting threads");
		for (int i=0;i<100;i++) {
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
