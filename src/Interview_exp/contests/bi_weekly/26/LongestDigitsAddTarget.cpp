class Sln{
public:
    string largestNumber(vector<int>& cost, int target) {
        vector<int> dp(target + 1, -10000);
        dp[0] = 0;
        for (int t = 1; t <= target; ++t) {
            for (int i = 0; i < 9; ++i) {
                dp[t] = max(dp[t], t >= cost[i] ? 1 + dp[t - cost[i]] : -10000);
            }
        }
        if (dp[target] < 0) return "0";
        string res = "";
        for (int i = 8; i >= 0; --i) {
            while (target >= cost[i] && dp[target] == dp[target - cost[i]] + 1) {
                res.push_back('1' + i);
                target -= cost[i];
            }
        }
        return res;
    }
}