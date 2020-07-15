package com.ide2e.example.practice;
import java.util.Map;
import java.util.WeakHashMap;

public class DemoWeakRef {

	public static void main(String [] ravi) {
		Map<Order, Integer> weakMap = new WeakHashMap<>();
		
		weakMap.put(new Order(1,  "Delhi"), 0);
		weakMap.put(new Order(2, "New york"), 0);
		System.out.println(" size of map :" + weakMap.size() );
		
		//Order strongRefOrder = new Order(3, "Jamshedpur");
		//weakMap.put(strongRefOrder,0);
		System.gc();
		System.out.println("Size of map :" + weakMap.size());
		
    }
}
class Order {
	int id;
	String details;
	public Order(int id, String theDetails) {
		this.id = id;
		this.details = theDetails;
	}
}