/*LC168:Excel Sheet Column Title
* https://leetcode.com/problems/excel-sheet-column-title/
Given a positive integer, return its
* corresponding column title as
* appear in an Excel sheet.

* For example:
    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB
    ...
Example 1:
Input: 1
Output: "A"

* Example 2:
Input: 28
Output: "AB"
Example 3:

Input: 701
Output: "ZY"
* */
class Sln{
    public Strig convertToTitle(int n){
        if(n<0) {
            return "";
        }
        String res="";
        while (n>0){
            n--;
            char last=(char)(n%26+'A');
            n/=26;
            res = Character.toStrig(last)+res;
        }
        return res;
    }
    //T:O(n)
}