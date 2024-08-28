package com.incubyte;

public class StringCalculator {
	
	private static final String COMMA_DELIMITER = ",";
	private static final String NEW_LINE_DELIMITER = "\n";
	private static final String CUSTOM_DELIMITER_INDICATOR_START = "//";

	public int add(String inputString) {
		if (inputString.isBlank()) {
			return 0;
		}
		
		if (inputString.contains(COMMA_DELIMITER) == false && inputString.contains(NEW_LINE_DELIMITER) == false) {
			return Integer.valueOf(inputString);
		}
		
		String[] splittedStrings = splitInputString(inputString);
		
		int sum = 0;
		for (String str : splittedStrings) {
			int number = Integer.valueOf(str);
			if (number < 0) {
				throw new IllegalArgumentException("negative numbers not allowed " + number);
			}
			sum += number;
		}
		return sum;
	}
	
	private String[] splitInputString(String inputString) {
		String delimiter = COMMA_DELIMITER + "|" + NEW_LINE_DELIMITER;

		if (inputString.startsWith(CUSTOM_DELIMITER_INDICATOR_START)) {
			String[] delimiterAndInputStr = inputString.split(NEW_LINE_DELIMITER, 2);
			delimiter = delimiterAndInputStr[0].substring(CUSTOM_DELIMITER_INDICATOR_START.length());
			inputString = delimiterAndInputStr[1];
		}
		return inputString.split(delimiter);
	}

}
