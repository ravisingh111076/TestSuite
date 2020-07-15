package com.ide2e.example.practice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SortingExamples {
	
	public Optional<Person> findPerson(String name) {
		return Optional.empty();
		
	}
    public Function<String, Integer> f = Integer::valueOf;
	public static void main(String [] args) {
		
		List<Person> persons = new ArrayList<>();
		
		persons.add(new Person(76, "jj"));
		persons.add(new Person(60, "pp"));
		persons.add(new Person(80, "cc"));
		persons.add(new Person(25, "dd"));
		persons.add(new Person(50, "ee"));
		persons.add(new Person(100, "tt"));
		
		Collections.sort(persons, (p1, p2) -> p1.compareTo(p2));
		persons.forEach(p->System.out.println(p.getAge()));
		
		Collections.sort(persons, (p1, p2) -> p1.name.compareTo(p2.name));
		persons.forEach(p->System.out.println(p.toString()));
		
		Collections.sort(persons, (next, current) -> current.age.compareTo(next.age));
		persons.forEach(p->System.out.println(p.toString()));
		
		SortingExamples examples = new SortingExamples();
		Person p = examples.findPerson("Ravi").orElse(new Person(0,""));
		
		if(examples.findPerson("Ravi").isPresent()) {
			
		}
		
		//Person p1 = examples.findPerson(null).orElseThrow(RuntimeException::new);
		
//		List<String> seniorCitizen = new ArrayList<>();
//		for(Person person: persons) {//stream
//			if(person.getAge() >60) { // filter
//				seniorCitizen.add(person.getName()); //map
//			}
//		}
		
		//java 8
		List<String> seniorCitizen = persons.stream().filter(person->person.getAge() >60).
				map(person-> p.getName())
				.collect(Collectors.toList());
		seniorCitizen.forEach(System.out::println);
	//	examples.f;
		
	}
	
}
