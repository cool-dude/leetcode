/*LC485: Max Consecutive Ones
https://leetcode.com/problems/max-consecutive-ones/
Given a binary array, find the
maximum number of consecutive 1s in this array.
Example 1:
Input: [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s.
    The maximum number of consecutive 1s is 3.
Note:
The input array will only contain 0 and 1.
The length of input array is a positive
integer and will not exceed 10,000 */
class Sln1 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int len=0,max=0;
        for(int i=0;i<nums.length;i++){
            max=Math.max(max,len=nums[i]==1?len+1:0);
        }
        return max;
    }
}
/*LC487. Max Consecutive Ones II
https://leetcode.com/problems/max-consecutive-ones-ii/
Given a binary array, find the maximum number
of consecutive 1s in this array if you can flip at most one 0.
Example 1:
Input: [1,0,1,1,0]
Output: 4
Explanation: Flip the first zero will get the the maximum number of consecutive 1s.
    After flipping, the maximum number of consecutive 1s is 4.
Note:
The input array will only contain 0 and 1.
The length of input array is a positive integer and will not exceed 10,000
Follow up:
What if the input numbers come in one by one as an infinite
stream? In other words, you can't store all numbers coming from
the stream as it's too large to hold in memory. Could you solve it efficiently?*/
class Sln2 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, zero = 0, k = 1; // flip at most k zero
        for (int l = 0, h = 0; h < nums.length; h++) {
            if (nums[h] == 0)
                zero++;
            while (zero > k)
                if (nums[l++] == 0)
                    zero--;
            max = Math.max(max, h - l + 1);
        }
        return max;
    }
    //T:O(n).
    //S:O(1).
}
/*LC1004: Max Consecutive Ones III
https://leetcode.com/problems/max-consecutive-ones-iii/
Given an array A of 0s and 1s,
we may change up to K values from 0 to 1.

Return the length of the longest (contiguous)
subarray that contains only 1s.

Example 1:
Input: A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
Output: 6
Explanation:
[1,1,1,0,0,1,1,1,1,1,1]
Bolded numbers were flipped from 0 to 1.
The longest subarray is underlined.

Example 2:
Input: A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
Output: 10
Explanation:
[0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
Bolded numbers were flipped from 0 to 1.  The longest subarray is underlined.*/
class Sln3 {
    public int longestOnes(int[] A, int k) {
        int i=0,j;
        for(j=0;j<A.length;j++){
            if(A[j]==0) k--;
            if(k<0 && A[i++]==0) k++;
        }
        return j-i;
    }
}
//T:O(n).
//S:O(1).