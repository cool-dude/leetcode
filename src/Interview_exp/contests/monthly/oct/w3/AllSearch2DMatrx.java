/*LC74: Search a 2D Matrix
https://leetcode.com/problems/search-a-2d-matrix/
Write an efficient algorithm that searches
for a value in an m x n matrix. This matrix
has the following properties:
Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
Example 1:
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 3
Output: true

Example 2:
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 13
Output: false

Example 3:
Input: matrix = [], target = 0
Output: false*/
class Sln {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null||matrix.length==0) return false;
        int m=matrix.length,n=matrix[0].length;
        if(m==0||n==0) return false;
        int l=0,r=m*n-1;
        while (l!=r){
            int mi=(l+r-1)>>1;
            if(matrix[mi/n][mi%n]<target)
                l=mi+1;
            else
                r=mi;
        }
        return matrix[r/n][r%n]==target;
    }
}
/*LC240: Search a 2D Matrix II
https://leetcode.com/problems/search-a-2d-matrix-ii/
Write an efficient algorithm that searches
for a value in an m x n matrix. This matrix has the following properties:
Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
Example:
Consider the following matrix:
[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
Given target = 5, return true.
Given target = 20, return false.*/
class Sln2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null||matrix.length==0||matrix[0].length==0) return false;
        int i=0,j=matrix[0].length-1;
        while (i<=matrix.length-1 && j>=0){
            if(matrix[i][j]==target) return true;
            else if(matrix[i][j]<target) i++;
            else j--;
        }
        return false;
    }
}