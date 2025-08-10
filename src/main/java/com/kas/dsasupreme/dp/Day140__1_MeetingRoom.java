package com.kas.dsasupreme.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//Count Min no of op to convert string a to b
public class Day140__1_MeetingRoom {
	
	static int maxMeetGreedy(int[] start, int[] end, int n) {
		List<List<Integer>> meetings = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			meetings.add(Arrays.asList(start[i], end[i]));
		}

		Collections.sort(meetings, new Comparator<List<Integer>>() {
			@Override
			public int compare(List<Integer> o1, List<Integer> o2) {

				return o1.get(1).compareTo(o2.get(1));
			}
		});
		int count = 1;
		int ansEndingTime = meetings.get(0).get(1);
		for (int i = 1; i < meetings.size(); i++) {
			if (meetings.get(i).get(0) > ansEndingTime) {
				count++;
				ansEndingTime = meetings.get(i).get(1);
			}
		}
		System.out.println(meetings);
		return count;
	}

	public static void main(String[] args) {
		int[] start = new int[] { 1, 0, 3, 5, 8, 5 };
		int[] end = new int[] { 2, 6, 4, 7, 9, 9 };
		int n = 6;
		System.out.println(maxMeetGreedy(start, end, n));
	}
}
