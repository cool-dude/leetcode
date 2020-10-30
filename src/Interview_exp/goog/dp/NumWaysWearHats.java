/*LC1434: Number of Ways to Wear Different Hats to Each Other
https://leetcode.com/problems/number-of-ways-of-cutting-a-pizza/
There are n people and 40 types of hats labeled from 1 to 40.
Given a list of list of integers hats, where hats[i]
is a list of all hats preferred by the i-th person.
Return the number of ways that the n people wear different hats to each other.
Since the answer may be too large, return it modulo 10^9 + 7.

Example 1:
Input: hats = [[3,4],[4,5],[5]]
Output: 1
Explanation: There is only one way to choose hats given the conditions.
First person choose hat 3, Second person choose hat 4 and last one hat 5.

Example 2:
Input: hats = [[3,5,1],[3,5]]
Output: 4
Explanation: There are 4 ways to choose hats
(3,5), (5,3), (1,3) and (1,5)

Example 3:
Input: hats = [[1,2,3,4],[1,2,3,4],[1,2,3,4],[1,2,3,4]]
Output: 24
Explanation: Each person can choose hats labeled from 1 to 4.
Number of Permutations of (1,2,3,4) = 24.

Example 4:
Input: hats = [[1,2,3],[2,3,5,6],[1,3,7,9],[1,8,9],[2,5,7]]
Output: 111*/
class Sln1 {
    public int numberWays(List<List<Integer>> hats) {
        int n = hats.size();
        boolean[][] cw = new boolean[n][41];
        for (int i = 0; i < n; ++i) {
            for (int h : hats.get(i))
                cw[i][h] = true;
        }
        int[][] dp = new int[41][1<<n];
        dp[0][0] = 1;
        for (int i = 1; i <= 40; ++i) {
            for (int j = 0; j < (1<<n); ++j) {
                dp[i][j] = dp[i-1][j];
            }
            for (int j = 0; j < (1<<n); ++j) {
                for (int k = 0; k < n; ++k) {
                    int j2 = j|(1<<k);
                    if (j2==j)
                        continue;
                    if (!cw[k][i])
                        continue;
                    dp[i][j2] += dp[i-1][j];
                    dp[i][j2] %= 1000000007;
                }
            }
        }
        return dp[40][(1<<n)-1];
    }
}

class Sln2 {
    public int numberWays(List<List<Integer>> hats) {
        List<Integer>[] h2p = new List[41]; // h2p[i] indicates the list of people who can wear i_th hat
        for (int i = 1; i <= 40; i++) h2p[i] = new ArrayList<>();
        for (int i = 0; i < hats.size(); i++)
            for (int hat : hats.get(i))
                h2p[hat].add(i);
        Integer[][] dp = new Integer[41][1024];
        return dfs(h2p, hats.size(), 1, 0, dp);
    }
    // dfs(...hat, chosen...) number of ways to wear different hats given `chosen` mask (list of people were assigned hat)
    //     and used hats from 1 to `hat`-1.
    int dfs(List<Integer>[] h2p, int n, int hat, int chosen, Integer[][] dp) {
        if (chosen == (1 << n) - 1) return 1; // Check if assigned different hats to all people
        if (hat > 40) return 0; // no more hats to process
        if (dp[hat][chosen] != null) return dp[hat][chosen];
        int ans = dfs(h2p, n, hat + 1, chosen, dp); // Don't wear this hat
        for (int p : h2p[hat]) {
            if (((chosen >> p) & 1) == 1) continue; // Skip if person `p` was assigned hat
            ans += dfs(h2p, n, hat + 1, chosen | (1 << p), dp); // Wear this hat for p_th person
            ans %= 1_000_000_007;
        }
        return dp[hat][chosen] = ans;
    }
}