/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     int hd;
 *     TreeNode left;
 *     TreeNode right;
 *
 *     TreeNode(int x) {
 *         val = x;
 *         hd = Integer.MAX_VALUE;
 *     }
 * }
 */
class Soln{
    public void bottomView(TreeNode root){
        if(!root)
            return;
        int hd=0;
        Map<Integer,Integer> map=
                new TreeMap<>();
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        root.hd=hd;
        q.add(root);

        while(!q.isEmpty()){
            TreeNode t=q.remove();
            hd=t.hd;
            map.put(hd,t.d);

            if(t.left){
                t.left.hd = hd-1;
                q.add(t.left);
            }
            if(t.right){
                t.right.hd = hd+1;
                q.add(t.right);
            }
        }
        for(Map.Entry<Integer,Integer>
                m:map.entrySet()) {
            System.out.print(m.getValue()+" ");
        }
    }
}