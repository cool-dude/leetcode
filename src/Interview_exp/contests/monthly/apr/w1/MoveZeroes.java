/*Given an array nums, write a function to
*  move all 0's to the end of it while
* maintaining the relative order of the non-zero elements.
Example:
Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
Note:

You must do this in-place without
making a copy of the array.
Minimize the total number of operations.*/
class Sln {
    public static void main(String[] args) {
        int[] in = new int[]{0, 1, 0, 3, 12};
        moveZeroes(in);
        Arrays.stream(in).forEach(value -> System.out.println(value));
    }
    public void moveZeroes(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int t=nums[i];
                nums[i]=nums[count];
                nums[count]=t;
                count++;
            }
        }
        while (count < nums.length) {
            nums[count] = 0;
            count++;
        }
    }
}