/*Input: [-2,1,-3,4,-1,2,1,-5,4],
        Output: 6
        Explanation: [4,-1,2,1] has the largest sum = 6.
        Take care of all negatives also
 */
//Kadane's algorithm
//With both positive negative
class Sln1 {
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
class Sln2{
    public int subArraySum(int[] nums,int k){
        HashMap<Integer, Integer> map=new HashMap<>();
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
                result+=map.get(curSum-k);
            map.put(curSum, map.getOrDefault(curSum,0)+1);
        }
        return result;
    }
    //T:O(n).
    //S:O(1).
}

/*SLN-3
Given an array of unsorted integers and number N,
find out number of continuous sub sequences where each sub sequence sum is N.
Example -
Input -
N = 6
[2,4,1,5,6]
Output = 3*/
class Sln3{
    public static int solve(int[] nums,int k){
        int[] dp=new int[nums.length+1];
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,0);
        int sum=0;
        for(int i=1;i<=nums.length;i++){
            dp[i]=dp[i-1];
            sum+=nums[i-1];
            map.put(sum,i);
            if(map.containsKey(sum-k)){
                dp[i]=Math.max(dp[i],dp[map.get(sum-k)+1]);
            }
        }
        return dp[nums.length];
    }
    public static void main(String[] args) {
        int[] nums = {2,4,1,5,6};
        int k = 6;
        System.out.println(solve(nums, k));
    }
}
/*LC862: Shortest Subarray with Sum at Least K
https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/
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
Output: 3
1 <= A.length <= 50000
-10 ^ 5 <= A[i] <= 10 ^ 5
1 <= K <= 10 ^ 9 */
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
class Sln1 {
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
class Sln2 {
    public int shortestSubarray(int[] A, int K) {
        int n = A.length, best = A.length + 1;
        long sum = 0;
        ArrayDeque<Long> dq1 = new ArrayDeque<>();
        ArrayDeque<Integer> dq2 = new ArrayDeque<>();
        dq1.add(0L);
        dq2.add(-1);
        for(int i = 0; i < n; i++) {
            sum += A[i];
            int j = A.length;
            while(dq1.size() > 0 && dq1.peekFirst() <= sum - K) {
                dq1.pollFirst();
                j = dq2.pollFirst();
            }
            if(j < A.length) {
                best = Math.min(best, i - j);
            }
            while(dq1.size() > 0 && dq1.peekLast() >= sum) {
                dq1.pollLast();
                dq2.pollLast();
            }
            dq1.addLast(sum);
            dq2.addLast(i);
        }
        return best > A.length ? -1 : best;
    }
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
class Sln{
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