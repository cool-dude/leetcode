/*LC1478: Allocate Mailboxes
https://leetcode.com/problems/allocate-mailboxes/
Given the array houses and an integer k.
where houses[i] is the location of the
ith house along a street, your task is
to allocate k mailboxes in the street.

Return the minimum total distance between
each house and its nearest mailbox.

The answer is guaranteed to fit in a
32-bit signed integer.

Example 1:
Input: houses = [1,4,8,10,20], k = 3
Output: 5
Explanation: Allocate mailboxes in position 3, 9 and 20.
Minimum total distance from each houses to nearest mailboxes is |3-1| + |4-3| + |9-8| + |10-9| + |20-20| = 5

Example 2:
Input: houses = [2,3,5,12,18], k = 2
Output: 9
Explanation: Allocate mailboxes in position 3 and 14.
Minimum total distance from each houses to nearest mailboxes is |2-3| + |3-3| + |5-3| + |12-14| + |18-14| = 9.

Example 3:
Input: houses = [7,4,6,1], k = 1
Output: 8

Example 4:
Input: houses = [3,6,14,10], k = 4
Output: 0

Constraints:
n == houses.length
1 <= n <= 100
1 <= houses[i] <= 10^4
1 <= k <= n
Array houses contain unique integers.
To solve f(N, k), we need to solve the following and pick the minimum:
f(N - 1, k - 1) + min cost of serving kth mailbox to the last house;
f(N - 2, k - 1) + min cost of serving kth mailbox to the last 2 houses;
f(N - 3, k - 1) + min cost of serving kth mailbox to the last 3 houses;
..........
f(k - 1, k - 1) + min cost of serving kth mailbox to the last N - k + 1
houses; we need at least k - 1 houses to use k - 1 mailboxes.
State: dp[i][j]: the min total distance of houses[0, i] with
j mailboxes serving to them.

Optimal substructure: dp[i][j] = Min of
{dp[i'][j - 1] + min total distance of houses[i' + 1, i]
with 1 mailbox serving to them}, for all i' in [j - 2, i).
We need to have at least j - 1 houses to use j - 1 mailboxes,
so the starting index for i' is j - 2 (0 index).

Initialization: if there is only 1 mailbox,
we achieve the min total distance by putting this mailbox
in the median house position of its serving range.
To speed up this computation, we first sort all
houses' positions then build a prefix sum array.
This allows us to compute the cost of 1 mailbox
serving to a range house[i, j] in O(1) time.

The runtime is O(N^3), space complexity is O(N^2).
To compute dp[i][j], we only need the results of
dp[i][j - 1], this means we can reduce the space
from O(N^2) to O(N).
https://leetcode.com/problems/allocate-mailboxes/discuss/685620/JavaC%2B%2BPython-Top-down-DP-Prove-median-mailbox-O(n3)*/
class Sln {
    public final int MAX = 100, INF = 100 * 10000;
    int[][] costs = new int[MAX][MAX];
    int[][] dp = new int[MAX][MAX];
    public int minDistance(int[] houses, int k) {
        int n = houses.length;
        Arrays.sort(houses);
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                for (int t = i; t <= j; t++)
                    costs[i][j] += Math.abs(houses[(i + j) / 2] - houses[t]);
        return solve(houses, n, k, 0);
    }
    int solve(int[] houses, int n, int k, int i) {
        if (k == 0 && i == n) return 0;
        if (k == 0 || i == n) return INF;
        if (dp[k][i] != 0) return dp[k][i];
        int ans = INF;
        for (int j = i; j < n; j++)
            ans = Math.min(ans, costs[i][j] + solve(houses, n, k-1, j + 1));
        return dp[k][i] = ans;
    }
}