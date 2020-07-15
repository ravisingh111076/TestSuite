package com.ide2e.example.practice;

import java.util.ArrayList;
import java.util.List;

public class Fibonacci {

	public static List<Integer> fibonacciSeries(int number, List<Integer> fibonacci, int count) {
		
		if(count==number) {
			return fibonacci;
		}
		
		if(count==0 || count==1) {
			fibonacci.add(1);
		}
		
	    if(fibonacci.size() >= 2) {
	    	    fibonacci.add(fibonacci.get(fibonacci.size() - 1) + 
	    	    		fibonacci.get(fibonacci.size() - 2));    
	    }
	    
	    return fibonacciSeries(number, fibonacci, ++count);
	}
	
	public static void main(String [] args) {
		List<Integer> values = Fibonacci.fibonacciSeries(20, new ArrayList<>(), 0);
		values.forEach(System.out::println);
	}
}
