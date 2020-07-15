package com.ide2e.example.practice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class StringUtilsTest {
	
	@Test
	public void testEncodeValue() {
	StringUtils utils = new StringUtils();
		assertEquals("4a3b2c1d", utils.encodeValue("aaaabbbccd"));
		assertEquals("1a1b1c1d", utils.encodeValue("abcd"));
		assertNotEquals("1a1b1c1d", utils.encodeValue("abcddsasdasd"));
	}
	
	@Test
	public void testNaturalSortingValue() {
	StringUtils utils = new StringUtils();
		assertEquals("4 6 8 9", utils.naturalOrder("4 6 8 9", " "));
		assertEquals("-10 4 6 8 9", utils.naturalOrder("6 4 9 8 -10", " "));
	}
	
	@Test
	public void testFetchTopElements() {
	StringUtils utils = new StringUtils();
		assertEquals("9 8", utils.fetchTopValues("4 6 8 9", " ", 2));
		
	}
}
