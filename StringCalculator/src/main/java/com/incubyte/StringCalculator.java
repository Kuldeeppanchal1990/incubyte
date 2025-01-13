package com.incubyte;

public class StringCalculator {

	private static final String COMMA_DELIMITER = ",";
	private static final String NEW_LINE_DELIMITER = "\n";
	private static final String STAR_DELIMITER = "*";
	private static final String CUSTOM_DELIMITER_INDICATOR_START = "//";
	private static final String MULTIPLICATION_INDICATOR = "//*\n";

	public int calculate(String inputString) {
		if (inputString.isBlank()) {
			return 0;
		}

		if (inputString.contains(COMMA_DELIMITER) == false && inputString.contains(NEW_LINE_DELIMITER) == false) {
			return Integer.valueOf(inputString);
		}

		String[] splittedStrings = splitInputString(inputString);

		if (inputString.startsWith(MULTIPLICATION_INDICATOR)) {
			return multiply(splittedStrings);
		} else {
			return add(splittedStrings);
		}
	}

	public int add(String[] splittedStrings) {
		int sum = 0;
		String negNos = "";
		for (String str : splittedStrings) {
			int number = Integer.valueOf(str);
			if (number < 0) {
				negNos += "," + number;
			}
			sum += number;
		}

		validateNegativeNumbers(negNos);
		return sum;
	}

	public int multiply(String[] splittedStrings) {
		int multiply = 1;
		String negNos = "";
		for (String str : splittedStrings) {
			int number = Integer.valueOf(str);
			if (number < 0) {
				negNos += "," + number;
			}
			multiply *= number;
		}

		validateNegativeNumbers(negNos);
		return multiply;
	}

	private void validateNegativeNumbers(String negNos) {
		if (negNos.length() > 0) {
			throw new IllegalArgumentException("negative numbers not allowed " + negNos.substring(1));
		}
	}

	private String[] splitInputString(String inputString) {
		String delimiter = COMMA_DELIMITER + "|" + NEW_LINE_DELIMITER;

		if (inputString.startsWith(CUSTOM_DELIMITER_INDICATOR_START)) {
			String[] delimiterAndInputStr = inputString.split(NEW_LINE_DELIMITER, 2);
			delimiter = delimiterAndInputStr[0].substring(CUSTOM_DELIMITER_INDICATOR_START.length());
			inputString = delimiterAndInputStr[1];
		}
		if (delimiter.equals(STAR_DELIMITER)) {
			return inputString.split("\\" + delimiter);
		}
		return inputString.split(delimiter);
	}

}
