class Solution {
    public int fibo(int n) {
        return n <= 2 ? n : fibo(n-2) + fibo(n-1);
    }

    public int numDecodings(String s) {
        char[] c = s.toCharArray();
        int r = 1, flag = 0, count = 0;
        while(flag < c.length) {
            if(c[flag] == '1' || c[flag] == '2')
                count++;
            else if(c[flag] == '0') {
                if(count == 0)
                    return 0;
                else if(count > 1)
                    r *= fibo(count - 1);
                count = 0;
            }
            else {
                if(count == 0) ;
                else if(c[flag-1] == '2' && (c[flag]=='7'||c[flag]=='8'||c[flag]=='9'))
                    r *= fibo(count);
                else
                    r *= fibo(count + 1);
                count = 0;
            }
            flag++;
        }
        return count < 2 ? r : r * fibo(count);
    }

    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(1) != '0' ? 1 : 0;

        for (int i = 2; i <= s.length(); i++) {
            int first = Integer.parseInt(s.substring(i - 1, i));
            int second = Integer.parseInt(s.substring(i - 2, i));

            if (first >= 0 && first <= 9) {
                dp[i] += dp[i - 1];
            }
            if (second >= 10 && second <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }
}