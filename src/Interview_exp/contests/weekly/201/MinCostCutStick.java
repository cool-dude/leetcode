/*LC1547: Minimum Cost to Cut a Stick
https://leetcode.com/contest/weekly-contest-201/problems/minimum-cost-to-cut-a-stick/
Given a wooden stick of length n units.
The stick is labelled from 0 to n.
For example, a stick of length 6 is labelled as follows:

Given an integer array cuts where cuts[i]
denotes a position you should perform a cut at.

You should perform the cuts in order,
you can change the order of the cuts as you wish.

The cost of one cut is the length of the stick to
be cut, the total cost is the sum of costs of
all cuts. When you cut a stick, it will be split
into two smaller sticks (i.e. the sum of their
lengths is the length of the stick before the cut).
Please refer to the first example for a better explanation.

Return the minimum total cost of the cuts.

Example 1:
Input: n = 7, cuts = [1,3,4,5]
Output: 16
Explanation: Using cuts order = [1, 3, 4, 5] as in the input leads to the following scenario:

The first cut is done to a rod of length 7 so the cost is 7. The second cut is done to a rod of length 6 (i.e. the second part of the first cut), the third is done to a rod of length 4 and the last cut is to a rod of length 3. The total cost is 7 + 6 + 4 + 3 = 20.
Rearranging the cuts to be [3, 5, 1, 4] for example will lead to a scenario with total cost = 16 (as shown in the example photo 7 + 4 + 3 + 2 = 16).

Example 2:
Input: n = 9, cuts = [5,6,1,4,2]
Output: 22
2 <= n <= 10^6
1 <= cuts.length <= min(n - 1, 100)
1 <= cuts[i] <= n - 1
All the integers in cuts array are distinct.
Explanation: If you try the given cuts ordering the cost will be 25.
There are much ordering with total cost <= 25, for example,
the order [4, 6, 5, 2, 1] has total cost = 22 which is the minimum possible.
Similar problems:
312. Burst Balloons
1000. Minimum Cost to Merge Stones
1039. Minimum Score Triangulation of Polygon
Check out "with picture" solution, and also - how the heck that problem is "Medium"??
To make it simpler, we add two sentinel values to cuts -
left and right edges of the stick. Then, we sort the cuts
so we can easily identify all cuts between two points.
DFS can help us find the most efficient sequence of cuts.
To avoid recomputation, we memoise the best answer for
stick between cuts[i] and cuts[j] in dp[i][j].

In the following example, you can see the first cut at
points 1 (or 4) results in total cost of 13 (5 + 0 + 8).
If we first cut at point 2 (or 3), the cost will be 12 (5 + 2 + 5). */
class Sln1 {
    static int[][] dp;
    int dfs(List<Integer> cuts, int i,int j){
        if (j - i <= 1)
            return 0;
        if(dp[i][j]==0){
            dp[i][j] = Integer.MAX_VALUE;
            for (int k = i + 1; k < j; ++k)
                dp[i][j] = Math.min(dp[i][j],
                        cuts.get(j) - cuts.get(i) + dfs(cuts, i, k) + dfs(cuts, k, j));
        }
        return dp[i][j];
    }
    public int minCost(int n, int[] cuts) {
        dp=new int[102][102];
        var c = new ArrayList<Integer>();
        for (int cut : cuts)
            c.add(cut);
        c.addAll(Arrays.asList(0, n));
        Collections.sort(c);
        return dfs(c,0,c.size()-1);
    }
}

class Sln2{
    public int minCost(int n, int[] cuts) {
        var c = new ArrayList<Integer>();
        for (int cut : cuts)
            c.add(cut);
        c.addAll(Arrays.asList(0, n));
        Collections.sort(c);
        int[][] dp = new int[c.size()][c.size()];
        for (int i = c.size() - 1; i >= 0; --i)
            for (int j = i + 1; j < c.size(); ++j) {
                for (int k = i + 1; k < j; ++k)
                    dp[i][j] = Math.min(dp[i][j] == 0 ? Integer.MAX_VALUE : dp[i][j],
                            c.get(j) - c.get(i) + dp[i][k] + dp[k][j]);
            }
        return dp[0][c.size() - 1];
    }
}