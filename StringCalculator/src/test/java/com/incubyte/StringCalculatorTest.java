package com.incubyte;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
	
	@ParameterizedTest
	@CsvSource(value={"'1,2\n3':6","'1\n2\n3':6"}, delimiter=':')
	public void testAdd_ReturnSum_WhenCommaOrSlashNusedAsDelimiter(String input, int expectedSum) {
		assertEquals(expectedSum, stringCalculator.add(input));
	}
	
	@ParameterizedTest
	@CsvSource(value={"'//;\n1;2':3","'//!\n1!2!3':6"}, delimiter=':')
	public void testAdd_ReturnSum_WhenCustomDelimiterIsUsed(String input, int expectedSum) {
		assertEquals(expectedSum, stringCalculator.add(input));
	}
	
	@Test
	public void testAdd_ThrowsException_WhenNegativeNumberIsPassed() {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
			stringCalculator.add("-1,2");
			});
		assertEquals("negative numbers not allowed -1", exception.getMessage());
	}
}
