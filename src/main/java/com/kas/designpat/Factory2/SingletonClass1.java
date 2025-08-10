package com.kas.designpat.Factory2;

class SingletonClasss{
	private SingletonClasss(){}
	// static inner class - inner classes are not loaded until they are
    // referenced.
	private static class Instance{ 
		final static SingletonClasss sc = new SingletonClasss();	
	}
	// global access point
	public static SingletonClasss getInstantce(){
		return Instance.sc;
	}
	

}
public class SingletonClass1 {
	public static void main(String[] args) {
		System.out.println(SingletonClasss.getInstantce().hashCode());
		System.out.println(SingletonClasss.getInstantce().hashCode());
		/*SingletonClasss s = new SingletonClasss();
		System.out.println(s.hashCode());*/
	}
}
