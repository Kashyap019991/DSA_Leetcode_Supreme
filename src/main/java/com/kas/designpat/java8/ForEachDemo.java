package com.kas.designpat.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ForEachDemo {

	// filter----> conditional check

	public static void main(String[] args) {

		List<String> list = new ArrayList<>();
		list.add("Murrit");
		list.add("john");
		list.add("piter");
		list.add("marek");
		list.add("mac");

		for (String s : list) {
			if (s.startsWith("m")) {
				System.out.println(s);
			}
		}
		System.out.println(list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));
		list.stream().filter(t -> t.startsWith("m")).forEach(t -> System.out.println("K" +t));
		
		Map<Integer, String> map = new HashMap<>();

		map.put(1, "a");
		map.put(2, "b");
		map.put(3, "c");
		map.put(4, "d");
		map.put(4,"e");
		map.entrySet().forEach(obj -> System.out.println(obj));
		/*
		 * map.forEach((key,value)->System.out.println(key+": "+value));*/
		//map.entrySet().stream().filter(k->k.getKey()%2 ==0).forEach(obj->System.out.println(obj));
		  map.entrySet().stream().filter(k->k.getKey()%2==0).forEach(obj->System.out.println(obj));
		 System.out.println("map111.");
		  map.entrySet().stream().filter(m -> m.getValue().equals("b")).forEach(obj->System.out.println(obj));
		  System.out.println("map111.");
		/*
		 * Consumer<String> consumer=(t)->System.out.println(t); for(String s1:list) {
		 * consumer.accept(s1); }
		 */
		  int[] array = new int[]{1,2,3,2,1,1};
		  Long result = Arrays.stream(array)
				  .boxed()
				  .collect(Collectors.groupingBy(i -> i, Collectors.counting()))
				  .values()
	               .stream()
	               .max(Comparator.comparing(Function.identity())).orElse(0L);
		 System.out.println("count: "+result);
		 
		 
		 List<Integer> ls = Arrays.asList(2,3,4,5);
		 Integer max = ls.stream().mapToInt(k->k).max().orElseThrow(NoSuchElementException::new);
		 //Person minByAge = people
	     // .stream()
	     // .min(Comparator.comparing(Person::getAge))
	     // .orElseThrow(NoSuchElementException::new);
		 
	}
}