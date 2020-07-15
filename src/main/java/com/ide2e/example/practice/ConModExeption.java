package com.ide2e.example.practice;

import java.util.HashMap;
import java.util.Map;

public class ConModExeption {

	public static void main(String[] ravi) {
		Map<String, String> map = new HashMap<>();
		
		map.put("key1", "value1");
		map.put("key2", "value1");
		map.put("key3", "value1");
		map.put("key5", "value1");
		
		for(String key: map.keySet()) {
			String value = map.get(key);
			System.out.println("value :" + value);
			map.put("key6", "value");
		}
		
	}
}
