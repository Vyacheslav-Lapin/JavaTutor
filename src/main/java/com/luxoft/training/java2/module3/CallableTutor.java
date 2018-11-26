package com.luxoft.training.java2.module3;

import static com.luxoft.training.Logger.log;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

import org.junit.Test;

/**
 * Интерфейс Callable<T> позволяет создавать потоки, возвращающие результат
 * выполнения Т.
 *  
 * 1) Попробуйте запустить класс и посмотреть на результаты и время выполнения.
 * 		Замените вызов newSingleThreadExecutor() на  newFixedThreadPool() 
 * 		и сравните время выполнения.
 * 2) Используйте вместо executorService.execute() вызов executorService.submit()
 * 		с сохранением результата Future в массиве results.
 * 3) Попробуйте прекратить выполнение первых 3-х потоков, используя метод cancel().
 * 		Добавьте обработку CancellationException.
 * 4) Добавьте перед прекращением работы потоков сон на 150 секунд.
 * 		Поэкспериментируйте с размером пула: сколько потоков успеют завершить работу,
 * 		а сколько нет (установите, например, значение 2). 
 * 		При прекращении работы потоков добавьте логгирование, 
 * 		сообщающее, завершил ли работу поток:
 * 			log("cancelling thread "+i+", isDone="+results.get(i).isDone());
 *	5) Добавьте сообщение после завершения сна StringGenerator:
 *			log("thread is finished: "+allStrings[index]);
 *		Попробуйте поэкспериментировать со значениями параметра cancel: true или false.
 *
 */
public class CallableTutor {

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
		List<Thread> threads = new ArrayList<Thread>();

		ArrayList<Future<String>> results = new ArrayList<Future<String>>();
		for (int i=0; i<10; i++){
			Callable<String> stringGenerator = new StringGenerator();
			FutureTask<String> task = new FutureTask<String>(stringGenerator);
			results.add(task);
			threads.add(new Thread(task));
		}

		ExecutorService executorService = Executors.newSingleThreadExecutor();
		//ExecutorService executorService = Executors.newFixedThreadPool(10);
		//ExecutorService executorService = Executors.newCachedThreadPool();
		for (int i=0;i<10;i++) {
			executorService.execute(threads.get(i));
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
			}
		}
		log(resultStr);

		long time =new Date().getTime()-start;
		log("Time of work:"+time);
	}

}
