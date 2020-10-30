/*LC66: Plus One
https://leetcode.com/problems/plus-one/
Given a non-empty array of digits
representing a non-negative integer,
plus one to the integer.

The digits are stored such that the most
significant digit is at the head of the list,
and each element in the array contain a single digit.

You may assume the integer does not contain
any leading zero, except the number 0 itself.

Example 1:
Input: [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.

Example 2:
Input: [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.*/
class Sln {
    public int[] plusOne(int[] digits) {
        int idx = digits.length - 1;
        boolean flag = true;
        while(idx > -1){
            int tmp = flag ? digits[idx] +  1 : digits[idx];
            if(tmp > 9){
                flag = true;
                tmp -= 10;
            }
            else{
                flag = false;
            }
            digits[idx] = tmp;
            idx--;
        }
        if(flag){
            int[] res = new int[digits.length+1];
            res[0] = 1;
            for(int i = 0; i < digits.length; i++){
                res[i+1] = digits[i];
            }
            return res;
        }
        else{
            return digits;
        }
    }
}