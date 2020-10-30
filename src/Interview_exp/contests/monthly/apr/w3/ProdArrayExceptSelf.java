/*LC238:Product of Array Except Self
* https://leetcode.com/problems/product-of-array-except-self/
Given array nums of n integers where n > 1,
* return array output such that output[i] is
* equal to the product of all the elements of nums except nums[i].

Example:
Input:  [1,2,3,4]
Output: [24,12,8,6]
Constraint: It's guaranteed that the product of the
* elements of any prefix or suffix of the array
* (including the whole array) fits in a 32 bit integer*/
import java.util.Arrays;
public class Sln1{
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        if (nums == null || n == 0) return new int[]{};
        if (n == 1) return new int[]{};

        int[] left = new int[n];
        left[0] = 1;
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        int[] right = new int[n];
        right[n - 1] = 1;
        for (int i = n - 1; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < n; i++) {
            right[i] = right[i] * left[i];
        }
        return right;
    }
}
class Sln2 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        if (nums == null || n == 0) return new int[]{};
        if (n == 1) return new int[]{};
        int zCount=0,zIdx=-1,prod=1;
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                zCount++;
                zIdx=i;
            }
            else{
                prod*=nums[i];
            }
        }
        int[] op=new int[n];
        if(zCount==0){
            for(int i=0;i<n;i++)
                op[i]=prod/nums[i];
            return op;
        }
        else if(zCount==1){
            op[zIdx]=prod;
            return op;
        }
        else{
            return op;
        }
    }
}