/*Given a binary string find the length of longest subsequence (NOT substring) which matches the regex 0 * 1 * 0 * 1*
Here * means the preceding character can occur zero or more times.

Eg input — 0101000, output — 6 (011000)
Eg input — 0101 output — 4 (0101)
Constraint — Length of string = N < 10^5

My approach:
The valid string can be one of seven types:
0 only zeros
1 only ones
01 some zeroes followed by some ones
10 some ones followed by some zeros
010 some zeros then some ones then some zeros
101 some ones then some zeros then some ones
0101 some zeros then some ones then some zeros and then some ones.*/
int main() {
  int n;
  cin>>n;
  string s;
  cin>>s;
  vector < vector <int> > dp(n,vector <int> (7,0));
  dp[0][0]=s[0]=='0';
  dp[0][1]=s[0]=='1';
  for(int i=1;i<n;i++){
      dp[i]=dp[i-1];
      if(s[i]=='1'){
          dp[i][1]++;
          if(dp[i-1][0]!=0||dp[i-1][2]!=0)
              dp[i][2]=max(dp[i-1][0]+1,dp[i-1][2]+1);
          if(dp[i-1][5]!=0||dp[i-1][3]!=0)
              dp[i][5]=max(dp[i-1][3]+1,dp[i-1][5]+1);
          if(dp[i-1][6]!=0||dp[i-1][4]!=0)
              dp[i][6]=max(dp[i-1][6]+1,dp[i-1][4]+1);
      }
      else{
          dp[i][0]++;
          if(dp[i-1][3]!=0||dp[i-1][1]!=0)
              dp[i][3]=max(dp[i-1][3]+1,dp[i-1][1]+1);
          if(dp[i-1][4]!=0||dp[i-1][2]!=0)
              dp[i][4]=max(dp[i-1][4]+1,dp[i-1][2]+1);
      }
  }
  cout<<*max_element(begin(dp.back()),end(dp.back()));
}