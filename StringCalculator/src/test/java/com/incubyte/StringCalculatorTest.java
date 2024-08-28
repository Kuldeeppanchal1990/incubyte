package com.incubyte;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {

	private static StringCalculator stringCalculator;
	
	@BeforeAll
	public static void setup() {
		stringCalculator = new StringCalculator();
	}
	
	@Test
	public void testAdd_ReturnZero_WhenNothingIsPassedAsString() {
		int actualSum = stringCalculator.add("");
		int expectedSum = 0;
		
		assertEquals(expectedSum, actualSum);
	}
	
	@Test
	public void testAdd_ReturnOne_WhenOneIsPassedAsString() {
		int actualSum = stringCalculator.add("1");
		int expectedSum = 1;
		
		assertEquals(expectedSum, actualSum);
	}
	
	@Test
	public void testAdd_ReturnSumOfTwoNos_WhenTwoNosArePassedAsString() {
		int actualSum = stringCalculator.add("1,2");
		int expectedSum = 3;
		
		assertEquals(expectedSum, actualSum);
	}
}
