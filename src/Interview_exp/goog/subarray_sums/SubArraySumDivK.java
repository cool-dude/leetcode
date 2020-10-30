/*LC974: Subarray Sums Divisible by K
https://leetcode.com/problems/subarray-sums-divisible-by-k/
Given an array A of integers, return the
number of (contiguous, non-empty) subarrays that have a sum divisible by K.
Example 1:
Input: A = [4,5,0,-2,-3,1], K = 5
Output: 7
Explanation: There are 7 subarrays with a sum divisible by K = 5:
[4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
Note:
1 <= A.length <= 30000
-10000 <= A[i] <= 10000
2 <= K <= 10000*/
class Sln {
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
            mod[((cumSum % K) + K) % K]++;
        }
        int result=0;
        for(int i=0;i<K;i++)
            if(mod[i]>1)
                result+=(mod[i]*(mod[i]-1))/2;
        // add elements divisible by k itself
        // i.e., the elements whose sum = 0
        result+=mod[0];
        return result;
    }
}