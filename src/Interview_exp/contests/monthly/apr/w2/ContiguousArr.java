/*
* Given a binary array,
* find the maximum length of
* contiguous subarray with equal number of 0 and 1.

Example 1:
Input: [0,1]
Output: 2
Explanation: [0, 1] is the longest
* contiguous subarray with equal number of 0 and 1.

* Example 2:
Input: [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a
* longest contiguous subarray with equal number of 0 and 1.*/
class Solution {
    public int findMaxLength(int[] nums) {
        int n=nums.length;
        for(int i=0;i<nums.length;i++)
            if(nums[i]==0) nums[i]=-1;
        HashMap<Integer,Integer> sumToIdx=new HashMap<>();
        sumToIdx.put(0,-1);
        int sum=0,max=0;

        for(int i=0;i<n;i++){
            sum+=nums[i];
            if(sumToIdx.containsKey(sum))
                max=Math.max(max,i-sumToIdx.get(sum));
            else
                sumToIdx.put(sum,i);
        }
        return max;
    }
}