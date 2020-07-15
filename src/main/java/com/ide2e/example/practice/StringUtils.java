package com.ide2e.example.practice;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringUtils {

	public String encodeValue(final String value) {
		return repetetiveSequence(value, 0, new StringBuffer(), 1);
	}

	public String naturalOrder(String value, String seperator) {
		List<Integer> listOfIntegers = Stream.of(value.split(seperator)) // split
				.map(s -> Integer.parseInt(s)) // map to integer
				.collect(Collectors.toList()); // collect result

		listOfIntegers.sort(Comparator.naturalOrder()); // sort in natural order
		listOfIntegers.forEach(System.out::print);
		return listOfIntegers.stream().map(s -> s.toString()).collect(Collectors.joining(seperator));
	}

	public String fetchTopValues(String value, String seperator, int limit) {
		
		List<Integer> listOfIntegers = Stream.of(value.split(seperator)) // split
				.map(s -> Integer.parseInt(s)) // map to integer
				.collect(Collectors.toList()); // collect result
		listOfIntegers.sort(Comparator.reverseOrder()); // sort in natural order
		return listOfIntegers.subList(0, limit)
				             .stream()
				             .map(s->s.toString()) // convert to string
				             .collect(Collectors.joining(seperator)); //create string with seperator
	}

	private String repetetiveSequence(final String value, int startIndex, StringBuffer result, int counter) {

		char currentValue = value.charAt(startIndex);
		// reached last character in string...add and exit.
		if (startIndex == (value.length() - 1)) {
			result.append(counter + Character.toString(currentValue));
			return result.toString();
		}
		// check compare current value with next value if same call recursively and
		// increase counter.
		// or add counter and current character and move index to next value.
		if (currentValue == value.charAt(startIndex + 1)) {
			return repetetiveSequence(value, ++startIndex, result, ++counter);
		} else {
			result.append(counter + Character.toString(currentValue));
			return repetetiveSequence(value, ++startIndex, result, 1);
		}
	}
}
