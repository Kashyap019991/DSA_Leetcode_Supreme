package com.kas.dsasupreme.extra_classes;

class HappyNo {
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();


        while(n != 1 && !seen.contains(n))
        {
            seen.add(n);

            int sum=0;
            while(n != 0){
                int digit = n%10;
                sum += digit * digit;
                n /=10;
            }

                n=sum;
        }
        return n==1;
    }
}


/*
Input: n = 19
Output: true
Explanation:
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
*/