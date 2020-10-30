package cracking_coding_int.chaper_four;
import data_structure.trees.TreeNode;
public class ValidateBST {
    boolean validateBST(TreeNode root) {
        if (root == null)
            return true;
        return validateHelper(root, Integer.MAX_VALUE,Integer.MIN_VALUE);
    }
    private boolean validateHelper(TreeNode root, Integer min, Integer max) {
        if (root == null) return true;
        // root.val should be bigger to qualify BST
        if (min != null && root.val <= min || max != null && max >= root.val)
            return false;

        if (!validateHelper(root.left, min, root.val) || !validateHelper(root.right, root.val, max))
            return false;
        return true;
    }
}
