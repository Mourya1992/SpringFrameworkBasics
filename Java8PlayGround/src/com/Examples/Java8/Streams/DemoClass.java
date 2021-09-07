package com.Examples.Java8.Streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;


public class DemoClass {

	public static void main(String[] args) {

		int[] numbers = IntStream.of(1, 2, 3, 4, 5, 6).toArray();
		List<Book> books = Arrays.asList(
				new Book(1234, "Sita",
						Arrays.asList(new Author("Amish Tripathi", 6, "Amish.c@gmail.com"),
								new Author("Pankaj Tripathi", 9, "Pankaj.c@gmail.com")),
						250),
				new Book(1235, "Harry Potter", Arrays.asList(new Author("JK Rowling", 9, "jkrowling.c@gmail.com")),
						650),
				new Book(1236, "5 AM Club", Arrays.asList(new Author("J.Robin Sharma", 5, "Robin.c@gmail.com")), 550));
		Comparator<Book> comparator = (p1, p2) -> {
			if (p1.getPrice() > p2.getPrice()) {
				return 1;
			} else {
				return -1;
			}
		};

		books.forEach(b -> System.out.println(b));

		System.out.println("Using stream Api to iterate");
		books.stream().forEach(b -> System.out.println(b));

		System.out.println("Using filter");

		books.stream().filter(b -> b.getBookName().contains("book")).forEach(System.out::println);

		System.out.println("Using map");

		books.stream().filter(b -> b.getPrice() >= 500.00).filter(b -> b.getAuthor().size() > 2).findAny()
				.ifPresent(System.out::println);
		System.out.println("Sorting the list using Comparator and comapring");
		books.stream().sorted(Comparator.comparing(Book::getPrice).thenComparing(Book::getBookId).reversed())
				.forEach(System.out::println);

		System.out.println("Sorting using the manually created Comparator::");

		books.stream().sorted(comparator).forEach(System.out::println);

		System.out.println("Flat map example::-");

		books.stream()
				.flatMap(b -> b.getAuthor().stream().sorted(Comparator.comparing(Author::getBooksPublished))
						.filter(k -> k.getName().startsWith("J")).map(k -> k.getEmailId()))
				.forEach(System.out::println);
	}

}
