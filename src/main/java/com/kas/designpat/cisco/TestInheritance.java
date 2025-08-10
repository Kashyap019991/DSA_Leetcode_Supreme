package com.kas.designpat.cisco;

class TestInheritance {
	public  void m1(){
			System.out.println("M1 in TestInheritance");
	}
	
	public static void main(String[] args) {
		TestInheritance ref  = new TestInheritance();
		ref.m1();
	}
}
class TestInheritance1 extends TestInheritance
{
	public void m1(){
		System.out.println("M1 in 1");
	}
}
