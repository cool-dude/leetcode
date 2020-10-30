/*LC1431: Kids With the Greatest Number of Candies
  Given the array candies and the integer extraCandies,
  where candies[i] represents the number of candies that the ith kid has.

  For each kid check if there is a way to distribute
  extraCandies among the kids such that he or she can
  have the greatest number of candies among them.
  Notice that multiple kids can have the greatest number of candies.

  Example 1:
  Input: candies = [2,3,5,1,3], extraCandies = 3
  Output: [true,true,true,false,true]
  Explanation:
  Kid 1 has 2 candies and if he or she receives all extra candies (3) will have 5 candies --- the greatest number of candies among the kids.
  Kid 2 has 3 candies and if he or she receives at least 2 extra candies will have the greatest number of candies among the kids.
  Kid 3 has 5 candies and this is already the greatest number of candies among the kids.
  Kid 4 has 1 candy and even if he or she receives all extra candies will only have 4 candies.
  Kid 5 has 3 candies and if he or she receives at least 2 extra candies will have the greatest number of candies among the kids.
  Example 2:

  Input: candies = [4,2,1,1,2], extraCandies = 1
  Output: [true,false,false,false,false]
  Explanation: There is only 1 extra candy, therefore only kid 1 will have the greatest number of candies among the kids regardless of who takes the extra candy.
  Example 3:

  Input: candies = [12,1,12], extraCandies = 10
  Output: [true,false,true]*/
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

class Solution {
public:
    vector<bool> kidsWithCandies(vector<int>& candies, int extraCandies) {
        int mx = *max_element(candies.begin(), candies.end());
        vector<bool> ret;
        for(auto x: candies){
            if(x+extraCandies >= mx)
                ret.push_back(true);
            else
                ret.push_back(false);
        }
        return ret;
    }
};