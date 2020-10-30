class Solution {
    private int first(int[] nums,int lo,int hi,int k){
        while (hi>=lo){
            int mi=lo+(hi-lo)/2;
            if(mi==lo||(k>nums[mi-1] && k==nums[mi]))
                return mi;
            else if(k>nums[mi])
                return first(nums,mi+1,hi,k);
            else
                return first(nums,0,mi-1,k);
        }
        return -1;
    }
    private int last(int[] nums, int lo,int hi,int k){
        while (hi>=lo){
            int mi=lo+(hi-lo)/2;
            if(mi==hi ||(k==nums[mi] && k<nums[mi+1]))
                return mi;
            else if(k<nums[mi])
                return last(nums,lo,mi-1, k);
            else
                return last(nums,mi+1, hi, k);
        }
        return -1;
    }
    public int[] searchRange(int[] nums, int target) {
        int n=nums.length;
        int[] targetRange={-1,-1};
        if(n<=1)
            return targetRange;
        targetRange[0]=first(nums,0,n-1,target);
        targetRange[1]=last(nums,0,n-1,target);
        return targetRange;
    }
}


class Soln2{
    // returns leftmost (or rightmost) index at which `target` should be
    // inserted in sorted array `nums` via binary search.
    private int extremeInsertionIndex(int[] nums, int target, boolean left) {
        int lo = 0;
        int hi = nums.length;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] > target || (left && target == nums[mid])) {
                hi = mid;
            }
            else {
                lo = mid+1;
            }
        }
        return lo;
    }
    public int[] searchRange(int[] nums, int target) {
        int[] targetRange = {-1, -1};
        int leftIdx = extremeInsertionIndex(nums, target, true);
        // assert that `leftIdx` is within the array bounds and that `target`
        // is actually in `nums`.
        if (leftIdx == nums.length || nums[leftIdx] != target) {
            return targetRange;
        }
        targetRange[0] = leftIdx;
        targetRange[1] = extremeInsertionIndex(nums, target, false)-1;
        return targetRange;
    }
}