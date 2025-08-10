package com.kas.designpat.extra;

public class LongestSubstrinWithOutReatingCHar {

	public static void main(String[] args) {
		String s = "abcabad";
		//String s = "abdefgabef";
		int maxLength = 0;
		StringBuilder maxSb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
				StringBuilder sb = new StringBuilder();
				for(int j=i;j<s.length();j++){
					//check if char available in sb or not
					if(sb.indexOf(String.valueOf(s.charAt(j))) != -1){
						break;
					}
					sb.append(s.charAt(j));
				}
				//maxLength = Math.max(sb.length(), maxLength);
				if(sb.length() >= maxSb.length())
				{
					maxSb = sb;
				}
		}
		System.out.println(maxSb +"  "+maxSb.length());
	}

}
