package com.kas.practice_javadsa;
class TrieNodeXOR {
    TrieNodeXOR[] children = new TrieNodeXOR[2];
}

class xormax {
    public int findMaximumXOR(int[] nums) {
        int maxNum = nums[0];
        for (int num: nums) {
            maxNum = Math.max(maxNum, num);
        }
        
        int L = (Integer.toBinaryString(maxNum)).length();
        int maxXor = 0;

        TrieNodeXOR root = new TrieNodeXOR();
        for (int num: nums) {
            TrieNodeXOR node = root, xorNode = root;
            int currXor = 0;
            
            for (int i = L - 1; i >= 0; i--) {
                int bit = (num >> i) & 1;
                int toggledBit = bit ^ 1;
                
                if (node.children[bit] == null) {
                    TrieNodeXOR newNode = new TrieNodeXOR();
                    node.children[bit] = newNode;
                }
                node = node.children[bit];
                
                if (xorNode.children[toggledBit] != null) {
                    currXor |= (1 << i);
                    xorNode = xorNode.children[toggledBit];
                } else {
                    xorNode = xorNode.children[bit];
                }
            }
            maxXor = Math.max(maxXor, currXor);
        }
        
        return maxXor;
    }
    public static void main(String[] args) {
		int[] nums = {3,10,5,25,2,8};
		xormax sl1 = new xormax();
		System.out.println(sl1.findMaximumXOR(nums));
	}
}