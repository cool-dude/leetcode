/*Example:
Input: arr[] = {8, 4, 2, 1}
Output: 6

Explanation: Given array has six inversions:
(8,4), (4,2),(8,2), (8,1), (4,1), (2,1).


Input: arr[] = {3, 1, 2}
Output: 2

Explanation: Given array has two inversions:
(3, 1), (3, 2) */
class Sln{
    int mergeHelper(int[] nums,int l,int m,int r){
        int[] left=Arrays.copyOfRange(nums,l,m);
        int[] right=Arrays.copyOfRange(nums,m+1,r);
        int i=0,j=0,k=0,swaps=0;
        while (i<left.length && j<right.length){
            if(left[i]<=right[j]){
                nums[k++]=left[i++];
            }
            else{
                nums[k++]=right[j++];
                swaps=m-i;
            }
        }
        while (i<left.length)
            nums[k++]=left[i++];
        while (j<right.length)
            nums[k++]=right[j++];
        return swaps;
    }
    public int countInversions(int[] nums,int l,int r){
        int count=0;
        if(l<r){
            int m=l+(r-l)/2;
            count+=countInversions(nums,l,m);
            count+=countInversions(nums,m+1,r);
            count+=mergeHelper(nums,l,m,r);
        }
        return count;
    }
    //T:O(nlgn).
    //S:O(1).
}