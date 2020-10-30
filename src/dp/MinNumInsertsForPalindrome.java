/*package whatever*/
import java.util.*;
import java.lang.*;
import java.io.*;
class Soln {
    static int findMinInserts_DP(
            char s[], int n) {
        int t[][] =
                new int[n][n];
        int l, h, gap;

        // Fill the table
        for (gap = 1; gap < n; ++gap)
            for (l = 0, h = gap;
                 h < n; ++l, ++h)
                t[l][h] = (s[l] == s[h])?
                        t[l+1][h-1] :
                        (Integer.min(t[l][h-1],t[l+1][h]) + 1);
        // Return minimum
        // number of insertions
        // for str[0..n-1]
        return t[0][n-1];
    }

    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=Integer.parseInt(sc.nextLine());
        for(int i=0;i<t;i++){
            String s=sc.nextLine();
            System.out.println(
                    findMinInserts_DP(
                            s,s.length()));
        }
    }
}