/*LC258:Add Digits
https://leetcode.com/problems/add-digits/
Given a non-negative integer num,
repeatedly add all its digits until
the result has only one digit.

Example:
Input: 38
Output: 2
Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2.
Since 2 has only one digit, return it.
https://en.wikipedia.org/wiki/Digital_root*/
class Sln1 {
    public int addDigits(int num) {
        int digRoot=0;
        num/=10;
        while (num>0){
            digRoot+=num%10;
            if(num==0 && digRoot>9)
        }
    }
    //T:O(lgn)
    //S:O(1).
}
class Sln2 {
    public int addDigits(int num) {
        return num == 0 ? 0 : 1 + (num - 1) % 9;
    }
    //T:O(1).
    //S:O(1).
}