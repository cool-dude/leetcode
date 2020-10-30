class Solution {
    public int countSubstrings(String s) {
        int n=s.length();
        if(s.length()<=1)
            return n;
        int count=n;
        boolean[][] table=new boolean[n][n];
        for(int i=0;i<n;i++)
            table[i][i]=true;

        for(int i=0;i<n-1;i++){
            if(s.charAt(i)==s.charAt(i+1)){
                table[i][i+1]=true;
                count++;
            }
        }
        for(int len=3;len<=n;len++){
            for(int i=0;i<n-len+1;i++){
                int j=i+len-1;
                if(s.charAt(i)==s.charAt(j) && table[i+1][j-1]){
                    table[i][j]=true;
                    count++;
                }
            }
        }
        return count;
    }
}