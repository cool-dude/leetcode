class Sln{
    int helper(int[] nums,int l,int h,int ky){
        if(l>h){
            return -1;
        }
        int mid=l+(h-l)/2;
        if(nums[mid]==ky){
            return mid;
        }
        //nums[l...mid] 1st subarry sorted
        if(nums[l]<=nums[mid]){
            if(ky>=nums[l] && ky<=nums[mid]){
                return helper(nums,l,mid-1,ky);
            }
            return helper(nums,mid+1, h, ky);
        }
        //nums[mid...h] sorted
        if(ky>nums[mid] && ky<=nums[h]){
            return helper(nums,mid+1, h, ky);
        }
        return helper(nums,l,mid-1,ky);
    }
    public int search(int[] nums,int target){
        return new helper(nums,0,nums.length,target);
    }
}