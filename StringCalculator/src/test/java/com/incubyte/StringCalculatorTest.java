package com.incubyte;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class StringCalculatorTest {
	
	@Test
	public void testAdd_ReturnZero_WhenNothingIsPassedAsString() {
		StringCalculator stringCalculator = new StringCalculator();
		
		int actualSum = stringCalculator.add("");
		int expectedSum = 0;
		
		assertEquals(expectedSum, actualSum);
	}
	
	@Test
	public void testAdd_ReturnOne_WhenOneIsPassedAsString() {
		StringCalculator stringCalculator = new StringCalculator();
		
		int actualSum = stringCalculator.add("1");
		int expectedSum = 1;
		
		assertEquals(expectedSum, actualSum);
	}
}
