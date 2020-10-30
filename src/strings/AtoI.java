/* LC8: my atoi
https://leetcode.com/problems/string-to-integer-atoi/
Example 1:
Input: "42"
Output: 42

Example 2:
Input: "   -42"
Output: -42
Explanation: The first non-whitespace character is '-', which is the minus sign.
             Then take as many numerical digits as possible, which gets 42.
Example 3:
Input: "4193 with words"
Output: 4193
Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.

Example 4:
Input: "words and 987"
Output: 0
Explanation: The first non-whitespace character is 'w', which is not a numerical
             digit or a +/- sign. Therefore no valid conversion could be performed.*/
class Sln{
    public int myAtoi(char[] str) {
        int index = 0, sign = 1, total = 0;
        //1. Empty string
        if(str.length() == 0) return 0
        //2. Remove Spaces
        while(str.charAt(index) == ' ' && index < str.length())
            index ++;
        //3. Handle signs
        if(str.charAt(index) == '+' || str.charAt(index) == '-'){
            sign = str.charAt(index) == '+' ? 1 : -1;
            index ++;
        }
        //4. Convert number and avoid overflow
        while(index < str.length()){
            int digit = str.charAt(index) - '0';
            if(digit < 0 || digit > 9) break;
            //check if total will be overflow after 10 times and add digit
            if(Integer.MAX_VALUE/10 < total || Integer.MAX_VALUE/10 == total && Integer.MAX_VALUE %10 < digit)
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

            total = 10 * total + digit;
            index ++;
        }
        return total * sign;
    }
    //goldman sachs
    //atoi with 
    public double atoi(String str){
        int n=str.length(),idx=-1,start=0;
        int sign=str.charAt(0)=='-'?-1:1;
        if(sign==-1) start++;
        double result;
        boolean isFloat=false;
        for(int i=start;i<n;i++){
            char ch=str.charAt(i);
            if (ch == '.') {
                idx=i;
                isFloat=true;
                continue;
            }
            int digit=ch-'0';
            result=result*10+digit;
        }
        if(isFloat)
            result/=Math.pow(10,n-idx-1);
        return result*sign;
    }
}