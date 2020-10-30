/*LC1536: Minimum Swaps to Arrange a Binary Grid
https://leetcode.com/problems/minimum-swaps-to-arrange-a-binary-grid/
Given an n x n binary grid, in one step
you can choose two adjacent rows of the
grid and swap them.

A grid is said to be valid if all the cells
above the main diagonal are zeros.

Return the minimum number of steps needed
to make the grid valid, or -1 if the grid cannot be valid.

The main diagonal of a grid is the diagonal
that starts at cell (1, 1) and ends at cell (n, n).

Example 1:
Input: grid = [[0,0,1],[1,1,0],[1,0,0]]
Output: 3

Example 2:
Input: grid = [[0,1,1,0],[0,1,1,0],[0,1,1,0],[0,1,1,0]]
Output: -1
Explanation: All rows are similar, swaps have no effect on the grid.

Example 3:
Input: grid = [[1,0,0],[1,1,0],[1,1,1]]
Output: 0

Constraints:
n == grid.length
n == grid[i].length
1 <= n <= 200
grid[i][j] is 0 or 1
So first we find the zeros at the end of each
row and make an integer array. Then simply find
the number of swaps required to sort it based on
the number of zeros in descending order.

A thing to note here is that we don't necessarily
want the array to be sorted. As long as index
i has more than or equal to n-i-1 zeros, we are good.https://interviewrecipes.com/problem-solving/*/
class Sln {
    public int minSwaps(int[][] grid) {
        int n=grid.length,res=0;
        List<Integer> rows=new LinkedList<>();
        for(int i=0;i<n;i++){
            int trailZrCt=0;
            for(int j=n-1;j>-1 && grid[i][j]==0;j--) trailZrCt++;
            rows.add(trailZrCt);
        }
        for(int cur=0,minZeros=n-1;cur<n;cur++,minZeros--){
            int satsIdx=cur;
            while (satsIdx<n && rows.get(satsIdx)<minZeros) satsIdx++;
            if(satsIdx==n) return -1;
            int toRem=rows.remove(satsIdx);
            rows.add(cur,toRem);
            res+=satsIdx-cur;
        }
        return res;
    }
}