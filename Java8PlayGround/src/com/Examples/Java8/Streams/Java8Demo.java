package com.Examples.Java8.Streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Java8Demo {

	public static void main(String[] args) {

		List<Book> books = Arrays.asList(
				new Book(1234, "Sita",
						Arrays.asList(new Author("Amish Tripathi", 6, "Amish.c@gmail.com"),
								new Author("Pankaj Tripathi", 9, "Pankaj.c@gmail.com")),
						250),
				new Book(1235, "Harry Potter", Arrays.asList(new Author("JK Rowling", 9, "jkrowling.c@gmail.com")),
						650),
				new Book(1236, "5 AM Club", Arrays.asList(new Author("Robin Sharma", 5, "Robin.c@gmail.com")), 550));

		Predicate<Book> p1 = (book) -> book.getPrice() > 300;
		Predicate<String> p2 = name -> name.startsWith("S");

		// Lambda Expression to loop over using for each
		books.forEach(b -> System.out.println(b));
		// Using Stream functions to loop over
		books.stream().forEach(System.out::println);
		int count = (int) books.stream().count();
		System.out.println("Total books in the store::" + count);
//Using Filter
		books.stream().filter(b -> b.getPrice() > 400).forEach(System.out::println);
		Map<Integer, String> booksSet = books.stream().filter(p1)
				.collect(Collectors.toMap(Book::getBookId, b -> b.getBookName()));

		booksSet.forEach((k, v) -> System.out.println(k + ":" + v));

		books.stream().sorted(Comparator.comparing(Book::getPrice).reversed()).forEach(System.out::println);

		books.stream().sorted((b1, b2) -> {
			if (b1.getPrice() > b2.getPrice())
				return 1;
			else
				return -1;
		}).forEach(System.out::println);

		books.stream().flatMap(b -> b.getAuthor().stream().filter(k -> k.getName().startsWith("J")))
				.forEach(System.out::println);

		System.out.println(new Book().getPrice());

		Function<String, String> functionExample = (name) -> {
			System.out.println("the name is " + name);
			return "hi " + name;
		};

		functionExample.apply("raju");
	}

}
