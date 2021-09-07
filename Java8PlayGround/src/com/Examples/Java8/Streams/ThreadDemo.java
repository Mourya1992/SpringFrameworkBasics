package com.Examples.Java8.Streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Predicate;

public class ThreadDemo {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		ExecutorService service = Executors.newFixedThreadPool(5);
		/*
		 * for(int i=0;i<threads.length;i++) { threads[i] = new ExampleThread();
		 * threads[i].start(); }
		 * 
		 * for(int i=0;i<100;i++) { Thread t = new Thread(new Test123());
		 * t.setName("name:"+i);
		 * 
		 * t.start(); }
		 */

		/*
		 * int cores = Runtime.getRuntime().availableProcessors();
		 * 
		 * ExecutorService service = Executors.newFixedThreadPool(cores);
		 * 
		 * ExecutorService serviceChacheble = Executors.newCachedThreadPool();
		 * 
		 * for(int i=0;i<10;i++) {
		 * 
		 * serviceChacheble.execute(new Test123()); }
		 */


		/*
		 * try { System.out.println(callableValue.get(4, TimeUnit.SECONDS)); } catch
		 * (InterruptedException | ExecutionException | TimeoutException e) {
		 * System.out.println("Time out occoured"); e.printStackTrace(); }
		 * 
		 * System.out.println("I m main thread");
		 */
		/*
		 * IsNUmmlabe("pass string") ifPresent orElse
		 * 
		 */
		Optional<String> value = Optional.empty();
		value = Optional.ofNullable("Mourya");

		value.filter((v) -> v.charAt(0) == ('M')).ifPresent(System.out::print);

		/*
		 * Book b1 = new Book(1234, "Ramayana", Arrays.asList("Valmiki"),250); Book b2 =
		 * new Book(1235, "Song of Ice and Fire", Arrays.asList("George RR Martin",
		 * "David"),400); Book b3 = new Book(1234, "Alchemist",
		 * Arrays.asList("Paulo Chelho", "Maurya", "Anand"),500); Book b4 = new
		 * Book(1234, "The 5 AM Club", Arrays.asList("Robin Sharma"),450);
		 * 
		 * List<Book> books = Arrays.asList(b1, b2, b3, b4);
		 * 
		 * books.stream().flatMap(name -> name.getAuthor().stream()).filter(name ->
		 * name.contains("RR")) .forEach(System.out::println);
		 */

	}

}
