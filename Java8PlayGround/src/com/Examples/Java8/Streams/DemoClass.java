package com.Examples.Java8.Streams;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.TemporalUnit;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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



		System.out.println("Flat map example::");
		System.out.println("Flat map example::");


		books.stream()
				.flatMap(b -> b.getAuthor().stream().sorted(Comparator.comparing(Author::getBooksPublished))
						.filter(k -> k.getName().startsWith("J")).map(k -> k.getEmailId()))
				.forEach(System.out::println);

		System.out.println("Date Time API");

		LocalDate date = LocalDate.ofYearDay(2021, 34);
		System.out.println("Date is ::" + date);
		System.out.println("Day of the week is:" + date.getDayOfWeek());

		LocalDateTime time = LocalDateTime.of(2021, Month.APRIL, 25, 3, 30, 47, 00);

		System.out.println(time.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")));
		LocalDate tomorrow = date.plusDays(1);

		System.out.println("tomorrow:" + tomorrow.isAfter(date));
		
		Stream.iterate(0, n->n+2).limit(20).forEach(System.out::println);
	}

}
