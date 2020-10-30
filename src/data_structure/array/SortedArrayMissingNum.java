/*
LC#1060.
https://leetcode.com/problems/missing-element-in-sorted-array/
*
*/
class Soln{
    private int missing(int idx,int[] nums){
        return nums[idx]-(nums[0]+idx);
    }
    public int missingElement(int idx,int[] nums){
        int n=nums.length;
        if(k>missing(n-1,nums))
            return nums[n-1]+k-missing(n-1,nums);
        int= l=0,r=n-1,piv;
        while (l!=r){
            piv=l+(r-l)/2;
            if(missing(piv, nums)< k) l=piv+1;
            else r=piv;
        }
        return nums[l-1]+k-missing(l-1,nums);
    }
}