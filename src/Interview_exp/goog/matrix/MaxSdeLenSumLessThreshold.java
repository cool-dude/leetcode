/*LC1292: Maximum Side Length of a Square with Sum
Less than or Equal to Threshold
https://leetcode.com/problems/maximum-side-length-of-a-square-with-sum-less-than-or-equal-to-threshold/
Given a m x n matrix mat and an integer threshold.
Return the maximum side-length of a square with
sum less than or equal to threshold or return 0 if there is no such square.

Example 1:
Input: mat = [[1,1,3,2,4,3,2],[1,1,3,2,4,3,2],[1,1,3,2,4,3,2]], threshold = 4
Output: 2
Explanation: The maximum side length of square with sum less than 4 is 2 as shown.

Example 2:
Input: mat = [[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2]], threshold = 1
Output: 0

Example 3:
Input: mat = [[1,1,1,1],[1,0,0,0],[1,0,0,0],[1,0,0,0]], threshold = 6
Output: 3

Example 4:
Input: mat = [[18,70],[61,1],[25,85],[14,40],[11,96],[97,96],[63,45]], threshold = 40184
Output: 2

Constraints:
1 <= m, n <= 300
m == mat.length
n == mat[i].length
0 <= mat[i][j] <= 10000
0 <= threshold <= 10^5*/
class Sln{
    public int maxSideLength(int[][] mat,int threshold){
        int m=mat.length,n=mat[0].length;
        int[][] sum=new int[m+1][n+1];
        int max=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                sum[i+1][j+1]=sum[i+1][j]+sum[i][j+1]-sum[i][j]+mat[i][j];
                if(i-max>=0 && j-max>=0 &&
                        sums[i + 1][j + 1] - sums[i - max][j + 1] - sums[i + 1][j - max] + sums[i - max][j - max] <= threshold){
                    max+=1;
                }
            }
        }
        return max;
    }
    //T:O(mXn)
    //S:O(1).
}