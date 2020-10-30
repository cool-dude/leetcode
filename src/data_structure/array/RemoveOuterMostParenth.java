/*
* Syntax :
public String substring(int begIndex, int endIndex)
Parameters :
beginIndex :  the begin index, inclusive.
endIndex :  the end index, exclusive.
Return Value :
The specified substring.
*/
class Sln{
    public String removeOuterParentheses(String S) {
        char[] brackets=S.toCharArray();
        String part="";
        String result="";
        int openCount=0;
        int closeCount=0;
        for(int i=0;i<brackets.length;i++){
            if(brackets[i]=='('){
                openCount++;
            }
            else if(brackets[i]==')'){
                closedCount++;
            }
            part+=brackets[i];
            if(openCount==closeCount){
                result+=part.subString(1,part.length()-1);
                part="";
            }
        }
        return result;
    }
}