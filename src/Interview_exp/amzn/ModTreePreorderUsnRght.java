/*Input :    10
          /   \
        8      2
      /  \
    3     5
Output :    10
              \
               8
                \
                 3
                  \
                   5
                    \
                     2
Explanation : The preorder traversal
of given binary tree is 10 8 3 5 2.*/
class BTreeNode{
    int val;
    BTreeNode left,right;
    BTreeNode(int v){
        val=v;
        left=null;right=null;
    }
}
class Sln{
    public void modifyTree(BTreeNode root){
        BTreeNode r=root.right;
        BTreeNode rMost=root;
        if(root.left!=null){
            rMost=modifyTree(root.ri);
            root.right=root.left;
            root.left=null;
        }
        if(r==null)
            return rMost;
        rMost.right=r;
        rMost=modifyTree(r);
        return rMost;
    }
}