/*Bottom view BTree
i/p:
                    20
                    /    \
                  8       22
                /   \      \
              5      3      25
                    / \
                  10    14
o/p:5,10,14,25
i/p:                 20
                    /    \
                  8       22
                /   \    /   \
              5      3 4     25
                    / \
                  10    14
o/p:  5,10,14,25*/
class BTreeNode{
    int val;
    BTreeNode left,right;
    BTreeNode(int v){
        val=v;
        left=null;right=null;
    }
}
class Pair{
    int x;
    int y;
    Pair(int x_,int y_){
        x=x_;y=y_;
    }
}
class Sln{
    void helper(BTreeNode node,int dist,int level, Map<Integer,Pair> map){
        if(node==null)
            return;
        if(level>=map.get(dist).y){
            map.put(dist,new Pair(node.val,level));
        }
        helper(node.left,dist-1,level+1,map);
        helper(node.right, dist+1, level+1,map);
    }
    public void printBottom(BTreeNode root){
        if(root==null)
            return;
        Map<Integer, Pair> map=new HashMap<>();
        helper(root,0,0,map);
    }
}