class Sln{
    public int maxSum(int[] nums){
        int n=nums.length,max=Integer.MIN_VALUE;
        for(int i=0;i<n-2;i++)
            for(int j=i+1;j<n-2;j++)
                for(int k=j+1;k<n;k++)
                    if(nums[i]<nums[j] && nums[j]<nums[k])
                        max=Math.max(max,nums[i]-nums[j]+nums[k]);
        return max;
    }
    //T:O(n^3).
    //S:O(1).
    public int maxSumOpt(int[] nums){
        int maxK=Integer.MIN_VALUE, max=Integer.MIN_VALUE,n=nums.length;
        for(int i=0;i<n;i++){
            maxK=Math.max(maxK,nums[i]);
        }
        for(int i=0;i<n-1;i++)
            for(int j=i+1;j<n;j++)
                if(nums[i]<nums[j] && nums[j]>maxK)
                    max=Math.max(max, nums[i]-nums[j]+maxK);
        return max;
    }
}