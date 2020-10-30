/*Merging Intervals
Generate problem statement for this pattern
Statement
Given a set of numbers find an optimal solution
for a problem considering the current number and
best you can get from the left and right sides.
 */
/*Approach
Find all optimal solutions for every interval and return the best possible answer.
*/
class Sln{
    int getOptInterval(){
        dp[i][j] = dp[i][k] + result[k] + dp[k+1][j]
        //Get the best from the left and right
        //sides and add a solution for the current position.
        for(int l = 1; l<n; l++) {
            for(int i = 0; i<n-l; i++) {
                int j = i+l;
                for(int k = i; k<j; k++) {
                    dp[i][j] = max(dp[i][j], dp[i][k] + result[k] + dp[k+1][j]);
                }
            }
        }
        return dp[0][n-1];
    }
}

/*1130. Minimum Cost Tree From Leaf Values Medium*/
class Sln2 {
    int minCostTree(TreeNode root) {
        for (int l = 1; l < n; ++l) {
            for (int i = 0; i < n - l; ++i) {
                int j = i + l;
                dp[i][j] = INT_MAX;
                for (int k = i; k < j; ++k) {
                    dp[i][j] = min(dp[i][j], dp[i][k] + dp[k + 1][j] + maxs[i][k] * maxs[k + 1][j]);
                }
            }
        }
    }
}
/*
96. Unique Binary Search Trees Medium
1039. Minimum Score Triangulation of Polygon Medium
546. Remove Boxes Medium
1000. Minimum Cost to Merge Stones Medium
312. Burst Balloons Hard
375. Guess Number Higher or Lower II Medium*/