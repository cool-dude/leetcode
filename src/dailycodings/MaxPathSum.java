package dailycodings;
import leetcode.TreeNode;

public class MaxPathSum {
    static class Result {
        int val;
    }
    static TreeNode root;

    private static int findMaxSumUtil(TreeNode node, Result result){
        if(node==null)
            return 0;
        // l and r store maximum path sum going through left and
        // right child of root respectively
        int l=findMaxSumUtil(node.left, result);
        int r=findMaxSumUtil(node.left, result);

        // Max path for parent call of root. This path must
        // include at-most one child of root
        int max_single = Math.max(Math.max(l,r) + node.data, node.data);

        // Max Top represents the sum when the Node under
        // consideration is the root of the max-sum path and no
        // ancestors of root are there in max sum path
        int max_top = Math.max(max_single, l + r + node.data);

        // Store the Maximum Result.
        result.val = Math.max(result.val, max_top);

        return max_single;
    }

    private static int findMaxSum(TreeNode root) {
        Result result=new Result();
        result.val=Integer.MIN_VALUE;
        findMaxSumUtil(root, result);
        return result.val;
    }

    private static int findMaxSum(){
        return findMaxSum(root);
    }

    public static void main(String args[]) {
        root = new TreeNode(10);
        root.left = new TreeNode(2);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(20);
        root.left.right = new TreeNode(1);
        root.right.right = new TreeNode(-25);
        root.right.right.left = new TreeNode(3);
        root.right.right.right = new TreeNode(4);
        System.out.println("Max path sum: " + findMaxSum());
    }
}