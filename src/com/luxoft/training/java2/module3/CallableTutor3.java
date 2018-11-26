package com.luxoft.training.java2.module3;

import static com.luxoft.training.Logger.log;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class CallableTutor3 {

	public class StringGenerator implements Callable<String> {

		public String call() throws Exception {
			String [] allStrings =
	                {"Корова", "Гусь", "Кошка", "Собака", "Слон",
	                "Заяц", "Змея", "Курица", "Лошадь", "Человек"};
			int index = (int)(Math.random()*100)/10;

			Thread.sleep(100);
			return allStrings[index];
		}
	}
	
	@Test
	public void testCallable() {
		long start = new Date().getTime();

		ArrayList<Future<String>> results = new ArrayList<Future<String>>();

		//ExecutorService executorService = Executors.newSingleThreadExecutor();
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		//ExecutorService executorService = Executors.newCachedThreadPool();

		for (int i=0;i<10;i++) {
			results.add(executorService.submit(new StringGenerator()));
		}
		
		for (int i=0;i<5;i++) {
			log("cancelling thread "+i);
			results.get(i).cancel(false);
		}
				
		StringBuilder resultStr = new StringBuilder();
		for(Future<String> result: results){
			try {
				// The blocking get call
				resultStr.append(result.get());
				resultStr.append(" ");
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			} catch (CancellationException e) {
			}
		}

		log(resultStr);

		executorService.shutdown();
		try {
			executorService.awaitTermination(1, TimeUnit.MINUTES);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		long time =new Date().getTime()-start;
		log("Time of work:"+time);
	}

}
