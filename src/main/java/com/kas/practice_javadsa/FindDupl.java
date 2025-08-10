package com.kas.practice_javadsa;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class FindDupl {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new LinkedList<>();
        traverse(root, new HashMap<>(), res);
        return res;
    }

    public String traverse(TreeNode node, Map<String, Integer> cnt,
            List<TreeNode> res) {
        if (node == null) {
            return "";
        }
        String representation = "(" + traverse(node.left, cnt, res) + ")" +
                node.val + "(" + traverse(node.right, cnt, res) +
                ")";
        cnt.put(representation, cnt.getOrDefault(representation, 0) + 1);
        if (cnt.get(representation) == 2) {
            res.add(node);
        }
        return representation;
    }
    
    
    public static void main(String[] args) {
		TreeNode root= new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		
		root.right.left = new TreeNode(2);
		root.right.right = new TreeNode(4);
		
		root.right.left.left = new TreeNode(4);
		
		FindDupl sl = new FindDupl();
		sl.findDuplicateSubtrees(root);
		
		//1,2,3,4,null,2,4,null,null,4
	}
}