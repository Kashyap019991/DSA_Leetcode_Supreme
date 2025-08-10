package com.kas.designpat.Factory2;

class Parent{
	void play(){
		System.out.println("Parent Play");
	}
	static void  splay(){
		System.out.println("static parent play");
	}
}

class Child extends Parent{
	void play(){
		System.out.println("Child Play");
	}
	
	static void  splay(){
		System.out.println("static child play");
	}
	
	void onlyInChild(){
		System.out.println("only in child");
	}
}
public class ParentChildPlay {
	
	public static void main(String[] args) {
		Parent p = new Parent();
		p.play(); //Parent play
		Child c = new Child();
		c.play(); //Child play
		c.splay();//Static Child Play
		Parent p1 =new Child();
		p1.play();//Child Play
		p1.splay();//static parent play
		((Child) p1).onlyInChild();
		//Child c1 = (Child) new Parent();
		//c1.play();//Exception in thread "main" java.lang.ClassCastException: com.psmk.designpatrn.Factory2.Parent cannot be cast to com.psmk.designpatrn.Factory2.Child
	//at com.psmk.designpatrn.Factory2.ParentChildPlay.main(ParentChildPlay.java:23)
		
	}
	
}
