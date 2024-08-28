package com.incubyte;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
	
	@ParameterizedTest
	@CsvSource(value={"1,2,3:6","1,2,3,4:10","10,10,11,12,15:58"}, delimiter=':')
	public void testAdd_ReturnSum_WhenAnyAmountOfNoArePassedAsString(String input, int expectedSum) {
		assertEquals(expectedSum, stringCalculator.add(input));
	}
}
