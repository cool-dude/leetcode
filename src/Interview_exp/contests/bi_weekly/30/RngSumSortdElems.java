/*LC1508: Range Sum of Sorted Subarray Sums
https://leetcode.com/problems/range-sum-of-sorted-subarray-sums/
Given the array nums consisting of n positive
integers. You computed the sum of all non-empty
continous subarrays from the array and then sort
them in non-decreasing order, creating a new array
of n * (n + 1) / 2 numbers.

Return the sum of the numbers from index left to
index right (indexed from 1), inclusive, in the
new array. Since the answer can be a huge number
return it modulo 10^9 + 7.

Example 1:
Input: nums = [1,2,3,4], n = 4, left = 1, right = 5
Output: 13
Explanation: All subarray sums are 1, 3, 6, 10, 2, 5, 9, 3, 7, 4. After sorting them in non-decreasing order we have the new array [1, 2, 3, 3, 4, 5, 6, 7, 9, 10]. The sum of the numbers from index le = 1 to ri = 5 is 1 + 2 + 3 + 3 + 4 = 13.

Example 2:
Input: nums = [1,2,3,4], n = 4, left = 3, right = 4
Output: 6
Explanation: The given array is the same as example 1. We have the new array [1, 2, 3, 3, 4, 5, 6, 7, 9, 10]. The sum of the numbers from index le = 3 to ri = 4 is 3 + 3 = 6.

Example 3:
Input: nums = [1,2,3,4], n = 4, left = 1, right = 10
Output: 50
SLN:To understand basic idea, let's take an
example of [1, 2, 3] and priority_queue<Pair<sum, index>>

Insert all elements of array and their
 indexes into a priority queue-> (1, 1), (2, 2), (3, 3)
Pop element e with minimum sum and insert
new element with index = e.index+1 and sum = e.sum+nums[index+1]
So in high level we are inserting 0th element
with sum of all the elements in right which is (1, 2, ..,n)
1st element we are inserting with sum of all the elements in right which is (2, 3 ... n)*/
class Solution {
    class Pair{
        int sum,idx;
        public Pair(int _sum,int _idx){
            this.sum=_sum;
            this.idx=_idx;
        }
    }
    public int rangeSum(int[] nums, int n, int left, int right) {
        int mod = (int)1e9 + 7;
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.sum-b.sum);
        for(int i=0;i<n;i++)
            pq.offer(new Pair(nums[i],i));
        left--;right--;
        int ans=0;
        for(int i=0;i<=right;i++) {
            Pair p=pq.poll();
            if(i>=left){
                ans=(ans+p.sum)%mod;
            }
            if(p.idx<n-1){
                p.sum=(p.sum%mod+nums[++p.idx]%mod)%mod;
                pq.offer(p);
            }
        }
        return ans;
    }
}