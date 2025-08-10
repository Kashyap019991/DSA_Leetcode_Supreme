package com.kas.dsasupreme._5_Char_Arrays_Strings._2_Char_Arrays_Strings_Class_2;

import java.util.Arrays;

class _HW917_StringCompression_LC443 {
	public static int compress(char[] chars) {

		int index = 0;
		char prev = chars[0];
		int count = 1;
		for (int i = 1; i < chars.length; i++) {
			// check curr and prev char matched
			if (chars[i] == prev) {
				count++;

			} else {
				chars[index++] = prev;
				if (count > 1)
				{
					String str = String.valueOf(count);
		            for (int k = 0; k < str.length(); k++)
		                chars[index++] = str.charAt(k);
					//	chars[index++] = String.valueOf(count).charAt(0);
					/*int start =index;
					while(count >1){
						chars[index++] = String.valueOf((count % 10)).charAt(0);
						count /= 10;
					}
					int temp = index;
					while(start > temp){
						char t = chars[start ] ;
						chars[start] = chars[temp];
						chars[temp] = t;
						start ++; temp--;
					}*/
				}
				count = 1;
			}
			prev = chars[i];
		}
		chars[index++] = prev;
		if (count > 1)
			{
			String str = Integer.toString(count);
            for (int k = 0; k < str.length(); k++)
                chars[index++] = str.charAt(k);
			//chars[index++] = String.valueOf(count).charAt(0); // put count at
			/*int start =index;
			while(count >=1){
				chars[index++] = String.valueOf((count % 10)).charAt(0);
				count /= 10;
			}
			int temp = index-1;
			while(start < temp){
				char t = chars[start ] ;
				chars[start] = chars[temp];
				chars[temp] = t;
				start ++; temp--;
			}*/
			}
																// index
		System.out.println(Arrays.toString(chars));
		return index;
	}

	public static void main(String[] args) {
		//System.out.println(compress(new char[] { 'a', 'a', 'b', 'b', 'c', 'c', 'c' }));
		System.out.println(compress(new char[] { 'a', 'a', 'c', 'c', 'c' ,'c', 'c', 'c' ,'c', 'c', 'c' ,'c', 'c', 'c' }));
	}
}