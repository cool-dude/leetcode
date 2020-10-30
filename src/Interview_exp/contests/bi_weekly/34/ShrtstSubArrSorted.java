/*LC1574: Shortest Subarray to be Removed to Make Array Sorted
https://leetcode.com/problems/shortest-subarray-to-be-removed-to-make-array-sorted/
Given an integer array arr, remove a subarray (can be empty)
from arr such that the remaining elements in arr are non-decreasing.
A subarray is a contiguous subsequence of the array.
Return the length of the shortest subarray to remove.
Example 1:
Input: arr = [1,2,3,10,4,2,3,5]
Output: 3
Explanation: The shortest subarray we can remove is [10,4,2]
of length 3. The remaining elements after that will be [1,2,3,3,5] which are sorted.
Another correct solution is to remove the subarray [3,10,4].

Example 2:
Input: arr = [5,4,3,2,1]
Output: 4
Explanation: Since the array is strictly decreasing, we can only
keep a single element. Therefore we need to remove a subarray of
length 4, either [5,4,3,2] or [4,3,2,1].

Example 3:
Input: arr = [1,2,3]
Output: 0
Explanation: The array is already non-decreasing. We do
not need to remove any elements.

Example 4:
Input: arr = [1]
Output: 0
Constraints:
1 <= arr.length <= 10^5
0 <= arr[i] <= 10^9
You need to find some sequence from 0th index which is in increasing order,
let this sequence a_1 <= a_2 <= ... <= a_i
Then you need to find some sequence from the back which is
in decreasing order such that b_j <= b_(j+1) <= ... <= b_n (j <= i)
Then it is guranteed you need to remove subarray from (i + 1, j - 1).
But it is possible if we could merge some part from b_j <= b_(j+1) <= ...
<= b_n, with a_1 <= a_2 <= ... <= a_i, to create a bigger increasing subarray.*/
class Sln{
    public int findLengthOfShortestSubarray(int[] arr){
        int l=0;
        while (l+r<arr.length && arr[l]<=arr[l+1]) l++;
        if(l==arr.length-1) return 0;
        int r=arr.length-1;
        while (r>l && arr[r-1]<=arr[r]) r--;
        int res=Math.min(arr.length-l-1,r);
        int i=0,j=r;
        while (i<=l && j<arr.length){
            if(arr[j]>=arr[i]){
                res=Math.min(res,j-i-1);
                i++;
            }
            else
                j++;
        }
        return res;
    }
}