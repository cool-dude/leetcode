package strings;
import java.lang.StringBuilder;
/*permutation, also called an “arrangement number” or “order,”
 is rearrangement of the elements of an ordered list
 S into a one-to-one correspondence with S itself.
 A string of length n has n! permutation.
Source: Mathword(http://mathworld.wolfram.com/Permutation.html)

Below are the permutations of string ABC.
* ABC ACB BAC BCA CBA CAB*/
class PermuteStr{
    private boolean[] used;
    private StringBuilder op=new StringBuilder();
    private final String in="wxyz";
    public void permute() {
        if(op.length() == in.length()){
            System.out.println(op);
            return;
        }
        for( int i = 0; i < in.length(); i++){
            if(used[i]) continue;
            op.append(in.charAt(i));
            used[i] = true;
            permute();
            used[i] = false;
            out.setLength(op.length() - 1);
        }
    }
    public static void main(String[] args){
        permute();
    }
}