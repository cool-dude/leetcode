package pramp;
public class ShiftedArraySearch {
    public static void main(String[] args) {
        int[] input=new int[]{9,12,17,2,4,5};
        int num=2;
        System.out.println(shiftedArrSearch(input,num));
    }

    static int shiftedArrSearch(int[] shiftArr, int num) {
        // your code goes here
        int start=0;
        int end=shiftArr.length;
        return shiftedArraySearchHelper(shiftArr,start,end,num);
    }

    public static int shiftedArraySearchHelper(int[] in, int start, int end, int num){
        int mid=(start+end)/2;
        System.out.println("start: "+ start+ "end: "+ end);
        if(num==in[mid])
            return mid;

        if(num>in[start] && num<in[mid]){
            return shiftedArraySearchHelper(in,start,mid-1,num);
        }
        else{
            return shiftedArraySearchHelper(in,mid+1,end-1,num);
        }
    }
}

class Soln{
    private int findPivot(int[] nums,int lo,int hi){
        if(hi<lo)
            return -1;
        if(hi==lo)
            return lo;
        int mi=lo+(hi-lo)/2;
        if(mi<hi && nums[mi]>nums[mi+1])
            return mi;
        if(mi>lo && nums[mi]<nums[mi-1])
            return (mi-1);
        if(nums[lo] >= nums[mi])
            return findPivot(nums,lo,mi-1);
        else
            return findPivot(nums,mi+1,hi);
    }

    private int binSearch(int[] nums,int lo,int hi,int key){
        if(hi>lo)
            return -1;
        int mi=lo+(hi-lo)/2;
        if(key==nums[mi])
            return mi;
        else if(key<nums[mi])
            return binSearch(nums,lo,mi-1,key);
        return binSearch(nums,mi+1,hi,key);
    }

    public int search(int[] nums, int target) {
        int n=nums.length;
        int piv=findPivot(nums,0,n-1);
        if(piv==-1)
            return binSearch(nums,0,n-1,target);
        if(nums[piv]==target)
            return piv;
        if(nums[0] <= target)
            return binSearch(nums,0,piv-1,target);
        else
            return binSearch(nums,piv+1,n-1,target);
    }
}

class Soln2{
    static int searchUtil(int arr[], int l, int h, int key) {
        if (l > h)
            return -1;

        int mid = l+(h-l)/2;
        if (arr[mid] == key)
            return mid;

        /* If arr[l...mid] first subarray is sorted */
        if (arr[l] <= arr[mid])
        {
            if (key >= arr[l] && key <= arr[mid])
                return searchUtil(arr, l, mid-1, key);
            /*If key not lies in first half subarray,
           Divide other half  into two subarrays,
           such that we can quickly check if key lies
           in other half */
            return searchUtil(arr, mid+1, h, key);
        }

        /* If arr[l..mid] first subarray is not sorted,
           then arr[mid... h] must be sorted subarry*/
        if (key >= arr[mid] && key <= arr[h])
            return searchUtil(arr, mid+1, h, key);
        return searchUtil(arr, l, mid-1, key);
    }

    static int search(int[] nums,int target){
        return searchUtil(nums,0,nums.length,target);
    }
}