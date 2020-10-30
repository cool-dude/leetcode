package data_structure.trees;
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) {
        val = x;
    }
}
public class CheckBalanced {
    boolean isBalanced(TreeNode root){
        return checkHeight(root)!=Integer.MIN_VALUE;
    }
    private int checkHeight(TreeNode root) {
        if(root==null) return -1;
        int left=checkHeight(root.left);
        if(left==Integer.MIN_VALUE) return Integer.MIN_VALUE;
        int right=checkHeight(root.right);
        if(right==Integer.MIN_VALUE) return Integer.MIN_VALUE;
        if(Math.abs(right-left)>1) return Integer.MIN_VALUE;
        else return Math.max(left,right)+1;
    }
}

class Sln{
    boolean isBalanced(TreeNode root) { return checkHeight(root)!=Integer.MIN_VALUE;}
    int checkHeight(TreeNode root){
        if(root==null){
            return -1;
        }
        int left=checkHeight(root.left);
        if(left==Integer.MIN_VALUE) return Integer.MIN_VALUE;
        int right=checkHeight(root.right);
        if(right==Integer.MIN_VALUE) return Integer.MIN_VALUE;
        if(Math.abs(left-right)>1) return Integer.MIN_VALUE;
        else return Math.max(left, right)+1;
    }
}