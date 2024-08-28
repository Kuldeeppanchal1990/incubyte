package com.incubyte;

public class StringCalculator {
	
	private static final String COMMA_DELIMITER = ",";

	public int add(String string) {
		if (string.isBlank()) {
			return 0;
		}
		
		if (string.contains(COMMA_DELIMITER) == false) {
			return Integer.valueOf(string);
		}
		
		String[] splittedStr = string.split(COMMA_DELIMITER);
		int n1 = Integer.valueOf(splittedStr[0]);
		int n2 = Integer.valueOf(splittedStr[1]);
		return n1 + n2;
	}

}
