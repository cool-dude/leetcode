/*ZigZag Tree Traversal
Write a function to print ZigZag order
traversal of a binary tree. For the below
binary tree the zigzag order traversal will be 1 3 2 7 6 5 4 */
class BTreeNode{
    int val;
    BTreeNode left,right;
    BTreeNode(int v){
        val=v;
    }
}
class Sln{
    void swao(Stack<BTreeNode> cur,Stack<BTreeNode> next){
        Stack<BTreeNode> t=cur;
        cur=next;
        next=t;
    }
    public void printZigZagTraversal(BTreeNode root){
        if(root==null)
            return;
        Stack<BTreeNode> curLevel,nextLevel;
        curLevel=new Stack<>();
        nextLevel=new Stack<>();
        curLevel.push(root);
        boolean lToR=true;
        while (!curLevel.isEmpty()){
            BTreeNode cur=curLevel.pop();
            System.out.print(cur.val+" ");
            if(lToR){
                if(cur.left!=null){
                    nextLevel.push(cur.left);
                }
                if(cur.right!=null){
                    nextLevel.push(cur.right);
                }
            }
            else {
                if(cur.right!=null){
                    nextLevel.push(cur.right);
                }
                if(cur.left!=null){
                    nextLevel.push(cur.left);
                }
            }
            if(curLevel.isEmpty()){
                lToR=!lToR;
                swap(curLevel,nextLevel);
            }
        }
    }
}
//T:O(n).
//S:O(n).