package com.kas.designpat.cisco;
//

//https://programs.programmingoneonone.com/2021/02/hackerrank-java-anagrams-solution.html?m=1
public class Anagram {

    /*static boolean isAnagram(String s1, String s2) {
        // Complete the function
        s1=s1.toLowerCase();
        s2=s2.toLowerCase();
        
        if(s1.length()==s2.length())

        {
            int[] a = new int[256];
            int[] b = new int[256];
            for (int i = 0; i < s1.length(); i++) {
                a[(int) s1.charAt(i)] += 1;
                b[(int) s2.charAt(i)] += 1;
            }
            for (int i = 0; i < 256; i++) {
                if (a[i] != b[i])
                    return false;

            }
            return true;
        }
        else
        {
            return false;
        }
    }*/
    public static long getTime(String s) {
    // Write your code here
    
        long totalTime = 0;
        
        int currInd =0 ;
        
        for(int i =0 ;i< s.length();i++){
            
            //find index of ith char
            int ind = (int)s.charAt(i) - 65;
            
            //calc absolute difference bet index and currIndex
            int absDiff = Math.abs(currInd - ind);
            
            //substarct 26 to get anti-clock from clock wise
            int antiClock = 26 - Math.abs(currInd - ind);
            
            //if(absDiff < antiClock)
                totalTime += Math.min(absDiff,antiClock);
            //else
                //totalTime += antiClock;
            //totalTime++;
            currInd = (int)s.charAt(i) -65;
        }
    return totalTime;
    }
    public static void main(String[] args) {
    
       /* Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();*/
        //boolean ret = isAnagram(a, b);
    	System.out.println(getTime("BZA"));
       // System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}
