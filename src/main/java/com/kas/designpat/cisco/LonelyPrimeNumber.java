package com.kas.designpat.cisco;

import java.util.*; 
 
public class LonelyPrimeNumber { 
    public static void main(String[] args) { 
       
        String a = "12,3,4,5,5,4,3,2,2,21,23,40,7,6,4,7"; 
        String[] arr = a.split(","); 
          
        int[] numArray = new int[arr.length]; 
        int numPointer = 0; 
         
        for(String i: arr) { 
            numArray[numPointer] = Integer.valueOf(i); 
            numPointer++; 
        } 
         
        Arrays.sort(numArray); 
         //[2, 2, 3, 3, 4, 4, 4, 5, 5, 6, 7, 7, 12, 21, 23, 40]
        for(int i=0;i<numArray.length;i++) { 
           
          if(numArray[i]!= 0) { 
          int iCount = 0; 
          for(int j=0;j<numArray.length;j++) { 
             
            int equalElement = 0; 
           
            if(i ==j ) { 
              if(numArray[i] == numArray[j] ){ 
              equalElement = numArray[j]; 
              iCount++; 
             } 
            } 
            else {  
              if(numArray[i] == numArray[j]){ 
              equalElement = numArray[j]; 
              iCount++; 
              numArray[j] = 0; 
             } 
            } 
          } 
           
          if(iCount == 1) { 
            System.out.println("iCount = "+iCount); 
              int normCount = 0; 
              int k = 1; 
              int mayBePrime = numArray[i]; 
               
              while(mayBePrime >= k) { 
                if(mayBePrime%k == 0) { 
                  normCount++; 
                } 
                k++; 
              } 
               
              if(normCount == 2) { 
                System.out.println("mayBePrime = "+mayBePrime); 
              } 
          } 
          numArray[i] =0; 
        }} 
    } 
} 