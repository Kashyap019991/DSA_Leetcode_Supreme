package com.kas.designpat.Factory2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class OddString {
	public static String generateOddString(int N) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        List<Character> result = new ArrayList<>();
        for (char c : alphabet.toCharArray()) {
            if ((N - result.size()) % 2 == 1) {
                result.add(c);
            } else if ((N - result.size()) % 4 == 0) {
                result.add(c);
                result.add(c);
            }
        }
        Collections.shuffle(result, new Random());
        StringBuilder sb = new StringBuilder();
        for (char c : result.subList(0, N)) {
            sb.append(c);
        }
        return sb.toString();
    }
    public static void main(String[] args) {
		System.out.println(generateOddString(5));
	}
}