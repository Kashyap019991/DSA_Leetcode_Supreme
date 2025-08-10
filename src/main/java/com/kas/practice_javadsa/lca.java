package com.kas.practice_javadsa;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
class lca {
	static TreeNode ans;
    public boolean lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root == null)
            return false;

        int left = lowestCommonAncestor(root.left,p,q)?1:0;
        int right = lowestCommonAncestor(root.right,p,q)?1:0;
        
        
        int mid = (root.val == p.val ||root.val == q.val)?1:0;
        if(right+mid+left >=2)
            ans = root;
        return mid+left+right >0;
        
    }
    public static void main(String[] args) {
    	TreeNode t = new TreeNode(1);
    	t.right = new TreeNode(5);
    	t.left = new TreeNode(3);
    	
    	int p = 5;int q = 3;
    	lca s = new lca();
    	s.lowestCommonAncestor(t, new TreeNode(p), new TreeNode(q));
    	System.out.println(ans.val);
    			
    
	}
}