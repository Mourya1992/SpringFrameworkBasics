package com.Examples.Java8.Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class JavaStreamAPI {

	public void take(int[] list) {

	}

	public static void main(String[] args) throws CloneNotSupportedException {
		
		
		List<Person> persons = Arrays.asList(new Person("RAj", "M"),new Person("Suma", "F"),new Person("Singh", "M"),
				new Person("Selvi", "F"),new Person("Rumi","F"),new Person("Ashok","M"),new Person("Anitha","F"));
				
		persons.stream().sorted(Comparator.comparing(Person::getGender).thenComparing(Person::getName)).map(p->p).forEach(System.out::println);
		
		
		//@getmapping("/search/{id}")
		//@postmapping("/search")
		//@putmapping("/search")
		//@deleteMapping("/search/{id}")
		
		/*
		 * 
		 * test class
		 * 
		 * Object A
		 * 
		 * synchronized  compute A
		 * 	synchronized compute B
		 */
		
		
		
		  System.out.println("Hi");
		  
		  List<Integer> numbers = Arrays.asList(15, 3, 5, 7, 2, 10);
		  
		  int sum = numbers.stream().reduce(0, (a, b) -> a + b);
		  
		  int sum1 = numbers.stream().reduce(Integer::sum).get();
		  
		  System.out.println(sum);
		  
		  System.out.println(sum1); 
		  Predicate<Student> studentstate = student -> student.getState().equalsIgnoreCase("Andhra Pradesh"); 
		  Predicate<Student> studentcity = student -> student.getCity().equalsIgnoreCase("Nellore");
		  
		  List<Student> students = Arrays.asList(new Student(12, "Ravinder", "Nellore",
		  "India", "Andhra Pradesh", 3), new Student(13, "Anand", "Hyderabad", "India",
		  "Telangana", 7), new Student(14, "Mourya", "Kurnool", "India",
		  "Andhra Pradesh", 8), new Student(15, "Sarat", "pune", "India", "Maharastra",
		  2));
		  
		  List<String> names =
		  students.stream().filter(studentstate.and(studentcity)).map(student ->
		  student.getName()) .collect(Collectors.toList());
		  names.stream().forEach(System.out::println);
		  
		  students.stream().sorted((p1, p2) -> { if (p1.getStandard() >
		  p2.getStandard()) return 1; else return -1; }).map(p ->
		  p.getName()).forEach(System.out::println);
		  
		  students.stream().sorted(Comparator.comparing(Student::getStandard)).map(p ->
		  p.getName()) .forEach(System.out::println);
		  
		  
		  List<String> listOfStrings =
		  Arrays.asList("Anand","Mourya","Vajjala","rani","Binson","Jaguu");
		  System.out.println("Before sort .....");
		  listOfStrings.stream().forEach(System.out::println);
		  Collections.sort(listOfStrings); System.out.println("After sort .....");
		  listOfStrings.stream().forEach(System.out::println);
		  
		  
		  Student s1 = new Student(1235, "kriti", "Delhi", "India", "Delhi", 6);
		  
		  System.out.println(s1.getClass().hashCode()); Student s3 = (Student)
		  s1.clone();
		  
		  Student s2 = s1;
		  
		  System.out.println("Hashcode using assignment "+s2.getClass().hashCode()+
		  "name:"+s2.getName());
		  
		  
		  
		  System.out.println("Using clone "+s3.getClass().hashCode()+"name:"+s3.getName
		  ());
		  
		  s2.setCity("Ahemedabad");
		  
		  s3.setState("Gujrat");
		  
		  System.out.println(s1); System.out.println(s3);
		  
		  
		 
		
		  String a = "Hello"; StringBuilder sb = new StringBuilder(a);
		  
		  System.out.println(sb.reverse()); char[] a1 = a.toCharArray();
		  
		  a = ""; for (int i = a1.length - 1; i >= 0; i--) { System.out.println(a1[i]);
		  
		  a = a + a1[i]; } System.out.println("Reversed string::" + a);
		 
		
		  long start = System.currentTimeMillis(); System.out.println(start);
		  stringRotations("Collections"); 
		  long end = System.currentTimeMillis();
		  System.out.println(end);
		  System.out.println("execution time is::"+(end-start));
		 
		
		Map<String ,String> hm = new HashMap<String, String>();
		hm.put(null,"Mourya");
		
		System.out.println(hm.get(null));
		Student s = new Student();
		
		ArrayList<Integer> nums = new ArrayList<Integer>();
	nums.add(1);
	nums.add(2);
	Object[] num = nums.toArray();
	
	for(Object i:num) {
		System.out.println(i);
	}
	}
	
	
	public static  void stringRotations(String incomingString) {
		
		for(int i=0;i<incomingString.length();i++) {
			char j = incomingString.charAt(incomingString.length()-1);
			incomingString=incomingString.substring(0, incomingString.length()-1);
			//System.out.println("the substring is::"+incomingString);
			incomingString = j+incomingString;
			
			System.out.println("Rotation:"+i+"::"+incomingString);
			
			
		}
		
	}

}
