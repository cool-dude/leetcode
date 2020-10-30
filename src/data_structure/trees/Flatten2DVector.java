class Vector2D {
    private int x;
    private int y;
    private int[][] list;

    public Vector2D(int[][] v) {
        x=0;
        y=0;
        for(int i=0; i<v.length; i++)
            for(int j=0; j<v[i].length; j++)
                list[i][j]=v[i][j];
    }

    public int next() {
        if(!hasNext()){
            return -1;
        }
        if(y>=list[x].length){
            y=0;
            x++;
        }
        else
            y++;
        return list[x][y];
    }

    public boolean hasNext() {
        if(list==null||list.length==0)
            return false;
        while(x<list.length && list[x].length==0){
            x++;y=0;
        }
        if(x>=list.length){
            return false;
        }
        if(y>=list[x].length){
            return false;
        }
        return true;
    }
}
/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D obj = new Vector2D(v);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */