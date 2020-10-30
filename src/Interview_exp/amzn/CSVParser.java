/*Given a string, convert it to a list of
values separeted by coma. Called CSV parser.

Example 1
Input = ' "a","b","c" '

Output = [a, b, c]
// We are not adding the double quotes in the strings

Example 2
Input = "a","b,","c"

Output = [a, "b," ,c]
// If there is a comma in between the double quotes then it is part of the string and we add it into the result, so b will have the comma.

Example 3
Input = ' a,"b,",c '

Output = [a,"b,",c]*/
class Sln{
    public static List<String> parseCSV(String s){
        int open = 0;
        int close = 0;
        int startWordAt = 0;
        List<String> ans = new LinkedList<>();
        boolean foundChar = false;
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i)=='"' && foundChar==false) {
                open++;
            }
            else if(s.charAt(i)=='"' && foundChar==true) {
                close++;
            }
            else if(s.charAt(i)!='"' && s.charAt(i)!=',') {
                foundChar=true;
            }
            else if(s.charAt(i)==',') {
                if(close>=open) {
                    // add string we have seen so far and
                    // reset values
                    ans.add(s.substring(startWordAt,i));
                    startWordAt=i+1;
                    foundChar = false;
                    open = 0;
                    close = 0;
                }
            }
        }
        return ans;
    }
}