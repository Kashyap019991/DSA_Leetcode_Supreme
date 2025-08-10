package com.kas.designpat.extra;

class Singleton1 {
private Singleton1() {
}

	private static class Helper {
		private static final Singleton1 s = new Singleton1();
	}

	public static Singleton1 getInstance() {
		return Helper.s;
	}

}

public class Singleton {

	public static void main(String[] args) {
		System.out.println(Singleton1.getInstance());
		System.out.println(Singleton1.getInstance());
	}
}
