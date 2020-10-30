class Soln{
    public class Node {
        TreeNode treeNode;
        int col;
        public Node(TreeNode treeNode, int col) {
            this.treeNode = treeNode;
            this.col = col;
        }
    }
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> answer = new LinkedList<>();
        if(root == null) return answer;
        HashMap<Integer, List<Integer>> hm = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(root, 0));
        hm.putIfAbsent(0, new LinkedList<>());
        hm.get(0).add(root.val);
        int min = 0;
        while(!queue.isEmpty()) {
            Node current = queue.remove();
            if(current.treeNode.left != null) {
                hm.putIfAbsent(current.col - 1, new LinkedList<>());
                hm.get(current.col - 1).add(current.treeNode.left.val);
                queue.add(new Node(current.treeNode.left, current.col - 1));
                min = Math.min(current.col - 1, min);
            }
            if(current.treeNode.right != null) {
                hm.putIfAbsent(current.col + 1, new LinkedList<>());
                hm.get(current.col + 1).add(current.treeNode.right.val);
                queue.add(new Node(current.treeNode.right, current.col + 1));
            }
        }
        for(int i = min; i < min + hm.size(); i++) {
            answer.add(hm.get(i));
        }
        return answer;
    }
}


import java.util.*;
public class VerticalOrderTraversal {
    static Map<Integer, List<Integer>> map;
    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        map = new TreeMap<>();
        helper(map, root, 0);
        List<List<Integer>> result=new ArrayList<>();
        int index=0;
        Iterator<Map.Entry<Integer, List<Integer>>> it=map.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry<Integer,List<Integer>> data= it.next();
            result.add(index,data.getValue());
            index++;
        }
        return result;
    }
    public static void helper(Map<Integer, List<Integer>> map, TreeNode root, int level) {
        map.computeIfAbsent(level,val->new ArrayList<>()).add(root.val);
        if (root.left != null){
            helper(map, root.left, level - 1);
        }
        if (root.right != null){
            helper(map, root.right, level + 1);
        }
    }
}





/**
 * Definition for a binary tree node.
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Sln{
    static Map<Integer, List<Integer>> map;
    private static void helper(TreeNode root, int idx){
        map.computeIfAbsent(idx, val->new ArrayList<>()).add(root, val);
        if(root.left!=null){
            helper(root.left, idx-1);
        }
        if(root.right!=null){
            helper(root.right, idx+1);
        }
    }
    public static List<List<Integer>> verticalTraversal(TreeNode root){
        map=mew TreeMap<>();
        helper(root,0);
        List<List<Integer>> result=new ArrayList<>();
        int idx=0;
        Iterator<Map.Entry<Integer, List<Integer>>> it=map.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry<Integer, List<Integer>> data=it.next();
            result.add(idx++, data.getValue());
        }
        return result;
    }
}


















