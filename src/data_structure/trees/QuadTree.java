// Definition for a QuadTree node.
class Node {
    public int val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;
    public Node() {}
    public Node(int _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = _topLeft;
        topRight = _topRight;
        bottomLeft = _bottomLeft;
        bottomRight = _bottomRight;
    }
}

class Soln{
    private Node helper(int[][] mat, int x,int y,int n){
        if(x>=n||y>=n||) return null;
        if(n==1){
            Node nd=new Node(mat[x][y],true, null, null, null,null);
            return nd;
        }
        Node ret=new Node();
        Node tl=helper(mat, x, y,n/2);
        Node tr=helper(mat, x,y+n/2,n/2);
        Node bl=helper(mat, x+n/2, y, n/2);
        Node br=helper(mat, x+n/2, y+n/2, n/2);
        if(tl.isLeaf && tr.isLeaf && bl.isLeaf && br.isLeaf
        && tl.val==tr.val && tr.val==bl.val && bl.val==br.val){
            ret.isLeaf=true;
            ret.val=tl.val;
        }
        else{
            ret.topLeft = tl;
            ret.topRight = tr;
            ret.bottomLeft = bl;
            ret.bottomRight = br;
        }
        return ret;
    }
    public Node construct(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        if(m==0 || n==0 || m!=n || (m&(m-1)!=0)) return null;
        return helper(grid,0,0,m);
    }
}