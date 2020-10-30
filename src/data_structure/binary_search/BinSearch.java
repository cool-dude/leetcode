public class RotatedSortedArray {
    int binSearch(int[] nums,int lo,int hi,int key){
        while (lo<=hi){
            int mi=lo+(hi-lo)/2;
            if(nums[mi]==key)
                return mi;
            else if(nums[mi]>key)
                hi=mi-1;
            else
                lo=mi+1;
        }
        return -1;
    }
    int findPivot(int[] a,int lo,int hi){
        if(hi<lo){
            return -1;
        }
        if(lo==hi){
            return lo;
        }
        int mi=lo+(hi-lo)/2;
        //mi is pivot/direction change
        if(mi<hi && a[mi]>a[mi+1]){
            return mi;
        }
        if(mi>lo && a[mi]<a[mi-1]){
            return mi-1;
        }
        if(a[lo]>=a[mi]){
            return findPivot(a,lo,mi-1);
        }
        else {
            return findPivot(a,mi+1,hi);
        }
    }
    public boolean search(int[] nums, int target) {
        if (nums.length == 0 || nums == null) return false;
        int n=nums.length;
        int piv = findPivot(nums, 0, n-1);
        //not a rotated array
        if(piv==-1){
            return binSearch(nums,0,n-1,target);
        }
        if(nums[piv]==target){
            return true;
        }
        int res=0;
        //first search left half
        if(nums[0]<=target){
            res=binSearch(nums,0,piv-1,target);
        }
        else {
            res=binSearch(nums, piv+1, n-1, target);
        }
        return (res!=-1);
    }
}