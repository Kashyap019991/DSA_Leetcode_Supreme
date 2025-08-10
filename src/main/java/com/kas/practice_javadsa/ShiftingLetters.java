package com.kas.practice_javadsa;
class ShiftingLetters {
    public String shiftingLetters(String s, int[] shifts) {
        int totShifts  = 0;

        for(int shft:shifts)
            totShifts += shft%26;
        StringBuilder shifted = new StringBuilder();
        for(int i=0;i<s.length();i++){
            int ind = (s.charAt(i) -'a') +totShifts;
            shifted.append((char)(ind%26+97));
            totShifts = Math.floorMod(totShifts - shifts[i],26);
        }
        return shifted.toString();
    }
    public static void main(String[] args) {
		String s = "ktmq";
		int[] shifts = {10,26,8,2};
		ShiftingLetters sl = new ShiftingLetters();
		System.out.println(sl.shiftingLetters(s, shifts));
	}
}