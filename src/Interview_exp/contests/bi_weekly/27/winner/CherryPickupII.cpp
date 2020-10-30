#include <algorithm>
#include <bitset>
#include <cassert>
#include <chrono>
#include <cstring>
#include <iomanip>
#include <iostream>
#include <map>
#include <queue>
#include <random>
#include <set>
#include <stack>
#include <vector>

using namespace std;
// BEGIN NO SAD
#define all(x) x.begin(), x.end()
#define sz(x) (int)(x).size()
typedef vector<int> vi;
// END NO SAD
// REMEMBER CLEAR GLOBAL STATE
int dp[75][75];
int ndp[75][75];
class Solution {
public:
    int cherryPickup(vector<vector<int>>& grid) {
      int r = sz(grid);
      int c = sz(grid[0]);
      memset(dp, -1, sizeof(dp));
      dp[0][c-1] = grid[0][0] + grid[0][c-1];
      for(int i = 1; i < r; i++) {
        memset(ndp, -1, sizeof(ndp));
        for(int a = 0; a < c; a++) {
          for(int b = 0; b < c; b++) {
            if(dp[a][b] < 0) continue;
            for(int na = a-1; na <= a+1; na++) {
              for(int nb = b-1; nb <= b+1; nb++) {
                if(min(na, nb) < 0 || max(na, nb) >= c) continue;
                int cand = dp[a][b] + grid[i][na];
                if(na != nb) cand += grid[i][nb];
                ndp[na][nb] = max(ndp[na][nb], cand);
              }
            }
          }
        }
        memcpy(dp, ndp, sizeof(dp));
      }
      int ret = 0;
      for(int a = 0; a < c; a++) {
        for(int b = 0; b < c; b++) {
          ret = max(ret, dp[a][b]);
        }
      }
      return ret;
    }
};