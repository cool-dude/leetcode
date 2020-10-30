class SlnKadane1 {
    public int sum(int[] nums) {
        int max_so_far = Integer.MIN_VALUE;
        int max_end = 0;
        int max_elem = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max_end = Math.max(max_end+nums[i],0);
            max_so_far = Math.max(max_end, max_so_far);
            max_elem = Math.max(max_elem, nums[i]);
        }
        if(max_so_far==0)
            return max_elem;
        else return max_so_far;
    }
}
/*LC209: Minimum Size Subarray Sum
https://leetcode.com/problems/minimum-size-subarray-sum/
Given an array of n positive integers
and a positive integer s, find the minimal
length of a contiguous subarray of
which the sum ≥ s. If there isn't one, return 0 instead.
Example:
Input: s = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: the subarray [4,3] has
the minimal length under the problem constraint.
Follow up:
If you have figured out the O(n) solution,
try coding another solution of which the
time complexity is O(n log n).*/
/*This is a simpler version of
LC862: Shortest Subarray with Sum at Least K.
Each element is > 0. Both the binary search
and deque solution work. However, because we
only have positive integers in the input,
we can further simplify the solution by
using sliding window + two pointers.
For each nums[i], advance the left pointer
until the window sum is < s, update the best
answer during this process. Then advance the
right pointer for the next candidate ending number.
Each number appears in the window once and kicked
out of the window at most once, the runtime is O(N)*/
class Sln2 {
    public int minSubArrayLen(int s, int[] nums) {
        int ans=nums.length+1;
        int left=0,right=0,sum=0;
        for(;right<nums.length;right++) {
            sum+=nums[right];
            while (left<=right && sum>=s){
                ans=Math.min(ans,right-left+1);
                sum-=nums[left];
                left++;
            }
        }
        return ans<=nums.length?ans:0;
    }
}
/*LC560: Subarray Sum = K
https://leetcode.com/problems/subarray-sum-equals-k/
Given an array of integers and an integer k, you
* need to find the total number of continuous subarrays
* whose sum equals to k.
Ex 1:
Input:nums = [1,1,1], k = 2
Output: 2
Note:
The length of the array is in range [1, 20,000].
The range of numbers in the array is [-1000, 1000]
* and the range of the integer k is [-1e7, 1e7].*/
/*Input: [-2,1,-3,4,-1,2,1,-5,4],
        Output: 6
        Explanation: [4,-1,2,1] has the largest sum = 6.
        Take care of all negatives also*/
class Sln3 {
    public int subArraySum(int[] nums,int k){
        Map<Integer, Integer> prevSum=new HashMap<>();
        int result=0,curSum=0,n=nums.length;
        for(int i=0;i<n;i++){
            curSum+=nums[i];
            if(curSum==k)
                result++;
            // cursum exceeds k by cursum-k.
            // Find number of subarrays having
            // k and exclude those subarrays
            // from cursum by increasing count by
            // same amount.
            if(map.containsKey(curSum-k))
                result+=prevSum.get(curSum-k);
            prevSum.put(curSum, map.getOrDefault(curSum,0)+1);
        }
        return result;
    }
    //T:O(n).
    //S:O(1).
}
/*LC862: Shortest Subarray with Sum at Least K
https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k
Return the length of the shortest, non-empty,
contiguous subarray of A with sum at least K.
If there is no non-empty subarray with sum
at least K, return -1.

Example 1:
Input: A = [1], K = 1
Output: 1

Example 2:
Input: A = [1,2], K = 4
Output: -1

Example 3:
Input: A = [2,-1,2], K = 3
Output: 3*/
/*Sln 1: Sliding Windoww
Intuition: Rephrase this as problem about prefix sums of A.
Let P[i] = A[0] + A[1] + ... + A[i-1]. We want the smallest y-x such that y > x and P[y] - P[x] >= K.

Motivated by equation, let opt(y) be the largest x such that P[x] <= P[y] - K.
We need 2 key observations:
        If x1 < x2 and P[x2] <= P[x1], then opt(y) can never be x1,
        as if P[x1] <= P[y] - K, then P[x2] <= P[x1] <= P[y] - K but y - x2 is smaller.
        This implies that our candidates x for opt(y) will have increasing values of P[x].

        If opt(y1) = x, then we do not need to consider this x again.
        For if we find some y2 > y1 with opt(y2) = x,
        then it represents an answer of y2 - x which is worse (larger) than y1 - x.
Algo:
        Maintain a "monoqueue" of indices of P:
        a deque of indices x_0, x_1, ... such that P[x_0], P[x_1], ... is increasing.

        When adding a new index y, we'll pop x_i from
        the end of the deque so that P[x_0], P[x_1], ..., P[y] will be increasing.

        If P[y] >= P[x_0] + K, then (as previously described), we don't
        need to consider this x_0 again, and we can pop it from the front of the deque.*/
class Sln4 {
    public int shortestSubarray(int[] A, int K) {
        int N = A.length;
        int[] P = new int[N+1];
        for (int i = 0; i < N; ++i)
            P[i+1] = P[i] + A[i];
        // Want smallest y-x with P[y] - P[x] >= K
        int ans = N+1; // N+1 is impossible
        Deque<Integer> monoq = new LinkedList(); //opt(y) candidates, as indices of P
        for (int y = 0; y < P.length; ++y) {
            // Want opt(y) = largest x with P[x] <= P[y] - K;
            while (!monoq.isEmpty() && P[y] <= P[monoq.getLast()])
                monoq.removeLast();
            while (!monoq.isEmpty() && P[y] >= P[monoq.getFirst()] + K)
                ans = Math.min(ans, y - monoq.removeFirst());
            monoq.addLast(y);
        }
        return ans < N+1 ? ans : -1;
    }
    //T:O(N).
    //S:O(N).
}
/*LC974: Subarray Sums Divisible by K
https://leetcode.com/problems/subarray-sums-divisible-by-k/submissions/
Given an array A of integers, return
the number of (contiguous, non-empty)
subarrays that have a sum divisible by K.

Example 1:
Input: A = [4,5,0,-2,-3,1], K = 5
Output: 7
Explanation: There are 7 subarrays with
a sum divisible by K = 5:
[4, 5, 0, -2, -3, 1], [5], [5, 0],
[5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]

* SOLN:Make auxiliary array of size k Mod[k].
* This array holds the count of remainder
* we are getting after dividing cumulative sum
* till any index in arr[].
Now start calculating cumulative sum and
* simultaneously take it’s mod with K, whichever
* remainder we get increment count by 1 for
*remainder as index Mod[] auxiliary array.
*Sub-array by each pair of positions with same
* value of ( cumSum % k) constitute continuous
* range whose sum is divisible by K.
Now traverse Mod[] auxiliary array, for any
* Mod[i] > 1 we can choose two pair of indices
* for sub-array by (Mod[i]*(Mod[i] – 1))/2 number of
* ways . Do the same for all remainders < k and
* sum up the result that will be the number all
possible sub-arrays divisible by K.*/
class Sln5 {
    public int subarraysDivByK(int[] A, int K) {
        // create auxiliary hash array to
        // count frequency of remainders
        int n=A.length;
        int[] mod=new int[K];
        Arrays.fill(mod,0);
        // Traverse original array and compute cumulative
        // sum take remainder of this current cumulative
        // sum and increase count by 1 for this remainder
        // in mod[] array
        int cumSum=0;
        for(int i=0;i<n;i++){
            cumSum+=A[i];
            // as the sum can be negative, taking modulo twice
            mod[((cumSum % K) + K) % k]++;
        }
        int result=0;
        for(int i=0;i<k;i++)
            if(mod[i]>1)
                result+=(mod[i]*(mod[i]-1))/2;
        // add elements divisible by k itself
        // i.e., the elements whose sum = 0
        result+=mod[0];
        return result;
    }
}
/*LC992. Subarrays with K Different Integers
* https://leetcode.com/problems/subarrays-with-k-different-integers/submissions/
Given an array A of positive integers, call a
* (contiguous, not necessarily distinct) subarray of
* A good if the number of different integers in that subarray is exactly K.
(For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.)
Return the number of good subarrays of A.

Example 1:
Input: A = [1,2,1,2,3], K = 2
Output: 7
Explanation: Subarrays formed with exactly 2 different
* integers: [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2].

* Example 2:
Input: A = [1,2,1,3,4], K = 3
Output: 3
Explanation: Subarrays formed with exactly 3 different integers:
* [1,2,1,3], [2,1,3], [1,3,4].
* Intuition
For convenience,
* let's denote subarrays by tuples: (i,j) = [A[i], A[i+1], ..., A[j]],
* and call a subarray valid if it has K different integers.

For each j, let's consider the set Sj
​of all i such that the subarray (i, j) is valid.

Firstly, Sj must be a contiguous interval.
* If i1 < i2 < i3, (i1,j) and (i3,j) are valid,
* but (i2,j) is not valid, this is a contradiction
* because (i2,j) must contain more than K different elements
* [as (i3,j) contains K], but (i1,j) [which is a superset of (i2,j)] only contains K different integers.

So now let's write Sj as intervals: Sj = [left1j, left2j]
The second observation is that the endpoints of these
* intervals must be monotone increeasing - namely, left1j and left2j​
  are monotone increasing. With similar logic to the above,
  * we could construct a proof of this fact, but the
  * intuition is that after adding an extra
  * element to our subarrays, they are already
  * valid, or we need to shrink them a bit to keep them valid.*/
class Window{
    Map<Integer, Integer> count;
    int distinctCount;
    Window(){
        count=new HashMap<>();
    }
    void add(int x){
        count.put(x, count.getOrDefault(x,0)+1);
        if(count.get(x)){
            distinctCount++;
        }
    }
    void remove(int x){
        count.put(x, count.get(x)-1);
        if(count.get(x)==0){
            distinctCount--;
        }
    }
    int getDistinctCount(){
        return distinctCount;
    }
}
class Sln{
    public int subarraysWithKDistinct(int[] arr, int k) {
        Window w1=new Window();
        Window w2=new Window();
        int ans=0,l1=0,l2=0;
        for(int r=0;r<arr.length;r++){
            int x=arr[r];
            w1.add(x);
            w2.add(x);
            while (w1.distinctCount()>k){
                w1.remove(arr[l1++]);
            }
            while (w2.distinctCount()>=k){
                w2.remove(arr[l2++]);
            }
            ans+=l2-l1;
        }
        return ans;
    }
}
/*LC1477: Find Two Non-overlapping Sub-arrays
https://leetcode.com/problems/find-two-non-overlapping-sub-arrays-each-with-target-sum/
Given an array of integers arr and an integer target.

You have to find two non-overlapping sub-arrays
of arr each with sum equal target. There can be
multiple answers so you have to find an answer
where the sum of the lengths of the two sub-arrays
is minimum.

Return the minimum sum of the lengths of the two
required sub-arrays, or return -1 if you cannot
find such two sub-arrays.

Example 1:
Input: arr = [3,2,2,4,3], target = 3
Output: 2
Explanation: Only two sub-arrays have sum = 3 ([3] and [3]). The sum of their lengths is 2.

Example 2:
Input: arr = [7,3,4,7], target = 7
Output: 2
Explanation: Although we have three non-overlapping sub-arrays of sum = 7 ([7], [3,4] and [7]),
but we will choose the first and third sub-arrays as the sum of their lengths is 2.

Example 3:
Input: arr = [4,3,2,6,2,3,4], target = 6
Output: -1
Explanation: We have only one sub-array of sum = 6.

Example 4:
Input: arr = [5,5,4,4,5], target = 3
Output: -1
Explanation: We cannot find a sub-array of sum = 3.

Example 5:
Input: arr = [3,1,1,1,5,1,2,1], target = 3
Output: 3
Explanation: Note that sub-arrays [1,2] and [2,1] cannot be an answer because they overlap.
Constraints:
1 <= arr.length <= 10^5
1 <= arr[i] <= 1000
1 <= target <= 10^8
ALGO:1. see, mot of the people confused this with 560.
Subarray Sum Equals K off course that would give correct answer,
no doubt about that. But I think we can leverage the constraint here,
which says a[i] >= 1 due to this constraint we don't need a HashMap here.
Problem can be solved by vanilla sliding window.*/
class Sln{
    public int minSumOfLengths(int[] arr,int target){
        int n = arr.length, ans = Integer.MAX_VALUE, bestSoFar = Integer.MAX_VALUE;
        int[] best = new int[n];
        Arrays.fill(best, Integer.MAX_VALUE);
        int start = 0, sum = 0;
        for(int i = 0; i < n; i++) {
            sum += arr[i];
            while(sum > target) {
                sum -= arr[start++];
            }
            if(sum == target) {
                if(start > 0 && best[start - 1] < Integer.MAX_VALUE) {
                    ans = Math.min(ans, best[start - 1] + i - start + 1);
                }
                bestSoFar = Math.min(bestSoFar, i - start + 1);
            }
            best[i] = bestSoFar;
        }
        return ans < Integer.MAX_VALUE ? ans : -1;
    }
}
/*LC1546. Maximum Number of Non-Overlapping
Subarrays With Sum Equals Target
https://leetcode.com/problems/maximum-number-of-non-overlapping-subarrays-with-sum-equals-target/
Given an array nums and an integer target.
Return the maximum number of non-empty non-overlapping
subarrays such that the sum of values in each subarray is equal to target.
Example 1:
Input: nums = [1,1,1,1,1], target = 2
Output: 2
Explanation: There are 2 non-overlapping subarrays [1,1,1,1,1] with sum equals to target(2).

Example 2:
Input: nums = [-1,3,5,1,4,2,-9], target = 6
Output: 2
Explanation: There are 3 subarrays with sum equal to 6.
([5,1], [4,2], [3,5,1,4,2,-9]) but only the first 2 are non-overlapping.

Example 3:
Input: nums = [-2,6,6,3,5,4,1,2,8], target = 10
Output: 3

Example 4:
Input: nums = [0,0,0], target = 0
Output: 3*/
class Sln {
    public int maxNonOverlapping(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        int res = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            if (map.containsKey(sum - target)) {
                res = Math.max(res, map.get(sum - target) + 1);
            }
            map.put(sum, res);
        }
        return res;
    }
}