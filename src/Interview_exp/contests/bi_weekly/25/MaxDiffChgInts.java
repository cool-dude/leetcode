/*LC1432: Max Difference You Can Get From Changing an Integer
https://leetcode.com/problems/max-difference-you-can-get-from-changing-an-integer/
You are given an integer num. You will apply
the following steps exactly two times:

Pick a digit x (0 <= x <= 9).
Pick another digit y (0 <= y <= 9). The digit y can be equal to x.
Replace all the occurrences of x in the decimal representation of num by y.
The new integer cannot have any leading zeros, also the new integer cannot be 0.
Let a and b be the results of applying the operations to num the first and second times, respectively.

Return the max difference between a and b.

Example 1:
Input: num = 555
Output: 888
Explanation: The first time pick x = 5 and y = 9 and store the new integer in a.
The second time pick x = 5 and y = 1 and store the new integer in b.
We have now a = 999 and b = 111 and max difference = 888
Example 2:
Input: num = 9
Output: 8
Explanation: The first time pick x = 9 and y = 9 and store the new integer in a.
The second time pick x = 9 and y = 1 and store the new integer in b.
We have now a = 9 and b = 1 and max difference = 8
Example 3:
Input: num = 123456
Output: 820000
Example 4:
Input: num = 10000
Output: 80000
Example 5:
Input: num = 9288
Output: 8700*/
class Solution {
    public int maxDiff(int num) {
        String sMax = Integer.toString(num);
        String sMin = Integer.toString(num);
        // Create the max
        // replace all x to 9
        for(int i = 0; i < strMax.length(); i++){
            if(sMax.charAt(i) != '9'){
                sMax = sMax.replace(sMax.charAt(i), '9');
                break;
            }
        }
        // Create the min
        // replace all y to 1 if the highest digit it not 1
        for(int i = 0; i < sMin.length(); i++){
            if(sMin.charAt(i) != '1' && i == 0){
                sMin = sMin.replace(sMin.charAt(i), '1');
                break;
            }
            if(sMin.charAt(i) != '0' && sMin.charAt(i) != '1' && i != 0){
                sMin = sMin.replace(sMin.charAt(i), '0');
                break;
            }
        }
        return Integer.parseInt(sMax) -  Integer.parseInt(sMin);
    }
}