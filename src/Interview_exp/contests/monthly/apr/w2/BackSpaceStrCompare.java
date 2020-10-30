/*Backspace String Compare
Given two strings S and T, return
* if they are equal when both are typed
* into empty text editors. # means a backspace character.

Example 1:
Input: S = "ab#c", T = "ad#c"
Output: true
Explanation: Both S and T become "ac".

* Example 2:
Input: S = "ab##", T = "c#d#"
Output: true
Explanation: Both S and T become "".

* Example 3:
Input: S = "a##c", T = "#a#c"
Output: true
Explanation: Both S and T become "c".

* Example 4:
Input: S = "a#c", T = "b"
Output: false
Explanation: S becomes "c" while T becomes "b".
Note:*/
class Sln {
    private String compress(String str){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)!='#'){
                sb.append(str.charAt(i));
            }
            else {
                if(sb.length()>0){
                    sb=sb.deleteCharAt(sb.length()-1);
                }
            }
        }
        return sb.toString();
    }
    public boolean backspaceCompare(String S, String T) {
        return compress(S).equals(compress(T));
    }
}