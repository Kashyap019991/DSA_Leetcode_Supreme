package com.kas.practice_javadsa;
class Duplicate_Zeros_1089 {
    public void duplicateZeros(int[] arr) {
         int zeros = 0;
    int n = arr.length;

        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                zeros++;
            }
        }

            for (int i = n - 1; i >= 0; i--) {
            // Check if the element can fit in the array after duplication
                    if (i + zeros < n) {
                        arr[i + zeros] = arr[i];
                    }

            // Duplicate zero if the element is zero
                    if (arr[i] == 0) {
                        zeros--;  // One zero handled, reduce the count
                        if (i + zeros < n) {
                            arr[i + zeros] = 0;  // Place an extra zero
                        }
                    }
        }
    }
    public static void main(String[] args) {
		int[] arr= {1,0,2,3,0,4,5,0};
		//o/p: 1,0,0,2,3,0,0,4
		Duplicate_Zeros_1089 dpl =  new Duplicate_Zeros_1089();
		dpl.duplicateZeros(arr);
	}
}