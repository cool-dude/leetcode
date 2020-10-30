/*Given a non-negative integer num represented as a string,
remove k digits from the number so that the new number is the smallest possible.
https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3328/
Note:
The length of num is less than 10002 and will be ≥ k.
The given num does not contain any leading zero.
Example 1:

Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
Example 2:

Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
Example 3:

Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0.*/
class Sln {
    String res="";
    public String removeKdigits(String num, int k) {
        if(k==0){
            res.concat(num);
            return res;
        }
        int n=num.length();
        if(n<=k)
            return "0";
        int minIdx=0;
        for(int i=1;i<=k;i++)
            if(num.charAt(i)<num.charAt(minIdx))
                minIdx=i;
        res+=num.charAt(minIdx);
        String new_str=num.substring(minIdx+1);
        return removeKdigits(new_str,k-minIdx);
    }
}