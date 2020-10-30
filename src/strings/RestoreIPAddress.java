/*LC93: Restore IP Addresses
Given a string containing only digits,
* restore it by returning all possible valid IP address combinations.

Example:
Input: "25525511135"
Output: ["255.255.11.135", "255.255.111.35"]
*
* ALGO:Here is an algorithm for the backtrack function
* backtrack(prev_pos = -1, dots = 3) which takes position
* of the previously placed dot prev_pos and number of dots
* to place dots as arguments :

Iterate over three available slots curr_pos to place a dot.
Check if the segment from the previous dot to the current one is valid :
Yes :
Place the dot.
Check if all 3 dots are placed :
Yes :
Add the solution into the output list.
No :
Proceed to place next dots backtrack(curr_pos, dots - 1).
Remove the last dot to backtrack.
* */
class Sln{
    int n;
    String s;
    LinkedList<String> segments = new LinkedList<String>();
    ArrayList<String> output = new ArrayList<String>();
    boolean valid(String segment){
        int m=segment.length();
        if(m>3){
            return false;
        }
        return (segment.charAt(0)!='0')?(Integer.valueOf(segment)<=255):(m==1);
    }
    private void update_output(int cur){
        String segment=s.substring(cur+1,n);
        if(valid(segment)){
            segments.add(segment);
            output.add(String.join(".", segments));
            segments.removeLast();
        }
    }
    void backtrack(int prv_pos, int dots){
        /*prev_pos : the position of the previously placed dot
          dots : number of dots to place
         */
        // The current dot curr_pos could be placed
        // in a range from prev_pos + 1 to prev_pos + 4.
        // The dot couldn't be placed
        // after the last character in the string.
        int max_pos=Math.min(n-1,prv_pos+4);
        for(int cur=prv_pos+1;cur<max_pos;cur++){
            String segment=s.substring(prv_pos+1, cur+1);
            if(valid(segment)){
                segments.add(segment);
                if (dots - 1 == 0) {
                    update_output(cur);
                }
                else {
                    backtrack(cur, dots-1);
                }
                segments.removeLast();
            }
        }
    }
    public List<String> restoreIpAddress(String s){
        n=s.length();
        this.s=s;
        backtrack(-1,3);
        return output
    }
}

class Sln2{
    int n;
    String str;
    LinkedList<String> segments=new LinkedList<String>();
    ArrayList<String> result=new ArrayList<String>();
    boolean valid(String segment) {
        int m = segment.length();
        if (m > 3)
            return false;
        return (segment.charAt(0) != '0') ? (Integer.valueOf(segment) <= 255) : (m == 1);
    }
    void update_output(int cur){
         String segment=s.substring(cur+1,n);
         if(valid(segment)){
            segments.add(segment);
            /*
            * public static String join(CharSequence deli, CharSequence... ele)
            Parameters:
            deli- delimiter to be attached with each element
            ele- string or char to be attached with delimiter
            Returns :  string joined with delimiter.
            */
            result.add(Strig.join('.', segments));
            segments.removeLast();
         }
    }
    void backtrack(int prev_pos,int dots){
        int max_pos=Math.min(n-1, prev_pos+4);
        for(int cur=prev_pos+1;cur<max_pos;cur++){
            String segment=s.substring(prev_pos+1, cur+1);
            if(valid(segment)) {
                segments.add(segment);
                if (dots == 1) {
                    update_output(cur);
                }
                else{
                    backtrack(cur, dots-1);
                }
                segments.removeLast();
            }
        }
    }
    public List<String> restoreIPAddress(String s){
        n=s.length();
        this.str=s;
        backtrack(-1,3);
        return result;
    }
}