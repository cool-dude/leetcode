/*LC664: Strange Printer
https://leetcode.com/problems/strange-printer/
There is a strange printer with the following two special requirements:
The printer can only print a sequence of the same character each time.
At each turn, the printer can print new characters starting from and ending at any places, and will cover the original existing characters.
Given a string consists of lower English letters only, your job is to count the minimum number of turns the printer needed in order to print it.

Example 1:
Input: "aaabbb"
Output: 2
Explanation: Print "aaa" first and then print "bbb".
Example 2:
Input: "aba"
Output: 2
Explanation: Print "aaa" first and then print "b" from the second place of the string, which will cover the existing character 'a'.
Hint: Length of the given string will not exceed 100
dp[i][j] stands for the minimal turns we need for string from index i to index j.
So we have:
dp[i][i] = 1: we need 1 turn to paint a single character.
dp[i][i + 1]
dp[i][i + 1] = 1 if s.chartAt(i) == s.charAt(i + 1)
dp[i][i + 1] = 2 if s.chartAt(i) != s.charAt(i + 1)
Then we can iteration len from 2 to possibly n.
For each iteration, we iteration start index from 0 to the farthest possible.
The maximum turns for dp[start][start + len] is len + 1, i.e. print one character each time.
We can further divide the substring to two parts: start -> start+k and start+k+1 -> start+len. It is something as following:
index |start  ...  start + k| |start + k + 1 ... start + len|
char  |  a    ...       b   | |      c       ...      b     |
As shown above, if we have s.charAt(start + k) == s.charAt(start + len), we can make it in one turn when we print this character (i.e. b here)
This case we can reduce our turns to dp[start][start + k] + dp[start + k + 1][start + len] - 1*/
class Sln {
    String compress(String s){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(i>0 && s.charAt(i)==s.charAt(i-1))
                continue;
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
    public int strangePrinter(String s) {
        s=compress(s);
        if(s==null||s.length()==0)
            return 0;
        int n=s.length();
        int[][] dp=new int[n][n];
        for(int i=0;i<n;i++){
            dp[i][i]=1;
            if(i<n-1){
                dp[i][i+1]=s.charAt(i)==s.charAt(i+1)?1:2;
            }
        }
        for(int len=2;len<n;len++){
            for(int start=0;start+len<n;start++){
                dp[start][start+len]=len+1;
                for(int k=0;k<len;k++){
                    int t=dp[start][start+k]+dp[start+k+1][start+len];
                    dp[start][start+len]=Math.min(dp[start][start+len],
                            s.charAt(start+k)==s.charAt(start+len)?t-1:t);
                }
            }
        }
        return dp[0][n-1];
    }
}
/*LC1591: Strange Printer II
https://leetcode.com/problems/strange-printer-ii/
There is a strange printer with the
following two special requirements:

On each turn, the printer will print a solid
rectangular pattern of a single color on the grid.
This will cover up the existing colors in the rectangle.
Once the printer has used a color for the above
operation, the same color cannot be used again.
You are given a m x n matrix targetGrid, where
targetGrid[row][col] is the color in the position (row, col) of the grid.

Return true if it is possible to print the matrix targetGrid, otherwise, return false.

Example 1:
Input: targetGrid = [[1,1,1,1],[1,2,2,1],[1,2,2,1],[1,1,1,1]]
Output: true

Example 2:
Input: targetGrid = [[1,1,1,1],[1,1,3,3],[1,1,3,4],[5,5,1,4]]
Output: true

Example 3:
Input: targetGrid = [[1,2,1],[2,1,2],[1,2,1]]
Output: false
Explanation: It is impossible to form targetGrid because it is not allowed to print the same color in different turns.

Example 4:
Input: targetGrid = [[1,1,1],[3,1,3]]
Output: false
Constraints:
m == targetGrid.length
n == targetGrid[i].length
1 <= m, n <= 60
1 <= targetGrid[row][col] <= 60*/
class Solution {
    // same color should form a rectangle
    // topological sort
    // if a rectangle contains another one, then there is an edge between these two color
    public boolean isPrintable(int[][] targetGrid) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[61];
        for(int i = 0; i <= 60; i++) graph.add(new ArrayList<>());
        for(int i = 1; i <= 60; i++) search(targetGrid, i, graph, inDegree);

        Deque<Integer> zeros = new ArrayDeque<>();
        HashSet<Integer> seen = new HashSet<>();
        for(int i = 0; i < inDegree.length; i++) if(inDegree[i] == 0) zeros.add(i);
        while(!zeros.isEmpty()) {
            int cur = zeros.poll();
            if(!seen.add(cur)) continue;
            for(Integer nbh : graph.get(cur)) {
                inDegree[nbh]--;
                if(inDegree[nbh] == 0) zeros.add(nbh);
            }
        }
        return seen.size() == 61;
    }
    void search(int[][] grid, int color, List<List<Integer>> graph, int[] inDegree) {
        // get range
        int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE, maxX = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE;
        for(int i = 0; i < grid.length; i++) for(int j = 0; j < grid[0].length; j++) {
            if(grid[i][j] == color) {
                minX = Math.min(minX, i);
                maxX = Math.max(maxX, i);
                minY = Math.min(minY, j);
                maxY = Math.max(maxY, j);
            }
        }
        if(minX == Integer.MAX_VALUE) return ;
        // check relations
        for(int i = minX; i <= maxX; i++) for(int j = minY; j <= maxY; j++) {
            if(grid[i][j] != color) {
                graph.get(grid[i][j]).add(color); // to paint current color, we need to paint color in grid[i][j] first
                inDegree[color]++;
            }
        }
    }
}