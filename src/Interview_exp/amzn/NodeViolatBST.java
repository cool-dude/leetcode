/*BTree Node vioalting BST property*/
class BTreeNode{
    int val;
    BTreeNode left,right;
    BTreeNode(int v){
        val=v;
        left=null;right=null;
    }
}
class Sln{
    static BTreeNode prev=null;
    BTreeNode isBST(BTreeNode node){
        if(node!=null){
            if(isBST(node.left)!=null)
                return isBST(node.left);
            if(prev!=null && node.val<=prev.val)
                return node;
            return isBST(node.right);
        }
        return null;
    }
}