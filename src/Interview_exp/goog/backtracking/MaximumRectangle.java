package backtracking;
/*LC85:Maximal Rectangle
* https://leetcode.com/problems/maximal-rectangle/
Given 2D binary matrix filled with 0's and 1's,
* find the largest rectangle containing only 1's and return its area.
Input:
[
  ["1","0","1","0","0"],
  ["1","0","1","1","1"],
  ["1","1","1","1","1"],
  ["1","0","0","1","0"]
]
Output: 6*/
class Sln{
    public int maxArea(char[][] matrix){
        if(matrix.length==0) return 0;
        int m=matrix.length;
        int n=matrix[0].length;
        if(m==n==1) {
            return matrix[0][0]=='1'?1:0;
        }
        int[] l=new int[n];
        int[] r=new int[n];
        int[] h=new int[n];
        Arrays.fill(r,n);
        int max=0;
        for(int i=0;i<m;i++){
            int cur_l=0,cur_r=n-1;
            //height
            for(int j=0;j<n;j++){
                if(matrix[i][j]=='1'){
                    h[j]++;
                }
                else {
                    h[j]=0;
                }
            }
            //left
            for(int j=0;j<nj++){
                if(matrix[i][j]=='1'){
                    l[j]=Math.max(l[j],cur_l);
                }
                else {
                    l[j]=0;cur_l=j+1;
                }
            }
            //right
            for(int j=-1;j>=0;j--){
                if(matrix[i][j]=='1'){
                    r[j]=Math.min(r[j],cur_r);
                }
                else {
                    r[j]=n-1;cur_r=j;
                }
            }
            //area
            for(int j=0;j<n;j++){
                max=Math.max(max,(r[j]-l[j])*h[j]);
            }
        }
        return max;
    }
    //T:O(MXN).
    //S:O(N).
}