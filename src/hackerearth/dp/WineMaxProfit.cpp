#include <string>
#include <vector>
#include <list>
#include <set>
#include <map>
#include <queue>
#include <stack>
#include <algorithm>
#include <functional>
using namespace std;

#define DEBUG(x) cout << '>' << #x << ':' << x << endl;
#define REP(i,n) for(int i=0;i<(n);i++)
#define FOR(i,a,b) for(int i=(a);i<=(b);i++)
#define FORD(i,a,b) for(int i=(a);i>=(b);i--)
inline bool EQ(double a, double b) { return fabs(a-b) < 1e-9; }

const int INF = 1<<29;
typedef long long ll;

inline int two(int n) { return 1 << n; }
inline int test(int n, int b) { return (n>>b)&1; }
inline void set_bit(int & n, int b) { n |= two(b); }
inline void unset_bit(int & n, int b) { n &= ~two(b); }
inline int last_bit(int n) { return n & (-n); }
inline int ones(int n) { int res = 0; while(n && ++res) n-=n&(-n); return res; }

template<class T> void chmax(T & a, const T & b) { a = max(a, b); }
template<class T> void chmin(T & a, const T & b) { a = min(a, b); }
int p[N] //read -only array of wine prices
//year represents current year(start 1).
//[be,en] represents interval for unsold wines
class Sln1{
    int p[N];
public:
    int maxProfit(int year,int be,int en){
        if(be>en)
            return 0;
        return max(maxProfit(year+1,be+1,en)+year*p[be],
            maxProfit(year+1,be,en-1)+year*p[en]);
    }
}

class Sln2{
    int N;
    int p[N];
public:
    int maxProfit(int be,int en){
        if(be>en)
            return 0;
        int year=N-(en-be+1);
        return max(maxProfit(be+1,en)+year*p[be],
            maxProfit(be,en-1)+year*p[en]);
    }
}