/*Print all nodes at distance K from target node*/
class BTreeNode{
    int val;
    BTreeNode left,right;
    BTreeNode(int v){
        val=v;
        left=null;right=null;
    }
}
class Sln{
    /* Recursive function to print all the nodes at distance k in
       tree (or subtree) rooted with given node */
    void printKDistanceDown(BTreeNode node, int k){
        if(node==null||k<0)
            return;
        if(k==0){
            System.out.println(node.val);
            return;
        }
        printKDistanceDown(node.left,k-1));
        printKDistanceDown(node.right, k-1);
    }
    //print distance between root and target node
    public int printKDistance(BTreeNode root, BTreeNode target, int k){
        if(root==null)
            return -1;
        if(root==target){
            printKDistanceDown(root,k);
            return 0;
        }
        int dl=printKDistance(root.left,target,k);
        //target node found in left sub-tree
        if(dl!=-1){
            if(dl+1==k){
                System.out.println(root.val);
            }
            else
                printKDistanceDown(root.right,k-dl-2);
            //return val for parent calls
            return dl+1;
        }
        int dr=printKDistance(root.right,target,k);
        //target node found in right sub-tree
        if(dr!=-1){
            if(dr+1==k){
                System.out.println(root.val);
            }
            else
                printKDistanceDown(root.left,k-dr-2);
            //return val for parent calls
            return dr+1;
        }
        //neither present in left of right subtree
        return -1;
    }
}