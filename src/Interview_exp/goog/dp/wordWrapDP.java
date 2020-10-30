import java.io.*;
class Sln1{
    final int MAX = Integer.MAX_VALUE;
    public int printSoln(int p[],int n){
        int k;
        if(p[n]==1)
            k=1;
        else
            k = printSoln(p,p[n]-1)+1;
        System.out.println("Line:"+" "+k+
                "From word no." +" "+ p[n] + " " + "to" + " " + n);
        return k;
    }
    //l[] length of diff words,
    //n number of words,
    //m line width
    void solnWordWrap(int l[],int n,int m){
        //extras[i][j] number of extras
        //spaces from i to j
        //in a single line
        int extras[][] = new int[n+1][n+1];
        //lc[i][j] cost of a line with
        //words from i to j.
        int lc[][] = new int[n+1][n+1];
        //c[i] total cost of opt arr
        //from 1 to i.
        int c[] = new int[n+1];
        int p[] = new int[n+1];

        for(int i=1;i<=n;i++){
            extras[i][i] = M-l[i-1];
            for(int j=i+1;j<=n;j++)
                extras[i][j] = extras[i][j-1]-l[j-1]-1;
        }
        //calc line cost
        //corresponding to above
        //extra spaces.
        for(int i=1;i<=n;i++){
            for(int j=i;j<=n;j++){
                if(extras[i][j]<0)
                    lc[i][j] = MAX;
                else if(j==n && extras[i][j]>=0)
                    lc[i][j] = 0;
                else
                    lc[i][j] = extras[i][j]^3;
            }
        }
        c[0]=0;
        for(int j=1;j<=n;j++){
            c[j]=MAX;
            for(int i=1;i<=j;i++){
                if(c[i-1]!=MAX && lc[i][j]!=MAX && c[i-1]+lc[i][j]<c[j]){
                    c[j] = c[i-1]+lc[i][j];
                    p[j] = i;
                }
            }
        }
        printSoln(p,n);
    }
}
//T:O(n^2).
//S:O(n^2).

/*Input format: Input will consists of array of
integers where each array element represents
length of each word of string. For example, for
string S = "Geeks for Geeks", input array will
be arr[] = {5, 3, 5}.
Output format: Output consists of a series of
integers where two consecutive integers represent
starting word and ending word of each line.

Input : arr[] = {3, 2, 2, 5}
Output : 1 1 2 3 4 4
Line number 1: From word no. 1 to 1
Line number 2: From word no. 2 to 3
Line number 3: From word no. 4 to 4

Input : arr[] = {3, 2, 2}
Output : 1 1 2 2 3 3
Line number 1: From word no. 1 to 1
Line number 2: From word no. 2 to 2
Line number 3: From word no. 3 to 3 */
class Sln2{
    void solveWordWrap(int[] arr,int n,int k){
        // number of characters
        // in given line and cost
        int curLen,cost;
        //dp[i] cost of line starting word arr[i]
        int[] dp=new int[n];
        //array in which ans[i]
        //store index of last word
        //in line with word[i]
        int[] ans=new int[n];
        // If only one word is present
        // then only one line is required.
        // Cost of last line is zero.
        // Hence cost of this line is zero.
        // Ending point is also n-1 as
        // single word is present.
        dp[n-1]=0;
        ans[n-1]=n-1;
        // Make each word first
        // word of line by iterating
        // over each index in arr.
        for(int i=n-2;i>=0;i--){
            curLen=-1;
            dp[i]=Integer.MAX_VALUE;
            for(int j=i;j<n;j++){
                //keep on adding words
                //current line, arr[j] number
                //of chars in current word
                //and 1 represents space b/w 2 words
                curLen+=(arr[j]+1);
                //if limit chars violated
                //no more words added
                if(curLen>k)
                    break;
                //current word is last word of array
                //current line is last. Cost of last line 0.
                //Else cost is cube of extra spaces plus cost
                //of putting line breaks
                if(j==n-1)
                    cost=0;
                else {
                    cost=(k-curLen)^3+dp[j+1];
                }
                // Check if this arrangement
                // gives minimum cost for
                // line starting with word
                // arr[i].
                if(cost<dp[i]){
                    dp[i]=cost;
                    ans[i]=j;
                }
            }
        }
        // Print starting index
        // and ending index of
        // words present in each line.
        i = 0;
        while (i < n) {
            System.out.print((i + 1) + " " +
                    (ans[i] + 1) + " ");
            i = ans[i] + 1;
        }
    }
}
//T:O(n^2).
//S:O(n).