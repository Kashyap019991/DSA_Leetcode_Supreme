package com.kas.dsasupreme.extra_classes;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class lengthEncodeStr {

	public static void main(String[] args) {
		
		/*String s = "aabbcccbb";
		char[] a = s.toCharArray();
		int counter =1;
		
		if(s.isEmpty()){System.out.println("empty");return;}
		char prev = a[0];
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<a.length;i++){
			if(prev == a[i]) counter++;
			else{
				sb.append(prev).append(counter);
				counter =1;
			}
			prev = a[i];
		}
		sb.append(prev).append(counter);
		System.out.println(sb);*/
		ArrayList<Integer> al = new ArrayList<Integer>();
		ArrayList<Integer> out = new ArrayList<Integer>();
		al.add(13);al.add(12);al.add(14);al.add(11);al.add(16);al.add(19);
		ArrayList<Integer> al1 = (ArrayList<Integer>) al.stream().sorted().collect(Collectors.toList());
		int diff =0;
		System.out.println(al1);
		for(int i =1 ; i<al1.size();i++){
			
			if(al1.get(i-1)+1 != al1.get(i)){
				//16-14 =2 14+1 	
				//19-16 =3 16+1,16+2 
						diff =  al1.get(i) - al1.get(i-1);
				
				for(int j=1;j<diff;j++){
					out.add(al1.get(i-1) + j);
				}
			}
		}
		
		System.out.println(out);
		
		
}
}