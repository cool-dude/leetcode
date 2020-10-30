/*LC134: Gas Station
https://leetcode.com/problems/gas-station/
There are N gas stations along a circular route,
where the amount of gas at station i is gas[i].
You have a car with an unlimited gas tank and it
costs cost[i] of gas to travel from station i to its
next station (i+1). You begin the journey with
 an empty tank at one of the gas stations.
Example 1:
Input:
gas  = [1,2,3,4,5]
cost = [3,4,5,1,2]
Output: 3

Example 2:
Input:
gas  = [2,3,4]
cost = [3,4,3]
Output: -1*/
class Sln1{
    public int canCompleteCircuit(int[] gas,int[] cost){
        int total=0,cur=0;
        int start_idx=0;
        for(int i=0;i<gas.length;i++){
            total+=gas[i]-cost[i];
            cur+=gas[i]-cost[i];
            if(cur<0){
                start_idx=i+1;
                cur=0;
            }
        }
        return total>=0?start_idx:-1;
    }
    //T:O(n).
    //S:O(1).
}
/*LC871: Minimum Number of Refueling Stops
https://leetcode.com/problems/minimum-number-of-refueling-stops/
A car travels from a starting position
to a destination which is target miles
east of the starting position
Along the way, there are gas stations.
Each station[i] represents a gas station
that is station[i][0] miles east of the
starting position, and has station[i][1] liters of gas.

The car starts with an infinite tank of gas,
which initially has startFuel liters of
fuel in it.  It uses 1 liter of gas per 1 mile that it drives.

When the car reaches a gas station,
it may stop and refuel, transferring all
the gas from the station into the car.

What is the least number of refueling
 stops the car must make in order to
 reach its destination?  If it cannot reach the destination, return -1.

Example 1:
Input: target = 1, startFuel = 1, stations = []
Output: 0
Explanation: We can reach the target without refueling.

Example 2:
Input: target = 100, startFuel = 1, stations = [[10,100]]
Output: -1
Explanation: We can't reach the target (or even the first gas station).

Example 3:
Input: target = 100, startFuel = 10, stations = [[10,60],[20,30],[30,30],[60,40]]
Output: 2
Let's determine dp[i], the farthest location we
* can get to using i refueling stops.
* This is motivated by the fact that we want
* the smallest i for which dp[i] >= target.

Let's update dp as we consider each station in order.
*  With no stations, clearly we can get
* maximum distance of startFuel with 0 refueling stops.

Now let's look at the update step. When adding a
* station station[i] = (location, capacity), any time we could reach
* this station with t refueling stops, we can now reach capacity further with t+1 refueling stops.*/
class Sln2{
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int n = stations.length;
        long[] dp = new long[n + 1];
        dp[0] = startFuel;
        for (int i = 0; i < n; ++i)
            for (int t = i; t >= 0; --t)
                if (dp[t] >= stations[i][0])
                    dp[t + 1] = Math.max(dp[t + 1], dp[t] + (long) stations[i][1]);
        for (int i = 0; i <= N; ++i)
            if (dp[i] >= target) return i;
        return -1;
    }
}