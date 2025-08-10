package com.kas.practice_javadsa;
class ClearFigits {
    public String clearDigits(String s) {
        StringBuilder ans= new StringBuilder();
        for(char c: s.toCharArray()) {
            if(Character.isDigit(c)) {
                if (ans.length() > 0) {
                    ans.deleteCharAt(ans.length()-1);
                } 
            } else {
                ans.append(c);
            }
        }
        return ans.toString();
    }
    public static void main(String[] args) {
		ClearFigits sl = new ClearFigits();
		sl.clearDigits("ab34cd");
	}
}