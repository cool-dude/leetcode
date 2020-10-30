//recursive slns
class Sln1 {
    int squareSubMatrixRecursive(boolean[][] arr, int i,int j){
        if(i==arr.length||j==arr[0].length) return 0;
        if(!arr[i][j]) return 0;
        // Find size of right, bottom, and
        // bottom right submatrices and add 1
        // minimum of those 3 to get the result
        return 1+Math.min(Math.min(squareSubMatrixRecursive(i+1,j),
                squareSubMatrixRecursive(i,j+1)),squareSubMatrixRecursive(i+1,j+1));
    }
    public int squareSubMatrix(boolean[][] arr){
        int max=0;
        //compute each cell biggest
        //square starting at this cell at top-left corner
        for(int i=0;i<arr.length;i++)
            for(int j=0;j<arr[0].length;j++)
                if(arr[i][j])
                    max=Math.max(max, squareSubMatrixRecursive(arr,i,j));
        return max;
    }
}

//top-down
class Sln2{
    int m,n;
    int squareSubmatrixRecursive(boolean[][] arr,int i,int j,
                                 int[][] cache){
        if(i==m||j==n) return 0;
        if(!arr[i][j]) return 0;
        if(cache[i][j]>0) return cache[i][j];
        return 1+Math.min(Math.min(squareSubmatrixRecursive(arr,i+1,j,cache),
                squareSubmatrixRecursive(arr,i,j+1,cache)),
                squareSubmatrixRecursive(arr,i+1,j+1,cache));
    }
    public int squareSubMatrix(boolean[][] arr){
        m=arr.length,n=arr[0].length;
        int[][] cache=new int[m][n];
        Arrays.fill(cache,-1);
        int max=0;
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                if(!arr[i][j])
                    squareSubmatrixRecursive(arr,i,j,cache);

}

//bott-up
class Sln3{
    int squareSubmatrix(boolean[][] arr){
        int m=arr.length,n=arr[0].length;
        int[][] cache=new int[m][n];
        int max=0;
        for(int i=0;i<m;i++) {
            for (int j = 0; j < n; j++) {
                if(i==0||j==0)
                    cache[i][j]=arr[i][j]?1:0;
                else{
                    cache[i][j]=Math.min(Math.min(cache[i-1][j],cache[i][j-1]), cache[i-1][j-1])+1;
                }
                if(cache[i][j]>max) max=cache[i][j];
            }
        }
        return max;
    }
}