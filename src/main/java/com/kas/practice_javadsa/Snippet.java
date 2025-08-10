package com.kas.practice_javadsa;

public class Snippet {
	public static void main(String[] args) {
	        String [] arr={"bd","abcde","abcfe","abde"};
	        //find the most common prefix 
			
			//abd-> a,ab,abd map<abd,List<String>>
			String ans = "";boolean f =false;
			StringBuilder sb = new StringBuilder();
			for(int k=0;k< arr[0].length();k++){
				char[] s= arr[0].toCharArray();
				int i=1;
				while(i<arr.length){
					char s1[] = arr[i].toCharArray();
						if(s[k] == s1[k] && k<s1.length){
							i++;
							
						}	
						else
							break;
						if(i==arr.length)
						{
							f=true;
						}
						
				}
				if(f==true) {
					sb.append(s[k]);
					f=false;
				}
			}
			
		System.out.println(sb);	
	    }

	 
}

