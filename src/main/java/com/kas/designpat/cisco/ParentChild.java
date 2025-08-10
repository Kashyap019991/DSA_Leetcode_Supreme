package com.kas.designpat.cisco;

class Employee1{
	 static void test(){
	System.out.println("I am employee");
	}

}

class Staff extends Employee1{
	 static void test(){
		System.out.println("I am staff");
	}

}
public class ParentChild { 
    public static void main(String[] args) { 
    	Employee1 e  = new Staff(); 
    	//staff method
    	e.test();
    	
 //   	Staff s = (Staff) new Employee1();
 //   	s.test();
    	Staff s = new Staff();
    	s.test();// i am staff

    	//Staff s = new Employee();
    }
    	
	/*
	 * // Implement your solution here String S ="50552"; int mx =
	 * Integer.MIN_VALUE; try{ for(int i=0;i<S.length() -1;i++) { mx = Math.max(mx,
	 * Integer.parseInt(S.substring(i,i+2))); } } catch(Exception e){} //return mx;
	 * 
	 */  
}