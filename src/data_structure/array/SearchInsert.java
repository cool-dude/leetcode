/*LC35: Search Insert Position
Given a sorted array and a target value,
* return the index if the target is found.
* If not, return the index where it would be
* if it were inserted in order.

Input: [1,3,5,6], 5
Output: 2
Example 2:

Input: [1,3,5,6], 2
Output: 1
Example 3:

Input: [1,3,5,6], 7
Output: 4
Example 4:

Input: [1,3,5,6], 0
Output: 0*/
class Sln{
    public int searchInsert(int[] nums,int target){
        int piv,left=0,right=nums.length-1;
        while (left<=right){
            piv=left+(right-left)/2;
            if(nums[piv]==target) {
                return piv;
            }
            else if(target< nums[piv]){
                right = piv-1;
            }
            else {
                left = piv+1;
            }
        }
        return left;
    }
}