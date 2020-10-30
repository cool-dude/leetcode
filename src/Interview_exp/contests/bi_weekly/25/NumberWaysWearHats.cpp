typedef long long ll;
typedef double db;
typedef vector<int> VI;
typedef vector<VI> VVI;
typedef vector<ll> VLL;
typedef vector<VLL> VVLL;
typedef vector<VVLL> VVVLL;
typedef vector<VVVLL> VVVVLL;
typedef pair<ll,ll> PLL;
typedef map<ll,ll> MLL;

#define REP(x,l,u) for(ll x = l; x < u; x++)
#define RREP(x,l,u) for(ll x = l; x >= u; x--)
#define all(x) x.begin(), x.end()
#define rall(x) x.rbegin(), x.rend()
#define mst(x,v) memset(x, v, sizeof(x))
#define sz(x) (ll)x.size()
#define fi first
#define se second
#define pb push_back

string to_string(string s) {return s;}
string to_string(char c) {string s = string(1, c);return s;}
template <typename A, typename B> string to_string(pair<A,B> p) { return "(" + to_string(p.first) + ", " + to_string(p.second) + ")"; }
template <typename A> string to_string(vector<A> v) { string s = "("; int first = 1; for (A a : v) { if (!first) { s += ", "; } first = 0; s += to_string(a); } s += ")"; return s; }
template <typename A> string to_string(set<A> v) { string s = "("; int first = 1; for (A a : v) { if (!first) { s += ", "; } first = 0; s += to_string(a); } s += ")"; return s; }

void debug_out() {cout << endl;}
template <typename Head, typename... Tail> void debug_out(Head H, Tail... T) { cout << " " << to_string(H); debug_out(T...); }

void upmin(ll & x, ll v) { x = min(x, v); }
void upmax(ll & x, ll v) { x = max(x, v); }

#define debug(...) do { cout << "[" << #__VA_ARGS__ << "]:", debug_out(__VA_ARGS__); } while (false)

const ll inf = (ll)1e18 + 5;
const ll mod = 1e9+7;

VLL di = {0,0,1,-1,1,-1,1,-1};
VLL dj = {1,-1,0,0,-1,-1,1,1};
ll ob(ll i, ll n) { return i < 0 || i >= n; } // out bound

class Sln1 {
public:
    VVLL A;
    VVLL dp;
    ll get(ll ind, ll mask) {
        if (ind == 41) {
            if (mask == 0) return 1;
            return 0;
        }
        if (dp[ind][mask] != -1) return dp[ind][mask];

        ll ans = get(ind+1, mask);
        for (ll i : A[ind]) {
            if ((1<<i) & mask) {
                ans += get(ind+1, mask & (~(1<<i)));
                ans %= mod;
            }
        }
        ans %= mod;
        dp[ind][mask] = ans;
        return ans;
    }
    int numberWays(vector<vector<int>>& hats) {
        ll n = hats.size();
        A.resize(41);
        dp.assign(50, VLL(1<<n, -1));

        REP(i,0,n) {
            for (ll x : hats[i]) {
                A[x].push_back(i);
            }
        }

        return get(0, (1<<n)-1);

    }
};

class Sln2 {
public:
    int numberWays(vector<vector<int>>& hats) {
        int n = hats.size();
        const int MOD = 1e9 + 7;
        vector<int> dp(1 << n);
        dp[0] = 1;
        for(int hat = 1; hat <= 40; ++hat) {
            vector<int> dp2(1 << n);
            dp2 = dp;
            vector<int> people;
            for(int who = 0; who < n; ++who) {
                for(int h : hats[who]) {
                    if(h == hat) {
                        people.push_back(who);
                    }
                }
            }
            for(int mask = 0; mask < (1 << n); ++mask) {
                for(int who : people) {
                    if(!(mask & (1 << who))) {
                        int& tmp = dp2[mask|(1<<who)];
                        tmp += dp[mask];
                        if(tmp >= MOD) {
                            tmp -= MOD;
                        }
                    }
                }
            }
            dp = dp2;
        }
        return dp[(1<<n)-1];
    }
};