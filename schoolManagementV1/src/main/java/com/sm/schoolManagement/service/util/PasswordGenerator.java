package com.sm.schoolManagement.service.util;

public class PasswordGenerator {
	public static String generetePassword() {
		String[] numbers = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
		
		String[] lowerCases = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "g", "k", "l", "m", "n", "o", "p", "k",
				"r", "s", "t", "u", "v", "w", "x", "y", "z" };
	
		String[] upperCases = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "G", "K", "L", "M", "N", "O", "P", "K",
				"R", "S", "T", "U", "V", "W", "X", "Y", "Z" };
		
		String[] symbols = { "?", "@", "#", "$", "%", "!", "*", "_" };
		
		String[] result = joinArray(numbers, lowerCases, upperCases, symbols);
		
		String pwd = "";
		for(int i = 0;i<8;i++) {
			pwd += result[(int) Math.floor(69*(1-Math.random()))];
		}
		
		return pwd;
	}

	static String[] joinArray(String[]... arrays) {
		int length = 0;
		for (String[] array : arrays) {
			length += array.length;
		}

		final String[] result = new String[length];

		int offset = 0;
		for (String[] array : arrays) {
			System.arraycopy(array, 0, result, offset, array.length);
			offset += array.length;
		}
		return result;
	}

}
