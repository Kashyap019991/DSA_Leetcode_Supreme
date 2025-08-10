package com.kas.dsasupreme.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;

public class TreeDay2 {
	static int height(TreeNode node) {
		if (node == null)
			return 0;

		int lh = height(node.left);
		int rh = height(node.right);

		int h = 1 + max(lh, rh);
		return h;
	}

	static int max(int lh, int lr) {
		if (lh > lr)
			return lh;
		else
			return lr;

	}

	static TreeNode buildTree(TreeNode root) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter data:");
		int data = sc.nextInt();
		root = new TreeNode(data);
		if (data == -1)
			return null;
		// 1 3 7 -1 -1 11 -1 -1 5 17 -1 -1 -1
		System.out.println("Enter left of data: " + data);
		root.left = buildTree(root.left);
		System.out.println("Enter right of data: " + data);
		root.right = buildTree(root.right);

		return root;
	}

	static void levelOrderTra(TreeNode root) {
		// 1 3 7
		Queue<TreeNode> q = new LinkedList<>();
		//add root in queue for traversing
		q.add(root);
		
		
		while(!q.isEmpty()) {
		
		
		TreeNode temp = q.peek();
		//remove top element from queue
		q.poll();
		
		System.out.println(temp.val);
		
		//check whether q has left then add it to q
		if(temp.left != null)
			q.add(temp.left);
		
		if(temp.right != null)
			q.add(temp.right);
		
		
		}
	}

	static void preOrder(TreeNode root) {
		if (root == null)
			return;
		System.out.print(" " + root.val);
		preOrder(root.left);
		preOrder(root.right);
	}

	static void inOrder(TreeNode root) {
		if (root == null)
			return;
		inOrder(root.left);
		System.out.print(" " + root.val);
		inOrder(root.right);
	}

	static void postOrder(TreeNode root) {
		if (root == null)
			return;
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(" " + root.val);
	}

	static int count = 0;

	static void countLeafNode(TreeNode root) {
		if (root == null)
			return;

		countLeafNode(root.left);
		if (root.left == null && root.right == null)
			count++;
		countLeafNode(root.right);

	}

	static List<Integer> diameterFast(TreeNode root) {

		if (root == null) {
			List<Integer> ans1 = new ArrayList();
			// d,h
			ans1.add(0);
			ans1.add(0);
			return ans1;
		}

		List<Integer> left = diameterFast(root.left);
		List<Integer> right = diameterFast(root.right);

		int op1 = left.get(0);
		int op2 = right.get(0);
		int op3 = left.get(1) + right.get(1) + 1;

		List<Integer> ans = new ArrayList();
		ans.add(Math.max(op1, Math.max(op2, op3)));
		ans.add(Math.max(left.get(1), right.get(1)) + 1);
		return ans;

	}

	// BruteForce
	static boolean isBalanced(TreeNode root) {
		if (root == null)
			return true;

		boolean leftAns = isBalanced(root.left);
		boolean rightAns = isBalanced(root.left);
		boolean diff = Math.abs(height(root.left) - height(root.right)) <= 1;

		if (leftAns && rightAns && diff)
			return true;
		else
			return false;
	}

	static List<Object> isBalancedFast(TreeNode root) {
		if (root == null) {
			List<Object> ans = new ArrayList<>();
			ans.add(true);
			ans.add(0);
			return ans;
		}

		List<Object> leftAns = isBalancedFast(root.left);
		List<Object> rightAns = isBalancedFast(root.right);

		boolean leftans1 = (boolean) leftAns.get(0);
		boolean rightans1 = (boolean) rightAns.get(0);
		boolean diff = (Math.abs((int) leftAns.get(1) - (int) rightAns.get(1)) <= 1);

		List<Object> ans = new ArrayList<>();

		if (leftans1 && rightans1 && diff)
			ans.add(true);
		else
			ans.add(false);

		ans.add(Math.max((int) leftAns.get(1), (int) rightAns.get(1)) + 1);
		return ans;

	}

	static boolean isIdentical(TreeNode node1, TreeNode node2) {

		if (node1 == null && node2 == null)
			return true;
		if (node1 != null && node2 == null)
			return false;
		if (node1 == null && node2 != null)
			return false;

		Boolean left = isIdentical(node1.left, node2.left);
		Boolean right = isIdentical(node1.right, node2.right);

		if (left && right && (node1.val == node2.val))
			return true;
		else
			return false;

	}

	static List<Object> isSumTree(TreeNode root) {
		if (root == null) {
			List<Object> ans = new ArrayList<>();
			ans.add(true);
			ans.add(0);
			return ans;
		}

		if (root.left == null && root.right == null) {
			List<Object> ans = new ArrayList<>();
			ans.add(true);
			ans.add(root.val);
			return ans;

		}
		/**
		 * 8 T,8 T,6 T,2 3 2 T,1 T,2 1 2
		 */
		List<Object> leftS = isSumTree(root.left);
		List<Object> rightS = isSumTree(root.right);

		boolean leftBS = (boolean) leftS.get(0);
		boolean rightBS = (boolean) rightS.get(0);

		List<Object> ans = new ArrayList<>();

		if (leftBS && rightBS && ((int) leftS.get(1) + (int) rightS.get(1) == root.val)) {
			ans.add(true);

		} else
			ans.add(false);
		ans.add(root.val + (int) leftS.get(1) + (int) rightS.get(1));
		return ans;
	}

	static List<Integer> ZigzagTrav(TreeNode root) {
		List<Integer> ans = new ArrayList<>();
		if (root == null)
			return ans;
		boolean leftToRight = true;
		Queue<TreeNode> q = new LinkedList();
		q.add(root);

		while (!q.isEmpty()) {
			int size = q.size();
			// List<Integer> temp = new ArrayList<>();
			int[] a = new int[size];
			for (int i = 0; i < size; i++) {
				TreeNode front = q.peek();
				q.poll();

				int index = leftToRight ? i : size - i - 1;
				a[index] = front.val;

				if (front.left != null)
					q.add(front.left);
				if (front.right != null)
					q.add(front.right);
			}
			// change direction
			leftToRight = !leftToRight;
			for (int i : a) {
				ans.add(i);
			}
		}

		return ans;

	}

	// BoundryTrav Start
	static List<Integer> ansBr = new ArrayList<>();

	static void traverseLeft(TreeNode root) {
		if (root == null)
			return;
		// checking for leaf node
		if (root.left == null && root.right == null)
			return;
		ansBr.add(root.val);

		if (root.left != null)
			traverseLeft(root.left);
		else
			traverseLeft(root.right);

	}

	static void leafTrav(TreeNode root) {
		if (root == null)
			return;

		// check for leaf
		if (root.left == null && root.right == null) {
			ansBr.add(root.val);
		}
		leafTrav(root.left);
		leafTrav(root.right);
	}

	static void traverseRight(TreeNode root) {
		if (root == null)
			return;
		// check for leaf
		if (root.left == null && root.right == null)
			return;
		ansBr.add(root.val);
		if (root.right != null)
			traverseRight(root.right);
		else
			traverseRight(root.left);

	}

	static void boundryTrav(TreeNode root) {

		if (root != null)
			ansBr.add(root.val);

		traverseLeft(root.left);

		leafTrav(root.left);

		leafTrav(root.right);

		traverseRight(root.right);
	}

	// vertTrav
	static List<Integer> vertTrav(TreeNode root) {
		List<Integer> ans = new ArrayList<>();
		TreeMap<Integer, List<Integer>> nodes = new TreeMap<>();
		Queue<List<Object>> q = new LinkedList<>();
		if (root == null)
			return ans;
		q.add(Arrays.asList(root, 0, 0));

		while (!q.isEmpty()) {
			List<Object> temp = q.peek();
			q.poll();

			TreeNode frontNode = (TreeNode) temp.get(0);
			int hd = (int) temp.get(1);
			int lvl = (int) temp.get(2);

			if (nodes.get(hd) != null)
				nodes.get(hd).add(frontNode.val);
			else
				nodes.put(hd, new ArrayList(Arrays.asList(frontNode.val)));

			if (frontNode.left != null)
				q.add(Arrays.asList(frontNode.left, hd - 1, lvl + 1));
			if (frontNode.right != null)
				q.add(Arrays.asList(frontNode.right, hd + 1, lvl + 1));
		}

		for (Integer key : nodes.keySet())
			ans.addAll(nodes.get(key));
		/*
		 * Iterator<Map.Entry<Integer, List<Integer>>> itr =
		 * nodes.entrySet().iterator();
		 * 
		 * while(itr.hasNext()) { Map.Entry<Integer, List<Integer>> entry =
		 * itr.next(); ans.addAll(entry.getValue()); }
		 */

		return ans;
	}

	// topView BT
	static List<Integer> topViewBt(TreeNode root) {
		List<Integer> ans = new ArrayList();
		TreeMap<Integer, Integer> nodes = new TreeMap();
		Queue<List<Object>> q = new LinkedList();

		if (root == null)
			return ans;

		q.add(Arrays.asList(root, 0));

		while (!q.isEmpty()) {
			List<Object> temp = q.peek();
			q.poll();

			TreeNode frontNode = (TreeNode) temp.get(0);
			int hd = (int) temp.get(1);

			if (nodes.get(hd) == null)
				nodes.put(hd, frontNode.val);

			if (frontNode.left != null)
				q.add(Arrays.asList(frontNode.left, hd - 1));
			if (frontNode.right != null)
				q.add(Arrays.asList(frontNode.right, hd + 1));
		}
		for (Integer key : nodes.keySet())
			ans.add(nodes.get(key));
		return ans;
	}

	// bottomView
	static List<Integer> bottomView(TreeNode root) {
		List<Integer> ans = new ArrayList();
		TreeMap<Integer, Integer> nodes = new TreeMap();
		Queue<List<Object>> q = new LinkedList();
		if (root == null)
			return ans;

		q.add(Arrays.asList(root, 0));

		while (!q.isEmpty()) {
			List<Object> temp = q.peek();
			q.poll();
			TreeNode frontNode = (TreeNode) temp.get(0);
			int hd = (int) temp.get(1);

			nodes.put(hd, frontNode.val);

			if (frontNode.left != null)
				q.add(Arrays.asList(frontNode.left, hd - 1));
			if (frontNode.right != null)
				q.add(Arrays.asList(frontNode.right, hd + 1));

		}

		for (Integer key : nodes.keySet())
			ans.add(nodes.get(key));
		return ans;
	}

	// leftView
	static List<Integer> ansleft = new ArrayList();

	static List<Integer> leftViewBt(TreeNode root, int lvl, List<Integer> ansl) {

		if (root == null)
			return ansl;

		if (lvl == ansl.size())
			ansl.add(root.val);

		leftViewBt(root.left, lvl + 1, ansl);
		leftViewBt(root.right, lvl + 1, ansl);
		return ansl;
	}

	// rightView
	static List<Integer> rightViewBt(TreeNode root, int lvl, List<Integer> ansr) {
		if (root == null)
			return ansr;

		if (lvl == ansr.size())
			ansr.add(root.val);

		rightViewBt(root.right, lvl + 1, ansr);
		rightViewBt(root.left, lvl + 1, ansr);
		return ansr;
	}

	/*
	 * // longest path sum static int maxLenSum = Integer.MIN_VALUE; static int
	 * maxLen = 0;
	 * 
	 * static void longestPathSum(TreeNode root, int len, int sum) {
	 * 
	 * if (root == null) { if (len > maxLen) { maxLen = len; maxLenSum = sum; }
	 * else if (len == maxLen) maxLenSum = Math.max(sum, maxLenSum); return; }
	 * sum = sum + root.val;
	 * 
	 * longestPathSum(root.left, len + 1, sum); longestPathSum(root.right, len +
	 * 1, sum);
	 * 
	 * }
	 */

	// longestPath sum --> Practise
	static int maxPathSum = Integer.MIN_VALUE;
	static int maxHeight = 0;

	static void longestPathSump(TreeNode root, int curHeight, int curSum) {

		if (root == null)
			return;

		curSum = curSum + root.val;
		longestPathSump(root.left, curHeight + 1, curSum);
		longestPathSump(root.right, curHeight + 1, curSum);

		if (curHeight > maxHeight) {
			maxHeight = curHeight;
			maxPathSum = curSum;
		}
		if (curHeight == maxHeight) {
			maxPathSum = Math.max(curSum, maxPathSum);
		}

	}

	// Lowest Common Ancestor LCA
	static TreeNode lowComAnc(TreeNode root, int n1, int n2) {

		if (root == null)
			return null;

		if (root.val == n1 || root.val == n2)
			return root;

		TreeNode leftAns = lowComAnc(root.left, n1, n2);
		TreeNode rightAns = lowComAnc(root.right, n1, n2);

		if (leftAns != null && rightAns != null)
			return root;
		else if (leftAns != null && rightAns == null)
			return leftAns;
		else if (leftAns == null && rightAns != null)
			return rightAns;
		else
			return null;

	}

	// LCAPractice
	static int n11 = 4, n21 = 6;

	static Integer longComAncpr(TreeNode root) {

		if (root == null)
			return null;

		if (root.val == n11 || root.val == n21)
			return root.val;
		Integer leftAns = longComAncpr(root.left);
		Integer rightAns = longComAncpr(root.right);

		if (leftAns != null && rightAns == null)
			return leftAns;
		if (leftAns == null && rightAns != null)
			return rightAns;
		if (leftAns != null && rightAns != null)
			return root.val;
		return null;
	}

	// K-sum path
	static int count1 = 0;
	static int a = 0;
	static List<List<Integer>> ans = new ArrayList<>();
	static List<Integer> paths = new ArrayList<>();

	static void kSum(TreeNode root, int k) {

		if (root == null)
			return;

		paths.add(root.val);

		kSum(root.left, k);
		kSum(root.right, k);
		int sum = 0;

		if (root.left == null && root.right == null) {
			for (int i = paths.size() - 1; i >= 0; i--) {
				sum = sum + paths.get(i);
				List<Integer> ans1 = new ArrayList<>();
				if (sum == k) {
					for (int k1 = i; k1 <= paths.size() - 1; k1++) {
						System.out.print(paths.get(k1) + "  ");
						ans1.add(paths.get(k1));
					}
					ans.add(ans1);
					System.out.println();
					count1++;
				}
			}
		}
		paths.remove(paths.size() - 1);

	}

	// Kth Ancesor
	static int k = 2;

	static TreeNode kAnces(TreeNode root, int n) {
		if (root == null)
			return null;

		if (root.val == n)
			return root;

		TreeNode leftAns = kAnces(root.left, n);
		TreeNode rightAns = kAnces(root.right, n);

		if (leftAns != null && rightAns == null) {
			k--;
			if (k == 0) {
				k = Integer.MAX_VALUE;
				return root;
			}
			return leftAns;
		}
		if (leftAns == null && rightAns != null) {
			k--;
			if (k == 0) {
				k = Integer.MAX_VALUE;
				return root;
			}
			return rightAns;
		}
		return null;
	}

	// Maximum sum of Non Adjecent Node
	static List<Integer> nonAdjMaxSum(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) {
			res.add(0);
			res.add(0);
			return res;
		}

		List<Integer> leftAns = nonAdjMaxSum(root.left);
		List<Integer> rightAns = nonAdjMaxSum(root.right);

		res.add(root.val + leftAns.get(1) + rightAns.get(1));
		res.add(Math.max(leftAns.get(0), leftAns.get(1)) + Math.max(rightAns.get(0), rightAns.get(1)));

		return res;

	}

	public static void main(String[] args) {
		TreeNode t1, t2, t3, t4, t5, t6, t7, t8, t9;
		t4 = new TreeNode(4);
		t7 = new TreeNode(7);
		t3 = new TreeNode(3);
		t6 = new TreeNode(6, t7, null);
		t5 = new TreeNode(5, t6, null);
		t2 = new TreeNode(2, t3, t4);
		t1 = new TreeNode(1, t2, t5);
		// int maxheight = height(t1);
		// System.out.println(maxheight);
		//// 1 3 7 -1 -1 11 -1 -1 5 17 -1 -1 -1
		TreeNode root = null, root1 = null;
		root = buildTree(root);
		System.out.println("level order traversal:  ");
		levelOrderTra(root);
		System.out.println("\nPreorder traversal: ");
		preOrder(root);
		System.out.println("\nInorder traversal: ");
		inOrder(root);
		System.out.println("\nPostorder traversal: ");
		postOrder(root);
		countLeafNode(root);
		System.out.println("Count :" + count);
		List<Integer> ansdm = diameterFast(root);
		System.out.println("Diameter or Tree: " + ansdm.get(0));
		/*
		 * root1 = buildTree(root1); boolean val = isIdentical(root, root1);
		 * System.out.println(val);
		 */

		// isBalanced bruteforce
		System.out.println("BrutForce:  " + isBalanced(root));
		// isbalnced opt
		System.out.println("Optimized: " + isBalancedFast(root).get(0));

		// SumTree
		System.out.println("SumTree:  " + isSumTree(root).get(0));

		// ZigZag
		System.out.println("Zigzag:  " + ZigzagTrav(root));

		// BoundryTrav 1 3 7 -1 -1 11 -1 -1 5 17 -1 -1 -1
		boundryTrav(root);
		System.out.println("Boundry Trav:  " + ansBr);

		// vert Trav
		System.out.println("vertTrav: " + vertTrav(root));

		// topView
		System.out.println("topView: " + topViewBt(root));

		// bottomView
		System.out.println("bottomView: " + bottomView(root));

		// leftView
		List<Integer> ansl = new ArrayList();
		System.out.println("LeftView: " + leftViewBt(root, 0, ansl));

		// rightView
		List<Integer> ansr = new ArrayList();
		System.out.println("RightView: " + rightViewBt(root, 0, ansr));

		// diagonal view same as vertview only change hd
		// left -> hd +1 ,right - hd same

		// Lec 65
		// longest path Sum
		// longestPathSum(root, 0, 0);
		// System.out.println("Longest Path Sum:" + maxLenSum);

		longestPathSump(root, 0, 0);
		System.out.println("longestPathSump-->: " + maxPathSum);

		// LowestCommonAnc
		TreeNode r1 = lowComAnc(root, 4, 2);
		if (r1 != null)
			System.out.println("Lowest Common Ansc: " + r1.val);
		else
			System.out.println("Lowest Common Ansc: " + -1);

		// practice longComANss
		System.out.println("longComANss:-->" + longComAncpr(root));
		// kSum
		List<Integer> paths = new ArrayList<>();
		kSum(root, 6);
		System.out.println("count: " + count1);
		for (List<Integer> an : ans)
			System.out.println("paths: " + an);
		// kth Ances
		int n = 4;
		TreeNode ans = kAnces(root, n);
		// check if node have kth ansces or not, if root is n and k=2 then no
		// ans possible
		if (ans == null)
			System.out.println("Kth Ances: " + -1);
		else if (ans.val == n)
			System.out.println("Kth Ances: " + -1);
		else
			System.out.println("Kth Ances: " + ans.val);

		// non Adj nodes max sum
		List<Integer> ls = nonAdjMaxSum(root);
		System.out.println("Non AdjNode Max Sum: " + Math.max(ls.get(0), ls.get(1)));

		// Lec 66
		// Construct BT from InOrd and PreOrd and print PostOrder
		int[] inOrd = new int[] { 3, 1, 4, 0, 5, 2 };
		int[] preOrd = new int[] { 0, 1, 3, 4, 2, 5 };
		int nSize = 6;
		Map<Integer, Integer> mapIndtoNode = findIndxIn(inOrd, nSize);
		TreeNode resR = constructBtIp(inOrd, preOrd, nSize, 0, 5, mapIndtoNode);
		System.out.print("PostOrder of BT from In and Pre: ");
		postOrder(resR);

		// Construct BT from InOrd and PostOrd and print PostOrder
		int[] inOrd1 = new int[] { 3, 1, 4, 0, 5, 2 };
		int[] postOrd = new int[] { 3, 4, 1, 5, 2, 0 };
		int nSize1 = 6;
		Map<Integer, Integer> mapIndtoNode1 = findIndxIn(inOrd, nSize1);
		TreeNode resR1 = constructBtPostIn(inOrd, postOrd, nSize, 0, 5, mapIndtoNode);
		System.out.println();
		System.out.print("PreOrder of BT from Post and In: ");
		preOrder(resR);

		// Lec67 Time to Burn Tree
		int ans11 = minTimeToBurn(root);
		System.out.println("time to burnTree:  " + ans11);
		
		//Lec 68 Moris trav code pending, flatten BT to LL
		//TreeNode ip = root;
		//flattenBt(ip);
		//preOrder(ip);
		

	}
	
	//flattenBT Start
	static void flattenBt(TreeNode ip){
		TreeNode curr = ip;
		while(curr != null){
			
			if(curr.left != null){
				//find pred
				TreeNode pred = curr.left;
				
				while(pred.right != null)
					pred = pred.right;
				
				pred.right = curr.right; //l to r link
				curr.right = curr.left; //root to left
				curr.left = null;
			}
			curr = curr.right;
		}
		
	}
	
//burntree start
	static int target = 6;

	static int minTimeToBurn(TreeNode root) {
		// 1. node to parent mapping
		// 2. find target node
		// 3. burn tree

		TreeNode targetNode = nodeToParent(root);
		int tim = burnTree(targetNode);
		return tim;
	}

	static int burnTree(TreeNode targetNode) {
		int ans = 0;
		Map<TreeNode, Boolean> visited = new HashMap<>();
		Queue<TreeNode> q = new LinkedList<>();
		q.add(targetNode);
		visited.put(targetNode, true);

		while (!q.isEmpty()) {
			
			Boolean flag =false;
			
			int size = q.size();
			for (int i = 0; i < size; i++) {
				TreeNode frontNode = q.peek();
				q.poll();
				if (frontNode.left != null && visited.get(frontNode.left) == null) {
					q.add(frontNode.left);
					visited.put(frontNode.left, true);
					flag =true;
				}

				if (frontNode.right != null && visited.get(frontNode.right) == null) {
					q.add(frontNode.right);
					visited.put(frontNode.right, true);
					flag= true;
				}
				if (nodeToPar.get(frontNode) != null && visited.get(nodeToPar.get(frontNode)) == null) {
					q.add(nodeToPar.get(frontNode));
					visited.put(nodeToPar.get(frontNode), true);
					flag = true;
				}
			}
			if(flag == true) ans++;
		}

		return ans;
	}

	static Map<TreeNode, TreeNode> nodeToPar = new HashMap<>();

	static TreeNode nodeToParent(TreeNode root) {
		TreeNode targetNode = null;
		nodeToPar.put(root, null);
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);

		while (!q.isEmpty()) {
			TreeNode frontNode = q.peek();
			q.poll();

			if (frontNode.val == target)
				targetNode = frontNode;

			if (frontNode.left != null) {
				nodeToPar.put(frontNode.left, frontNode);
				q.add(frontNode.left);
			}
			if (frontNode.right != null) {
				nodeToPar.put(frontNode.right, frontNode);
				q.add(frontNode.right);
			}
		}
		return targetNode;

	}
//burn tree end
	
	//tree constr start
	// map Index of each element of InOrd
	static Map<Integer, Integer> findIndxIn(int in[], int n) {
		Map<Integer, Integer> m = new HashMap<>();
		for (int i = 0; i < n; i++) {
			m.put(in[i], i);
		}
		return m;
	}

	// PostIn
	static int indexPost = 5;

	static TreeNode constructBtPostIn(int[] in, int[] post, int n, int inOrdStart, int inOrdEnd,
			Map<Integer, Integer> m) {

		if (indexPost < 0 || inOrdStart > inOrdEnd) {
			return null;
		}
		TreeNode resRoot = new TreeNode(post[indexPost]);
		int elm = post[indexPost--];
		int pos = m.get(elm);

		resRoot.right = constructBtPostIn(in, post, n, pos + 1, inOrdEnd, m);
		resRoot.left = constructBtIp(in, post, n, inOrdStart, pos - 1, m);

		return resRoot;
	}

	// InPre
	static int indexPre = 0;

	static TreeNode constructBtIp(int[] in, int[] pre, int n, int inOrdStart, int inOrdEnd, Map<Integer, Integer> m) {

		if (indexPre >= n || inOrdStart > inOrdEnd) {
			return null;
		}
		TreeNode resRoot = new TreeNode(pre[indexPre]);
		int elm = pre[indexPre++];
		int pos = m.get(elm);

		resRoot.left = constructBtIp(in, pre, n, inOrdStart, pos - 1, m);
		resRoot.right = constructBtIp(in, pre, n, pos + 1, inOrdEnd, m);

		return resRoot;

	}
	
	//tree consruct end
}

/*
 * static List<int[]> diameterFast(TreeNode root){
 * 
 * if(root == null){ List<int[]> ans1 = new ArrayList(); int a=0; // d,h
 * ans1.add(new int[]{a,a}); return ans1; }
 * 
 * List<int[]> left = diameterFast(root.left); List<int[]> right =
 * diameterFast(root.right);
 * 
 * int op1 = left.get(0)[0]; int op2 = right.get(0)[0]; int op3 = left.get(0)[1]
 * + left.get(0)[1] +1;
 * 
 * List<int[]> ans = new ArrayList(); ans.add(new
 * int[]{Math.max(op1,Math.max(op2,op3)),Math.max(left.get(0)[1],right.get(0)[1]
 * )+1}); return ans;
 * 
 * }
 */
