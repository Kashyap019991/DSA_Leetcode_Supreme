package com.kas.designpat.cisco;
//https://leetcode.com/discuss/interview-question/1747121/java-question
import java.util.*;

interface MyList {
	void convert(String[] a);

	void replace(int idx);

	ArrayList<String> compact();
}
class InvalidStringException extends Exception {
	public InvalidStringException(String s){
		super(s);
	}
}
/*
 * Write the implementation of the InvalidStringException and the ArrayToList
 * classes Model strings for cut and paste: I have added the string: {string} at
 * the index: {index} I have replaced the string: {string} with a null string
 */
class ArrayToList implements MyList {
	ArrayList<String> al;
	
	public ArrayToList(){
		al = new ArrayList<String>();
	}
	@Override
	public void convert(String[] a) {
		// TODO Auto-generated method stub
		for(int i=0;i<a.length;i++){
			al.add(a[i]);
			System.out.println("I have added Sting" + a[i] + " at index:" + i);
		}
	}

	@Override
	public void replace(int idx) {
		// TODO Auto-generated method stub
		String str = this.al.get(idx);
		al.set(idx, "");
		//System.out.println("I Have replced String"+ str +" with null String");
		System.out.printf("I have replaced the string: %s with a null string.", str);
	}

	@Override
	public ArrayList<String> compact() {
		// TODO Auto-generated method stub
		al.remove("");
		return al;
	}

}

public class ArraytoArrayList {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Random rand = new Random(0);

		int n = Integer.parseInt(sc.nextLine());
		String[] a = new String[n];

		for (int i = 0; i < n; i++)
			a[i] = sc.nextLine();

		MyList obj = new ArrayToList();

		obj.convert(a);
		int x = rand.nextInt(n);
		for (int i = 0; i < x; i++)
			obj.replace(rand.nextInt(n));

		ArrayList<String> s = obj.compact();

		for (int i = 0; i < s.size(); i++) {
			if (!(s.get(i).charAt(0) >= 97) || !(s.get(i).charAt(0) <= 122)) {
				try {
					throw new InvalidStringException("This is an invalid string");
				} catch (InvalidStringException e) {
					System.out.println(e.getMessage());
				}
			}
		}

	}
}