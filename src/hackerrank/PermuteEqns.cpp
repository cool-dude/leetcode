// Language: C++
// Author: Anton Lunyov
#include <iostream>
using namespace std;
typedef long long LL;
const int MOD = 1000000007;
const int maxN = 200000;
const int maxK = 60;

int dp[maxN][maxK];
int fact[maxN+1];

void precalc() {
    fact[0] = 1;
    for (int n = 1; n <= maxN; ++n) {
        fact[n] = LL(n) * fact[n-1] % MOD;
    }
    dp[0][0] = 1;
    for (int n = 1; n < maxN; ++n) {
        // dp[n][0] = 0 for n >= 1
        for (int k = 1; k < maxK; ++k) {
            dp[n][k] = (dp[n-1][k-1] + LL(n-1) * dp[n-1][k]) % MOD;
        }
    }
}

int calc(int n, LL L, LL R) {
    int ans = 0;
    if (L <= 0 && 0 <= R) {
        ans = (fact[n] + MOD - fact[n-1]) % MOD;
    }
    for (int k = 0; k < maxK; ++k) {
        LL pw2 = 1LL << k;
        if (L <= pw2 && pw2 <= R) {
            ans = (ans + dp[n-1][k]) % MOD;
        }
    }
    return ans;
}

int main() {
    precalc();
    int T;
    cin >> T;
    for (int t = 0; t < T; ++t) {
        int n;
        LL L, R;
        cin >> n >> L >> R;
        int ans = calc(n, L, R);
        cout << ans << endl;
    }
    return 0;
}