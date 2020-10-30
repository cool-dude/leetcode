/*LC1595: Minimum Cost to Connect Two Groups of Points
https://leetcode.com/problems/minimum-cost-to-connect-two-groups-of-points/
You are given two groups of points where
the first group has size1 points,
the second group has size2 points, and size1 >= size2.

The cost of the connection between any two
points are given in an size1 x size2 matrix
where cost[i][j] is the cost of connecting
point i of the first group and point j of
the second group. The groups are connected
if each point in both groups is connected
to one or more points in the opposite group.
In other words, each point in the first group
must be connected to at least one point in the
second group, and each point in the second
group must be connected to at least one point in the first group.

Return the minimum cost it takes to connect the two groups.

Example 1:
Input: cost = [[15, 96], [36, 2]]
Output: 17
Explanation: The optimal way of connecting the groups is:
1--A
2--B
This results in a total cost of 17.

Example 2:
Input: cost = [[1, 3, 5], [4, 1, 1], [1, 5, 3]]
Output: 4
Explanation: The optimal way of connecting the groups is:
1--A
2--B
2--C
3--A
This results in a total cost of 4.
Note that there are multiple points connected to point 2 in the first group and point A in the second group. This does not matter as there is no limit to the number of points that can be connected. We only care about the minimum total cost.

Example 3:
Input: cost = [[2, 5, 1], [3, 4, 7], [8, 1, 2], [6, 2, 4], [3, 8, 8]]
Output: 10*/
class Sln {
    public int connectTwoGroups(List<List<Integer>> cost) {
        int l = cost.size(), r = cost.get(0).size();
        int[] right = new int[r];
        Arrays.fill(right, Integer.MAX_VALUE);
        for (int j = 0; j < r; j++) {
            for (int i = 0; i < l; i++) {
                right[j] = Math.min(right[j], cost.get(i).get(j));
            }
        }
        return helper(cost, 0, right, 0, new int[l + 1][(1<<r)]);
    }
    int helper(List<List<Integer>> cost, int i, int[] right, int mask, int[][] dp) {
        if (dp[i][mask] > 0) return dp[i][mask];
        int res = 0;
        if (i < cost.size()) {
            res = Integer.MAX_VALUE;
            for (int j = 0; j < cost.get(0).size(); j++) {
                res = Math.min(res, cost.get(i).get(j) + helper(cost, i + 1, right, mask | (1 << j), dp));
            }
        }
        else {
            for (int j = 0; j < cost.get(0).size(); j++) {
                if ((mask & (1 << j)) == 0) res += right[j];
            }
        }
        return dp[i][mask] = res;
    }
}