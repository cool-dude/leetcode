package leetcode.binary_tree;

import java.util.ArrayList;
import java.util.List;

public class InvertTree_226 {
    static List<Integer> list = new ArrayList<>();

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public TreeNode invertTree(TreeNode root) {
            if(root==null)
                return root;
            invertTree(root.left);
            invertTree(root.right);
            TreeNode t=root.left;
            root.left=root.right;
            root.right=t;
            return root;
        }
    }
}
