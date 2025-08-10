package com.kas.dsasupreme.BinarySearchTree;

public class Lect70_2_kth_small_large_BST {

/*	not working
  static int kthSmallInBst(TreeNode root, int count, int k) {
		if (root == null)
			return -1;

		// In order
		//L
		int left = kthSmallInBst(root.left, count, k);

		//N
		if (left != -1)
			return left;
		count++;
		
		if (count == k)
			return root.val;
		//R
		return kthSmallInBst(root.right, count, k);

	}
*/
	static int ans;
	static int c = 0;
  static void kthSmallInBst(TreeNode root, int count, int k) {
		if (root == null)
			return;

		// In order
		//L
		kthSmallInBst(root.left, count, k);

		//N
		//if (left != -1)
			//return left;
		c++;
		
		if (c == k)
			ans = root.val;
		//R
		kthSmallInBst(root.right, count, k);

	}
 
	
	/*working
	public int count = 0;
    public boolean found;
    public int res;
    public int kthSmallest(TreeNode root, int k) {
        if(root==null){
            return 0;
        }
        if(!found){
            res = kthSmallest(root.left, k);
        } 
        count = count+1;
        if(count ==k){
            found = true;
            return root.val;
        }
        if(!found){
            res = kthSmallest(root.right, k);
        }         
        return res;
    }
	 */
	public static void main(String[] args) {
		int[] element = new int[] {5,3,6,2,4,1};
		TreeNode root = createBst(element);
		// here integer.max_val not work for last no. of int
		kthSmallInBst(root, 0, 3);
		System.out.println(ans);

	}



	static TreeNode insertInBst(TreeNode node, int data) {
		if (node == null) {
			node = new TreeNode(data, null, null);
			return node;
		}

		if (data < node.val) {
			node.left = insertInBst(node.left, data);
		}
		if (data > node.val) {
			node.right = insertInBst(node.right, data);
			;
		}
		return node;

	}

	// 1. builde tree
	static TreeNode createBst(int[] element) {

		TreeNode root = null;

		for (int i = 0; i < element.length; i++) {
			root = insertInBst(root, element[i]);
		}
		return root;

	}
}