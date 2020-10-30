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
    int[] nums;
    Random rand=new Random();

    private TreeNode helper(int l,int r){
        if(l>r) return null;
        int p=l+(r-l)/2;
        if((r-l)%2==1) p+=rand.nextInt(2);

        TreeNode root=new TreeNode(nums[p]);
        root.left = helper(l,p-1);
        root.right = helper(p+1, r);
        return root;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums=nums;
        return helper(0, nums.length-1);
    }
}