/*LC1493: Longest Subarray of 1's After Deleting One Element
https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/
Given a binary array nums, you should
delete one element from it.
Return the size of the longest non-empty
subarray containing only 1's in the resulting array.

Return 0 if there is no such subarray.

Example 1:
Input: nums = [1,1,0,1]
Output: 3
Explanation: After deleting the number in position 2,
[1,1,1] contains 3 numbers with value of 1's.

Example 2:
Input: nums = [0,1,1,1,0,1,1,0,1]
Output: 5
Explanation: After deleting the number in position 4,
[0,1,1,1,1,1,0,1] longest subarray with value of 1's is [1,1,1,1,1].

Example 3:
Input: nums = [1,1,1]
Output: 2
Explanation: You must delete one element.

Example 4:
Input: nums = [1,1,0,0,1,1,1,0,1]
Output: 4

Example 5:
Input: nums = [0,0,0]
Output: 0
Almost exactly same as 1004. Max Consecutive Ones III
Given an array A of 0s and 1s,
we may change up to k = 1 values from 0 to 1.
Return the length - 1 of the longest (contiguous) subarray that contains only 1s.

I felt we discuss the same sliding window solution every two weeks..
And I continue to receive complaints that
I didn't give explantion again and again.*/
class Sln {
    public int longestSubarray(int[] A) {
        int i = 0, j, k = 1;
        for (j = 0; j < A.length; ++j) {
            if (A[j] == 0) k--;
            if (k < 0 && A[i++] == 0) k++;
        }
        return j - i - 1;
    }
}