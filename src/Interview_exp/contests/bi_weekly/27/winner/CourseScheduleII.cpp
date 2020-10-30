/*LC1462: Course Schedule IV
https://leetcode.com/problems/course-schedule-iv/
There are a total of n courses you
have to take, labeled from 0 to n-1.
Some courses may have direct prerequisites,
for example, to take course 0 you have
first to take course 1, which is expressed as a pair: [1,0]

Given the total number of courses n, a
list of direct prerequisite pairs and
a list of queries pairs.

You should answer for each queries[i] whether
the course queries[i][0] is a prerequisite
of the course queries[i][1] or not.

Return a list of boolean, the answers to the
given queries.

Please note that if course a is a prerequisite
of course b and course b is a prerequisite of
course c, then, course a is a prerequisite of course c.

Example 1:
Input: n = 2, prerequisites = [[1,0]], queries = [[0,1],[1,0]]
Output: [false,true]
Explanation: course 0 is not a prerequisite of course 1 but the opposite is true.

Example 2:
Input: n = 2, prerequisites = [], queries = [[1,0],[0,1]]
Output: [false,false]
Explanation: There are no prerequisites and each course is independent.

Example 3:
Input: n = 3, prerequisites = [[1,2],[1,0],[2,0]], queries = [[1,0],[1,2]]
Output: [true,true]

Example 4:
Input: n = 3, prerequisites = [[1,0],[2,0]], queries = [[0,1],[2,0]]
Output: [false,true]

Example 5:
Input: n = 5, prerequisites = [[0,1],[1,2],[2,3],[3,4]], queries = [[0,4],[4,0],[1,3],[3,0]]
Output: [true,false,true,false]*/
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
bool can[105][105];
class Solution {
public:
    vector<bool> checkIfPrerequisite(int n, vector<vector<int>>& prerequisites, vector<vector<int>>& queries) {
      for(int i = 0; i < n; i++) for(int j = 0; j < n; j++) can[i][j] = false;
      for(int i = 0; i < n; i++) can[i][i] = true;
      for(auto out: prerequisites) {
        can[out[0]][out[1]] = true;
      }
      for(int i = 0; i < n; i++) for(int j = 0; j < n; j++) for(int k = 0; k < n; k++) can[i][j] |= can[i][k] && can[k][j];
      vector<bool> ret;
      for(auto out: queries) ret.push_back(can[out[0]][out[1]]);
      return ret;
    }
};