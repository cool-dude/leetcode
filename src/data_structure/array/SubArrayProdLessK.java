public class Sln{
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int start=0,end=1;
        int prod=nums[0];
        int count=0;
        while(start<=end && end<=nums.length){
            if(prod<k){
                count += end-start;
                if(end < nums.length) prod*=nums[end++];
            }
            else{
                prod/=nums[start++];
            }
        }
        return count;
    }
}
//T:O(n)