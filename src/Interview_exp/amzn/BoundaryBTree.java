/*Boundary Traversal of BTree*/
class BTreeNode{
    int val;
    BTreeNode left,right;
    BTreeNode(int v){
        val=v;
        left=null;right=null;
    }
}
class Sln{
    void printBoundaryLeft(BTreeNode node){
        if(node==null)
            return;
        if(node.left!=null) {
            System.out.print(node.val+" ");
            printBoundaryLeft(node.left);
        }
        else if(node.right!=null){
            System.out.print(node.val+" ");
            printBoundaryLeft(node.right);
        }
    }
    void printLeaves(BTreeNode node){
        if(node==null)
            return;
        printLeaves(node.left);
        if(node.left==null && node.right==null)
            System.out.print(node.val+" ");
        printLeaves(node.right);
    }
    void printBoundaryRight(BTreeNode node){
        if(node==null)
            return;
        if(node.right!=null){
            printBoundaryRight(node.right);
            System.out.print(node.val+" ");
        }
        else if(node.left!=null){
            printBoundaryRight(node.left);
            System.out.print(node.val+" ");
        }
    }
    public void printBoundary(BTreeNode node){
        if(node==null)
            return;
        System.out.print(node.val+" ");

        printBoundaryLeft(node.left);

        printLeaves(node.left);
        printLeaves(node.right);

        printBoundaryRight(node.right);
    }
}