package com.kas.designpat.extra;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.LongStream;

class ExceptionHandling {

	public static void main(String[] args) {
		System.out.println(getDisplayName());
	}

	public static String getDisplayName() {
		try {
			return "a";
		} catch (Exception e) {
			return "b";
		} finally {
			return "c";
		}
	}
}

// factorial using java 8
class Scratch {
	public static long factorialStreams(long n) {
		return LongStream.rangeClosed(2, n).reduce(1, (long a, long b) -> a * b);
	}
}

// error at compile time
/*
 * class Base { public void method() throws RuntimeException{
 * System.out.println("Base class method"); } }
 * 
 * class Child extends Base{ public void method() throws Exception{
 * System.out.println("Child class method"); } }
 * 
 * class MainClass{ public static void main(String[] args) { Child c = new
 * Child(); c.method(); } }
 */

// singleton
class SingletonB {

	private SingletonB() {
	}

	static class  Helper11
	{
		 private final static SingletonB INSTANCE1 = new SingletonB();
	//private static final  Singleton11 s11 = new Singleton11();
	}

	public static SingletonB getInstnce() {
		return Helper11.INSTANCE1;
	}// topic

}

/*
 * BlockingQueue: is a java Queue that support operations that wait for the
 * queue to become non-empty when retrieving and removing an element, and wait
 * for space to become available in the queue when adding an element.
 *
 * A thread-safe class is a class that guarantees the internal state of the
 * class as well as returned values from methods, are correct while invoked
 * concurrently from multiple threads.
 */
public class Test {
	public static void main(String[] args) {
		String s1 = "HELLO";
		String s2 = "HELLO";
		String s3 = new String("HELLO");

		System.out.println(s1 == s2); // true
		System.out.println(s1 == s3);// false
		System.out.println(s1.equals(s2)); // true
		System.out.println(s1.equals(s3)); // true

		String s11 = new String("Hi There");
		String s21 = new String("Hi There");
		System.out.println(s11 == s21); // false
		ExceptionHandling ex = new ExceptionHandling();
		ex.main(new String[] { "abc" });

		System.out.println(Scratch.factorialStreams(3));

		HashMap<String, String> map = new HashMap<>();
		map.put(new String("a"), "audi");
		map.put(new String("a"), "ferrari");
		System.out.println(map); // ferrari

		Map<Integer, String> m = new TreeMap<>();
		m.put(11, "A");
		m.put(11, "B");
		//m.put(null, "C"); // NPE
		//System.out.println(m.size());
		
		System.out.println(SingletonB.getInstnce());
		System.out.println(SingletonB.getInstnce());
		
	}
}