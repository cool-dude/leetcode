class TNode{
    int d;
    TNode lft,rgt;
    public TNode(int k){
        d=k;
        lft=rgt=null;
    }
}

class QItem{
    TNode node;
    int hd;
    public QItem
            (TNode r,int h){
        root=r;
        hd=h;
    }
}

class Tree{
    TNode root;
    public Tree(){
        root=null;
    }
    public Tree(TNode rt){
        root=rt;
    }

    public void prnTopView() {
        if(!root)
            return;
        HashSet<Integer> set=
                new HashSet<>();
        Queue<QItem> q=
                new LinkedList<QItem>();
        q.add(new QItem(root,0));

        while(!q.isEmpty()){
            QItem qi=q.pop();
            int h=qi.hd;
            TNode tn=qi.node;

            // If this is the
            // first node at its
            // horizontal distance,
            // then this node is
            // in top view.
            if(!set.contains(hd)){
                set.add(hd);
                System.out.println(tn.d+" ");
            }
            if(tn.left!=null)
                q.add(new QItem(tn.left,hd-1));
            if(tn.right!=null)
                q.add(new QItem(tn.right,hd+1));
        }
    }
}