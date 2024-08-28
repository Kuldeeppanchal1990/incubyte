package com.incubyte;

public class StringCalculator {

	public int add(String string) {
		if (string.isBlank()) {
			return 0;
		}
		return Integer.valueOf(string);
	}

}
