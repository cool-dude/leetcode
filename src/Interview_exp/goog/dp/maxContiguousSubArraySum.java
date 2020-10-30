class Solution {
    public int maxSubArray(int[] nums) {
        int n=nums.length;
        int cur=nums[0],max=nums[0];

        for(int i=1;i<n;i++){
            cur = Math.max(nums[i], cur+nums[i]);
            max = Math.max(max,cur);
        }
        return max;
    }
}