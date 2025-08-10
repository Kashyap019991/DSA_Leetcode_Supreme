package com.kas.designpat.cisco;

class P{
	static void marry(){
		System.out.println("parent marry");
	}
}
public class C extends P {
			static void marry(){
				System.out.println("chiled marry");
			}
			public static void main(String[] args) {
				P p1 = new C();
				p1.marry();
				
				//for(int i = 0; i < 1; i++)
				{
		            System.out.println(2+' '); // 0 unicode space
		        }
			}
}
