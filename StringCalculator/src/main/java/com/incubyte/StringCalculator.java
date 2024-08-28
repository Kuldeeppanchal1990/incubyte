package com.incubyte;

public class StringCalculator {
	
	private static final String COMMA_DELIMITER = ",";
	private static final String NEW_LINE_DELIMITER = "\n";

	public int add(String inputString) {
		if (inputString.isBlank()) {
			return 0;
		}
		
		if (inputString.contains(COMMA_DELIMITER) == false && inputString.contains(NEW_LINE_DELIMITER) == false) {
			return Integer.valueOf(inputString);
		}
		
		String[] splittedStrs = inputString.split(COMMA_DELIMITER + "|" + NEW_LINE_DELIMITER);
		int sum = 0;
		for (String str : splittedStrs) {
			sum += Integer.valueOf(str);
		}
		return sum;
	}

}
