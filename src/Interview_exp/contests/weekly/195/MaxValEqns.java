/*LC1499: Max Value of Equation
https://leetcode.com/problems/max-value-of-equation/
Given an array points containing the coordinates of
points on a 2D plane, sorted by the x-values,
where points[i] = [xi, yi] such that xi < xj
for all 1 <= i < j <= points.length. You are
also given an integer k.

Find the maximum value of the equation yi + yj + |xi - xj|
 where |xi - xj| <= k and 1 <= i < j <= points.length.
 It is guaranteed that there exists at least one pair
 of points that satisfy the constraint |xi - xj| <= k.

Example 1:
Input: points = [[1,3],[2,0],[5,10],[6,-10]], k = 1
Output: 4
Explanation: The first two points satisfy the condition
|xi - xj| <= 1 and if we calculate the equation we get 3 + 0 + |1 - 2| = 4.
Third and fourth points also satisfy the condition and give a value of 10 + -10 + |5 - 6| = 1.
No other pairs satisfy the condition, so we return the max of 4 and 1.

Example 2:
Input: points = [[0,0],[3,0],[9,2]], k = 3
Output: 3
Explanation: Only the first two points have an
absolute difference of 3 or less in the x-values,
and give the value of 0 + 0 + |0 - 3| = 3.

Constraints:
2 <= points.length <= 10^5
points[i].length == 2
-10^8 <= points[i][0], points[i][1] <= 10^8
0 <= k <= 2 * 10^8
points[i][0] < points[j][0] for all 1 <= i < j <= points.length
xi form a strictly increasing sequence.
We need to track the maximum yi - xi we have seen so far. As we process the next point j, we:

Get the maximum yi - xi within reach (xj - xi <= k).
Check if yi - xi + yj + xj produces the biggest result so far.
Adjust maximum using the new point: yj - xj.
Solution
We can use the sliding window technique and
monotonically decreasing deque d.
The maximum yi - xi therefore will be in the front.
For the deque, we can just store the index j there to make it faster.

First, remove items that got out of the xj - xi
window from the front of the queue.
sThen, we compute our value.
 Finally, we add i to the deque,
 making sure we keep monotonicity (nice word, thank you Word!)
 of y - x. In other words,we just remove all
 elements with smaller y - x from the back of the deque.
Term: yi-xi+yj+xj=> yi+yj+xj-xi*/
class Sln1 {
    public int findMaxValueOfEquation(int[][] points, int k) {
        Deque<Integer> d = new LinkedList<>();
        int res = Integer.MIN_VALUE;
        for (int j = 0; j < p.length; ++j) {
            while (!d.isEmpty() && p[j][0] - p[d.peek()][0] > k)
                d.poll();
            if (!d.isEmpty())
                res = Math.max(res, p[d.peek()][1] - p[d.peek()][0] + p[j][1] + p[j][0]);
            while (!d.isEmpty() && p[d.peekLast()][1] - p[d.peekLast()][0] < p[j][1] - p[j][0])
                d.pollLast();
            d.addLast(j);
        }
        return res;
    }
}

class Sln2 {
    public int findMaxValueOfEquation(int[][] points, int k) {
        int result = Integer.MIN_VALUE;
        LinkedList<int[]> list = new LinkedList<>();
        for (int[] point : points) {
            while (list.size() > 0 && point[0] - list.getFirst()[0] > k) {
                list.pollFirst();
            }
            if (list.size() > 0) {
                int curVal = point[1] - point[0];
                result = Math.max(result, point[0] + point[1] + list.getFirst()[1] - list.getFirst()[0]);
                while (list.size() > 0 && (list.getLast()[1] - list.getLast()[0]) <= curVal) {
                    list.pollLast();
                }
            }
            list.offer(point);
        }
        return result;
    }
}