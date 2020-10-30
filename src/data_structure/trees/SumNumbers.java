class Solution {
    public int sumNumbers(TreeNode root) {
        return sum(root,0);

    }
    int sum(TreeNode root,int val){
        if(root==null){
            return 0;
        }
        val=val*10+root.val;
        if(root.left==null && root.right==null){
            return val;
        }
        return sum(root.left,val)+sum(root.right,val);
    }
}


public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
 }
 class Sln{
    int sum(TreeNode node, int val){
        if(node==null){
            return 0;
        }
        int sum=val*10+node.val;
        if(node.left==null && node.right==null){
            return sum;
        }
        return sum(node.left, sum)+sum(node.right, sum);
    }
    public int sumNumbers(TreeNode root){
        return sum(root,0);
    }
}