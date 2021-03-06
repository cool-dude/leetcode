/* LC463:Island Perimeter
https://leetcode.com/problems/island-perimeter/
You are given a map in form of a two-dimensional
integer grid where 1 represents land and 0 represents water.

Grid cells are connected horizontally/vertically
(not diagonally). The grid is completely surrounded
\by water, and there is exactly one island (i.e.,
one or more connected land cells).

The island doesn't have "lakes" (water inside
that isn't connected to the water around the island).
One cell is a square with side length 1. The grid is
rectangular, width and height don't exceed 100.
Determine the perimeter of the island.

Example:
Input:
[[0,1,0,0],
 [1,1,1,0],
 [0,1,0,0],
 [1,1,0,0]]

Output: 16
Explanation: The perimeter is the 16 yellow stripes in the image below.
loop over the matrix and count the number of islands;
if the current dot is an island, count if it has any right neighbour or down neighbour;
the result is islands * 4 - neighbours * 2*/
class Solution {
    public int islandPerimeter(int[][] grid) {
        int islads=0,nbrs=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    islads++;
                    if(i<grid.length-1 && grid[i+1][j]==1) nbrs++;//count down
                    if(j<grid[0].length-1 && grid[i][j+1]==1) nbrs++;//count right
                }
            }
        }
        return islads*4-nbrs*2;
    }
}