package data_structure.trees;
public class SubTreeOfAnotherTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        boolean notFound = true;
        if (s == null && t == null) return !notFound;
        if (s == null || t == null) return notFound;

        String hayStack = serialize2(s);
        String needle = serialize2(t);
        return hayStack.indexOf(needle) >= 0;
    }

    private static String serialize2(TreeNode t) {
        StringBuilder sb = new StringBuilder();
        helper(t, sb);
        return sb.toString();
    }

    private static void helper(TreeNode t, StringBuilder sb) {
        if (t == null) {
            sb.append("null,");
            return;
        }
        sb.append('\'');
        sb.append(t.val);
        sb.append("\',");
        helper(t.left, sb);
        helper(t.right, sb);
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
public class Sln {
    private boolean equals(TreeNode x,TreeNode y){
        if(x==null && y==null)
            return true;
        if(x==null || y==null)
            return false;
        return x.val==y.val && equals(x.left,y.left)
                && equals(x.right,y.right);
    }

    private boolean traverse(TreeNode s,TreeNode t){
        return s!=null && (equals(s,t) || traverse(s.left,t) ||
                traverse(s.right,t));
    }

    public boolean isSubTree(TreeNode s,TreeNode t){
        return traverse(s,t);
    }
}

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
 }
class Sln{
    public void merge(TreeNode r1,TreeNode r2){
        if(r1==null){
            inorderTraversal(r2);
            return;;
        }
        if(r2==null){
            inorderTraversal(r2);
            return;
        }
        TreeNode cur1=r1,cur2=r2;
        Stack<TreeNode> s1,s2;
        while (cur1!=null || !s1.isEmpty()
         || cur2!=null || !s2.isEmpty()){
            if(cur1!=null||cur2!=null){
                if(cur1!=null){
                    s1.push(cur1);
                    cur1=cur1.left;
                }
                if(cur2!=null){
                    s2.push(cur2);
                    cur2=cur2.left;
                }
            }
            else{
                if(s1.isEmpty()){
                    while (!s2.isEmpty()) {
                        cur2 = s2.pop();
                        cur2.left = null;
                        inorderTraversal(cur2);
                    }
                    return;
                }
                if(s2.isEmpty()){
                    while (!s1.isEmpty()) {
                        cur1 = s1.pop();
                        cur1.left = null;
                        inorderTraversal(cur1);
                    }
                    return;
                }
                cur1=s1.pop();
                cur2=s2.pop();
                if(cur1.val<cur2.val){
                    System.out.println(cur1.val);
                    cur1=cur1.right;
                    s2.push(cur2);
                    cur2=null;
                }
                else {
                    System.out.println(cur2.val);
                    cur2=cur2.right;
                    s1.push(cur1);
                    cur1=null;
                }
            }
        }
        print(s1);print(s2);
    }

}