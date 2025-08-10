package com.kas.dsasupreme._5_Char_Arrays_Strings._2_Char_Arrays_Strings_Class_2;
class _2_RemoveAllOccurrencesofaSubstring_LC1910 {
    public static String removeOccurrences(String s, String part) {
        StringBuilder sb = new StringBuilder(s);
        int pos = sb.indexOf(part);
        System.out.println("pos1"+pos);
        while(pos != -1){

            sb.delete(pos,pos + part.length());
            System.out.println(sb);
            pos = sb.indexOf(part); 
            System.out.println(pos);
        }
        return sb.toString();
    }
    public static void main(String[] args) {
		String s = "daabcbaabcbc",part = "abc"; //dab
		System.out.println(removeOccurrences(s,part));
	}
}