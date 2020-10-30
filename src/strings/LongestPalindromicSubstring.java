package strings;
import java.lang.String;
import java.lang.String;
import java.lang.String;
import java.lang.String;
import java.lang.StringBuilder;
import java.util.Arrays;
/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * <p>
 * Example 1:
 * <p>
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 * <p>
 * Input: "cbbd"
 * Output: "bb"
 * <p>
 * we need to build a matrix by input and reverse of the input. Like below
 * *** b a b a d
 * ----------------
 * d | 0 0 0 0 1
 * a | 0 1 0 1 0
 * b | 1 0 2 0 0
 * a | 0 2 0 3 0
 * b | 1 0 3 0 0
 */
public class LongPalindSubstr{
    private static String reverseString(String ip1){ return new StringBuilder(ip1).reverse().toString();}
    private static String findLongestPanlindrome(String s1,String s2){
        char[] rows=s1.toCharArray();
        char[] cols=s1.toCharArray();
        int row=s1.length;
        int col=s2.length;
        int[][] cache=new int[row][col];
        int maxPos=0;
        int max=0;
        if(row==0||col==0)
            return 0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(rows[i]==cols[j]) {
                    if(i>0 && j>0)
                        cache[i][j]=cache[i-1][j-1]+1;
                    else
                        cache[i][j]=1;
                    if(cache[i][j]>max){
                        max=cache[i][j];
                        maxPos=i;
                    }
                }
            }
        }
        System.out.println("Max Pos: " + maxPos);
        System.out.println("Max Length: " + max);
        return input1.substring(maxPos + 1 - max, maxPos + 1);
    }
    //T:O(n^2).
    //S:O(n^2).

    private static String findLongestPalindromSubstr(String str){
        int max=1;
        int start=0;
        int len=str.length();
        int lo,hi;

        for(int i=1;i<len;i++){
            /*ODD LEN*/
            lo=i-1;
            hi=i;
            // longest even length palindrome
            // center points as i-1 and i.
            while (lo>=0 && hi<len && str.charAt(lo) == str.charAt(hi)){
                if(max<hi-lo+1){
                    max=hi-lo+1;
                    start=lo;
                    lo--;
                    hi++;
                }
            }
            /*EVEN LEN*/
            lo=i-1;
            hi=i+1;
            // longest odd length palindrome
            // center points as i-1 and i+1.
            while (lo>=0 && hi<len && str.charAt(lo)==str.charAt(hi)) {
                if(max<hi-lo+1){
                    max=hi-lo+1;
                    start=lo;
                    lo--;
                    hi++;
                }
            }
        }
        return str.substring(str, start, start+max-1);
    }
    //T:O(n^2).
    //S:O(1).

    public static void main(String[] args) {
        String input1 = "cbbd";
        String input2 = reverseString(input1);
        System.out.println(input1 + "-->" + input2);
        System.out.println(findLongestPanlindrome(input1, reverseString(input1)));
    }
}