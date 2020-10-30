package cracking_coding_int.chapter_one;
public class OneAwayString {
    public static void main(String[] args) {
        OneAwayString oneAwayString = new OneAwayString();
        System.out.println(oneAwayString.oneEditAway("pale", "ple"));
        System.out.println(oneAwayString.oneEditAway("pales", "pale"));
        System.out.println(oneAwayString.oneEditAway("pale", "bae"));
    }
    public boolean oneEditAway(String a,String b){
        if(Math.abs(a.length()-b.length())>1)
            return false;
        String s1=(a.length()<b.length())?a:b;
        int m=s1.length();
        String s2=(a.length()>b.length())?a:b;
        int n=s2.length();
        int idx1=0,idx2=0;
        boolean foundDiff=false;
        while (idx1<m && idx2<n){
            if(s1.charAt(idx1)!=s2.charAt(idx2)){
                if(foundDiff) {
                    return false;
                }
                foundDiff=true;
                if(m==n){
                    idx1++;
                }
            }
            else{
                idx1++;
            }
            idx2++;
        }
        return true;
    }
    //T:O(Max(M,N)).
    //S:O(1).
}
