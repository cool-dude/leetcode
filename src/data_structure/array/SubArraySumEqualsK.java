/*LC560: Subarray Sum Equals K
https://leetcode.com/problems/subarray-sum-equals-k/
Given an array of integers and an integer k, you
* need to find the total number of continuous subarrays
* whose sum equals to k.

Example 1:
Input:nums = [1,1,1], k = 2
Output: 2
Note:
The length of the array is in range [1, 20,000].
The range of numbers in the array is [-1000, 1000]
* and the range of the integer k is [-1e7, 1e7].*/
class Sln {
    public int subarraySum(int[] nums,int k){
        int c=0,sum=0;
        HashMap<Integer, Integer> map=new HashMap<>();
        map.put(0,1);
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(map.containsKey(sum-k))
                c+=map.get(sum-k);
            map.put(sum, map.getOrDefault(sum,0)+1);
        }
        return c;
    }
    //T:O(n)
    //S:O(n).
}