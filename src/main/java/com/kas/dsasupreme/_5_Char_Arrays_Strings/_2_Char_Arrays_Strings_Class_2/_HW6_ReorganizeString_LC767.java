package com.kas.dsasupreme._5_Char_Arrays_Strings._2_Char_Arrays_Strings_Class_2;

import java.util.Arrays;

class _HW6_ReorganizeString_LC767 {
    
    public String reorganizeString(String s) {
    	//StringBuilder ans = new StringBuilder(s);     
        //first find most occured character with count
        int[] hash = new int[26];
        //Arrays.fill(hash,0);
        //iterate each char in str and store count in hash
        for(int i=0;i<s.length();i++){
            //99 -97 =2 //converting 0 based indexing
            hash[s.charAt(i) - 'a']++;
        } //O(n)

        //find max char with count from hash
        char max_count_ch = '\0';
        int max_count = Integer.MIN_VALUE;

        for(int i=0;i<hash.length;i++){
            if(max_count < hash[i])
            {
                max_count = hash[i];
                max_count_ch = (char)(i + 'a');
            }
        }
        
        // if(hash[max_count_ch -'a'] != 0) //not possible to put in one go
        //     return "";
        if (max_count > (s.length() + 1) / 2) {
            return ""; 
        }

        //put maxcount char in ans with +2 gap index in one go
        int index =0;
        while(index < s.length() && hash[max_count_ch - 'a'] >0)//freq >0
        {
            //https://www.baeldung.com/java-add-character- to-string ans.insert(index,max_count_ch); its for inserting not replacing

//https://www.techiedelight.com/replace-character-specific-index-java-string/
            //ans.setCharAt(index,max_count_ch);

            s = s.substring(0,index) + max_count_ch +  s.substring(index+1);
            //System.out.println(max_count_ch + " ..." );
            
            
            hash[max_count_ch - 'a']--; //hash freq --
            index += 2; //incr count by 2 bcoz need to put at non adjacent ind

        }
     
        
        //Now, put remaining character in ans
        for(int i = 0; i< hash.length; i++){
            while(hash[i] > 0){//put one by one all char freq
                index  = (index < s.length()) ? index : 1;
                //ans.setCharAt(index,(char)(i +'a'));
                //ans.insert(index, (char)(i +'a'));
                s = s.substring(0,index) + (char)(i +'a') +  s.substring(index+1);
               // System.out.println(i+'a');
                //System.out.println(index);
                index += 2;
                hash[i]--;
            }
        }
    return s;
}
    
}