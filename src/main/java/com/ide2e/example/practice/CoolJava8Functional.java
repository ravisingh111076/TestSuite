package com.ide2e.example.practice;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.*;

public class CoolJava8Functional {

	public static boolean isPrime(int number) {

		return IntStream.range(2, number).noneMatch(i -> number % i == 0);
	}

	public static List<Integer> fibonaci(int number) {
		return null;
	}

	public static long noOfLineHaveSearchWord(String searchWord) throws IOException {
		return Files
				.lines(Paths.get(
						"/Users/ravisingh/Documents/" + "workspace-sts-3.9.0.RELEASE/TestSuite/testRepo/data1.txt"))
				.filter(line -> line.contains(searchWord)).count();
	}

	public static Map<Integer, List<String>> groupByExample(Map<String, Integer> mapOfValues) {
		Map<Integer, List<String>> result = mapOfValues.keySet().stream().collect(groupingBy(mapOfValues::get));
		return result;
	}

	public static boolean isEven(int number) {
		System.out.println(" is even called");
		return number % 2 == 0;
	}

	public static boolean isGreaterThan3(int number) {
		return number > 3;
	}
	
	 public static void printInfo(int value, String msg, Function<Integer, Integer> function) {
		    System.out.println(msg + ": " + value + " is " + function.apply(value));
		  }
	 
	public static void tryAgain() {

		///Users/ravisingh/Documents/workspace-sts-3.9.0.RELEASE/TestSuite/testRepo/data2.txt
		try {
			List<Integer> sortedList = Files.lines(
					Paths.get("/Users/ravisingh/Documents/workspace-sts-3.9.0.RELEASE/TestSuite/"
							+ "testRepo/data2.txt"))
					.map(s->s.split("\\s"))
					.flatMap(Arrays::stream)
					.flatMap(s->Stream.of(s.split(" +")))
					.map(s-> Integer.parseInt(s))
					.collect(Collectors.toList());
			  
			sortedList.sort(Comparator.naturalOrder());	             
		} catch (IOException e) {
	
			e.printStackTrace();
		}
	}
	
	
	public static void sortAgain() {
		
		try {
			Stream<String> obj; 
			
			List<Integer> ll = Files.lines(Paths.get("/Users/ravisingh/Documents/" 
					+ "workspace-sts-3.9.0.RELEASE/TestSuite/testRepo/data2.txt"))
					.map(l->l.split("//s+"))
					.flatMap(Arrays::stream)
					.flatMap(s-> {
						return Stream.of(s.split(" +"));
					}).map(s->Integer.parseInt(s))
					   .collect(Collectors.toList());
			
			ll.sort(Comparator.naturalOrder()); 
			
			ll.stream().forEachOrdered(v -> System.out.print(" " + v));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static int encode(int value) {
		return value;
	}

	public static String encodeString(String value) {
		return value;
	}

	public static List<Character> splitToListOfChar(String str) {
		return str.chars().mapToObj(item -> (char) item).collect(Collectors.toList());
	}

	public static int encodeNumber(int item) {

		return Character.getNumericValue(item);
	}

	public static void maximumOccurence() {

		List<Integer> list = Arrays.asList(1, 1, 2, 2, 2, 2, 3);
        //list.stream().forEachOrdered(action);
	}

	public static void makeASquare() {
		List<Integer> list = Arrays.asList(10,11,12);
       // list.stream().peek(i->{i*i}).collect(Collectors.toList());
        
       List<Integer> in = list.stream().map(i->i*i).collect(Collectors.toList());
        in.forEach(System.out::println);
    }    
	
	public static void sortingExample() {

		String line = "23 4 8 16 42 15";

		List<Integer> sortedList = Stream.of(line.split(" ")).map(elem -> Integer.parseInt(elem))
				.collect(Collectors.toList());

		sortedList.sort(Comparator.naturalOrder());
		String result = sortedList.stream().map(s -> s.toString()).collect(Collectors.joining(" "));
		System.out.println("result :" + result);
		// sortedList.forEach(i -> System.out.print( i + " "));

	}
	
	public static void sumOfAllValues(List<Integer> values) {
		System.out.println(" sum of all :" + values.stream().reduce(0, (a,b) -> a+b));
	}

	public static void main(String[] ravi) throws IOException {
//		System.out.println(" 5 : " + isPrime(5));
//		System.out.println(" 8 : " + isPrime(8));
//		System.out.println(" count :" + noOfLineHaveSearchWord("Ishaan"));
//
//		Map<String, Integer> listOfValues = new HashMap<>();
//
//		listOfValues.put("Ishaan", 15);
//		listOfValues.put("Ayushmaan", 15);
//		listOfValues.put("Ravi", 42);
//		listOfValues.put("Shyam", 42);
//		listOfValues.put("adadsd", 16);
//
//		// groupByExample(listOfValues).keySet().forEach(f->f.get());;
//
//		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 8, 9, 10, 90, 80, 70, 85);
//
//		numbers.sort(Comparator.naturalOrder());
//
//		numbers.subList(numbers.size() - 3, numbers.size()).forEach(System.out::println);
//		String phoneNo = "44778875000";

		// convert phone no into array.
		// take each number pass to function to encode.
		// collect as a String back.

		// phoneNo.chars().map( i-> encode(i)).collect(Collectors.joining(""));
		// phoneNo.chars()
		// .map(Character::getNumericValue)
		// .collect(Collectors.joining(", "))
		// collect(Collectors.toList());

//		List<Integer> digits = Arrays.asList(4, 8, 15, 16, 23, 42);
//
//		String resultValue = digits.stream().map(i -> i.toString()).collect(Collectors.joining());
//		System.out.println(" result Value" + resultValue);
//		// phoneNo.to
//
//		List<String> givenList = Arrays.asList("gjhgg", "gjhjh", "bjgg");
//		String result = givenList.stream().map(a -> encodeString(a)).collect(joining());
//		System.out.println(result);

		//sortingExample();

//		makeASquare();
		
		// Predicate<Integer> greaterThan3 = myInteger-> myInteger>3;
		//
		// Predicate<Integer> evenNumber = myInteger-> myInteger % 2 == 0;
		//
		// //Optional<Integer> result =
		// numbers.stream().filter(greaterThan3.and(evenNumber)).map( e-> e *
		// 2).findAny();
		//
		// Optional<Integer> result =
		// numbers.stream().filter(CoolJava8Functional::isEven).map( e-> e *
		// 2).findFirst();
		//
		// System.out.println(" result :" + result.get());
//		Integer[] ii= {5,6,9,10};
//		List<Integer> integer = Arrays.asList(ii);
//		
//		integer.stream().reduce((x,y)->x+y).ifPresent(System.out::println);
//		
//		String[][] data = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};
//
//        //Stream<String[]>
//        Stream<String[]> temp = Arrays.stream(data);
//
//        //filter a stream of string[], and return a string[]?
//        Stream<String[]> stream = temp.filter(x -> "a".equals(x.toString()));
//
//        stream.forEach(System.out::println);
//		sumOfAllValues(integer);
		
		//sortAgain();
		
		//tryAgain();
		
		printInfo(5, " Square of value is ", e-> e*e);

	}
}
