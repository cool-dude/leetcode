package data_structure.graph.week3;
/*Let's determine dp[i], the farthest location we
* can get to using i refueling stops.
* This is motivated by the fact that we want
* the smallest i for which dp[i] >= target.

Let's update dp as we consider each station in order.
*  With no stations, clearly we can get a
* maximum distance of startFuel with 0 refueling stops.

Now let's look at the update step. When adding a
* station station[i] = (location, capacity), any time we could reach
* this station with t refueling stops, we can now reach capacity further with t+1 refueling stops.

For example, if we could reach a distance of 15 with 1 refueling stop,
* and now we added a station at location 10 with 30 liters
of fuel, then we could potentially reach a distance of 45 with 2 refueling stops.*/
class Sln{
    public int minRefuelStops(int target, int startFuel, int[][] stations){
        int N = stations.length;
        long[] dp = new long[N + 1];
        dp[0] = startFuel;
        for (int i = 0; i < N; ++i)
            for (int t = i; t >= 0; --t)
                if (dp[t] >= stations[i][0])
                    dp[t+1] = Math.max(dp[t+1], dp[t] + (long) stations[i][1]);

        for (int i = 0; i <= N; ++i)
            if (dp[i] >= target) return i;
        return -1;
    }
}