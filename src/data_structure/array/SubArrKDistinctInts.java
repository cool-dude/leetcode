/*LC992: Subarrays with K Different Integers
Given an array A of positive integers, call a
* (contiguous, not necessarily distinct) subarray
* of A good if the number of different integers in that subarray is exactly K.
(For example, [1,2,3,1,2] has 3 different
* integers: 1, 2, and 3.)
Return the number of good subarrays of A.

Example 1:
Input: A = [1,2,1,2,3], K = 2
Output: 7
Explanation: Subarrays formed with exactly 2
* different integers: [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2].
Example 2:

Input: A = [1,2,1,3,4], K = 3
Output: 3
Explanation: Subarrays formed with exactly 3
* different integers: [1,2,1,3], [2,1,3], [1,3,4].
*
*
* ALGO:Intuition
For convenience,
* let's denote subarrays by tuples:
* (i,j) = [A[i], A[i+1], ..., A[j]],
* and call a subarray valid if it has K different integers.

For each j, let's consider the set S_jS
j of all i such that the subarray (i, j)
* is valid.

Firstly, S_jS j must be a contiguous interval.
* If i1 < i2 < i3, (i1,j) and (i3,j) are valid,
* but (i2,j) is not valid, this is a
* contradiction because (i2,j) must contain
* more than K different elements [as (i3,j)
* contains K], but (i1,j) [which is a superset
* of (i2,j)] only contains K different integers.

So now let's write S_jS j as
* intervals: S_j = [left1_j, left2_j]
​
 =[left1
j
​
 ,left2
j
​
 ].

The second observation is that the endpoints of these intervals must be monotone increeasing - namely, \text{left1}_jleft1
j
​
  and \text{left2}_jleft2
j
​
  are monotone increasing. With similar logic to the above, we could construct a proof of this fact, but the intuition is that after adding an extra element to our subarrays, they are already valid, or we need to shrink them a bit to keep them valid.
 */
class Solution {
    public int subarraysWithKDistinct(int[] A, int K) {
        Window window1 = new Window();
        Window window2 = new Window();
        int ans = 0, left1 = 0, left2 = 0;
        for (int right = 0; right < A.length; ++right) {
            int x = A[right];
            window1.add(x);
            window2.add(x);
            while (window1.different() > K)
                window1.remove(A[left1++]);
            while (window2.different() >= K)
                window2.remove(A[left2++]);
            ans += left2 - left1;
        }
        return ans;
    }
}
class Window {
    Map<Integer, Integer> count;
    int nonzero;
    Window() {
        count = new HashMap();
        nonzero = 0;
    }
    void add(int x) {
        count.put(x, count.getOrDefault(x, 0) + 1);
        if (count.get(x) == 1)
            nonzero++;
    }
    void remove(int x) {
        count.put(x, count.get(x) - 1);
        if (count.get(x) == 0)
            nonzero--;
    }
    int different() {
        return nonzero;
    }
}
//T:O(N).
//S:O(N).