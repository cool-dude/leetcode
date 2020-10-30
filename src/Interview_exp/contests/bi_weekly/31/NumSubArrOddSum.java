/*LC1524: Number of Sub-arrays With Odd Sum
https://leetcode.com/problems/number-of-sub-arrays-with-odd-sum/
Given an array of integers arr.
Return the number of sub-arrays with odd sum.

As the answer may grow large, the
answer must be computed modulo 10^9 + 7.

Example 1:
Input: arr = [1,3,5]
Output: 4
Explanation: All sub-arrays are [[1],[1,3],[1,3,5],[3],[3,5],[5]]
All sub-arrays sum are [1,4,9,3,8,5].
Odd sums are [1,9,3,5] so the answer is 4.

Example 2:
Input: arr = [2,4,6]
Output: 0
Explanation: All sub-arrays are [[2],[2,4],[2,4,6],[4],[4,6],[6]]
All sub-arrays sum are [2,6,12,4,10,6].
All sub-arrays have even sum and the answer is 0.

Example 3:
Input: arr = [1,2,3,4,5,6,7]
Output: 16

Example 4:
Input: arr = [100,100,99,99]
Output: 4

Example 5:
Input: arr = [7]
Output: 1*/
class Sln1 {
    public int numOfSubarrays(int[] arr) {
        int res = 0;
        for (int i = 0; i < n; i++) {
            int val = 0;
            for (int j = i; j < n; j++) {
                val += arr[j];
                if (val % 2 != 0)
                    res++;
            }
        }
        return res;
    }
}
/*If we know the number of even and odd subarrays
that end at the previous element, we can
figure out how many even and odd subarrays
we have for element n:

If n is even, we increase the number of
even subarrays; the number of odd subarrays
does not change.
If n is odd, the number of odd subarrays is the
previous number of even subarrays + 1.
The number of even subarrays is the
previous number of odd subarrays.
Looking at this example:
Array: [1, 1, 2, 1]  Total
Odd:    1  1  1  3     6
Even:   0  1  2  1*/
class Sln2{
    static int MOD=1000000007;
    public int numOfSubarrays(int[] arr){
        int sum=0;
        for(int i=0,odd=0;i<arr.length;i++) {
            if(arr[i]%2==1)
                odd=(i-odd)+1;
            sum=(sum+odd)%MOD;
        }
        return sum;
    }
}