/*LC743: Network Delay Time
https://leetcode.com/problems/network-delay-time/
There are N network nodes, labelled 1 to N.
Given times, a list of travel times as directed
edges times[i] = (u, v, w), where u is the
source node, v is the target node, and w
is the time it takes for a signal to travel from source to target.

Now, we send a signal from a certain node K. How long will it take for all nodes to receive the signal? If it is impossible, return -1.
Example 1:
Input: times = [[2,1,1],[2,3,1],[3,4,1]], N = 4, K = 2
Output: 2
Note:
N will be in the range [1, 100].
K will be in the range [1, N].
The length of times will be in the range [1, 6000].
All edges times[i] = (u, v, w) will have 1 <= u,
v <= N and 0 <= w <= 100.
SOLN:
The solution actually use some thought of dynamical programming
Subproblem: dp(i) represents minimum distance from
K to i (iteratively update dp(i) when we find
another shorter distance from K to i)
Base case 1:
initialize MAX value as initial minimum distance from K to every point
initialize 0 as min distance to K itself
Recurrence relation: traverse all destinations,
if dp[u] (starting point of current edge)
has already been visited, and new distance
from u to v is smaller than previous saved
distance, we should update minimum distance from u to v
After getting minimum distance (travel time)
to all points, we should retrieve the max
distance from these minimum distance, to ensure
that we can travel all points in a specific travel time
If we do not visit all points, we should return -1
Complexity is O(VE), but the problem said N will
be no more than 100, so the complexity should be O(E)*/
class Sln{
    public int networkDelayTime(int[][] times,int n,int k){
        if(times==null||times.length==0)
            return -1;
        int[] dp=new int[n+1];
        for(int i=0;i<=n;i++)
            dp[i]=Integer.MAX_VALUE;
        dp[k]=0;
        //traverse all vertices
        for(int i=0;i<n;i++){
            for(int[] edge:times){
                int u=edge[0],v=edge[1],w=edge[2];
                if(dp[u]!=Integer.MAX_VALUE && dp[v]>dp[u]+w)
                    dp[v]=dp[u]+w;
            }
        }
        int res=0;
        for(int i=1;i<=n;i++)
            res=Math.max(res,dp[i]);
        return res==Integer.MAX_VALUE?-1:res;
    }
}