/*LC1559: Detect Cycles in 2D Grid
https://leetcode.com/problems/detect-cycles-in-2d-grid/
Given a 2D array of characters grid of size m x n,
you need to find if there exists any cycle consisting
of the same value in grid.

A cycle is a path of length 4 or more in the grid that
starts and ends at the same cell. From a given cell,
you can move to one of the cells adjacent to it - in
one of the four directions (up, down, left, or right),
 if it has the same value of the current cell.

Also, you cannot move to the cell that you visited in your last move.
For example, the cycle (1, 1) -> (1, 2) -> (1, 1) is
invalid because from (1, 2) we visited (1, 1) which
was the last visited cell.

Return true if any cycle of the same value exists in grid,
otherwise, return false.
Example 1:
Input: grid = [["a","a","a","a"],["a","b","b","a"],["a","b","b","a"],["a","a","a","a"]]
Output: true
Explanation: There are two valid cycles shown
in different colors in the image below:

Example 2:
Input: grid = [["c","c","c","a"],["c","d","c","c"],["c","c","e","c"],["f","c","c","c"]]
Output: true
Explanation: There is only one valid cycle highlighted in the image below:

Example 3:
Input: grid = [["a","b","b"],["b","z","b"],["b","b","a"]]
Output: false
Constraints:
m == grid.length
n == grid[i].length
1 <= m <= 500
1 <= n <= 500
grid consists only of lowercase English letters.
Intuition
Think in backward way,
for each number a in A,
if a % 2 == 1, we do operation 0 backward, turning 1 to 0.
If all a % 2 == 0, we do operation 1 backward.

Some observation here:
For each bit "1" in the bianry format of a,
we need at least one operation 0.
All operation 1 can be shared.
Explanation
For each number a,
we count the number of bits "1",
as well as the length of a in binary format.

The number of operation 0 equals to the total number of bits "1".
The number of operation 1 equals to maximum bit length - 1.
Complexity
T:O(Nlog(10^9)))
S:O(1)*/
class Sln{
    public int minOperations(int[] A) {
        int res = 0, maxLen = 0;
        for (int a : A) {
            int bits = 0;
            while (a > 0) {
                res += a & 1;
                bits++;
                a >>= 1;
            }
            maxLen = Math.max(maxLen, bits);
        }
        return res + maxLen - 1;
    }
}