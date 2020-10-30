/*LC1552: Magnetic Force Between Two Balls
In universe Earth C-137, Rick discovered a special
form of magnetic force between two balls if they are
put in his new invented basket. Rick has n empty baskets,
the ith basket is at position[i], Morty has m balls
and needs to distribute the balls into the baskets
such that the minimum magnetic force between any two balls is maximum.
Rick stated that magnetic force between two different balls at positions x and y is |x - y|.

Given the integer array position and the integer m. Return the required force.

Example 1:
Input: position = [1,2,3,4,7], m = 3
Output: 3
Explanation: Distributing the 3 balls into baskets 1, 4 and
7 will make the magnetic force between ball pairs [3, 3, 6].
The minimum magnetic force is 3. We cannot achieve a larger
minimum magnetic force than 3.
Example 2:
Input: position = [5,4,3,2,1,1000000000], m = 2
Output: 999999999
Explanation: We can use baskets 1 and 1000000000.*/
class Sln {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int lo = 0;
        int hi = position[position.length-1];
        int optimal = 0;
        while (lo <= hi) {
            int mid = lo + (hi-lo)/2;
            if (canPut(position, m, mid)) {
                optimal = mid;
                lo = mid+1;
            } else {
                hi = mid-1;
            }
        }
        return optimal;
    }
    /*Returns whether we can put m balls so
    that maximum distance between any two balls not exceed max*/
    boolean canPut(int[] positions, int m, int max) {
        int count = 1;
        int last = positions[0];
        for (int i = 0; i < positions.length; i++) {
            if (positions[i] - last >= max) {
                last = positions[i];
                count++;
            }
        }
        return count >= m;
    }
}
https://leetcode.com/problems/divide-chocolate/
https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/
https://leetcode.com/problems/split-array-largest-sum/
https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
https://leetcode.com/problems/minimize-max-distance-to-gas-station/
https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/
https://leetcode.com/problems/magnetic-force-between-two-balls/