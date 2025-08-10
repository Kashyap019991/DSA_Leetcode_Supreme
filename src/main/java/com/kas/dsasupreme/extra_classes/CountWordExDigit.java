package com.kas.dsasupreme.extra_classes;

import java.util.Arrays;

public class CountWordExDigit {

	public static void main(String[] args) {
		String s = "ab2c 12x";

		String[] s1 = s.split(" ");
		System.out.println(Arrays.toString(s1));
		int count = 0;
		for (String s2 : s1) {
			char[] ch = s2.toCharArray();
			/*
			 * if(!s2.matches("" + "\\d.*")){ count++; }
			 */
			boolean word = true;
			for (char c : ch) {
				if (Character.isDigit(c)) {
					word = false;
					break;

				}

			}
			if (word == true)
				count++;

		}
		System.out.println(count);
	}
}
