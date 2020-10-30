/*https://www.hackerrank.com/challenges/journey-to-the-moon/problem
The member states of the UN are planning to send
people to the moon. They want them to be from
different countries. You will be given a list of
pairs of astronaut ID's. Each pair is made of
astronauts from the same country. Determine how
many pairs of astronauts from different countries
they can choose from.
  For example, we have the following data on 2 pairs of astronauts, and 4 astronauts total, numbered  through .
  1   2
  2   3
  Astronauts by country are  and . There are  pairs to choose from:  and .

  Function Description

  Complete the journeyToMoon function in the editor below. It should return an integer that represents the number of valid pairs that can be formed.

  journeyToMoon has the following parameter(s):

  n: an integer that denotes the number of astronauts
  astronaut: a 2D array where each element  is a  element integer array that represents the ID's of two astronauts from the same country
  Input Format

  The first line contains two integers  and , the number of astronauts and the number of pairs.
  Each of the next  lines contains  space-separated integers denoting astronaut ID's of two who share the same nationality.

  Constraints
  Output Format
  An integer that denotes the number of ways to choose a pair of astronauts from different coutries.*/
#include <string>
#include <vector>
#include <map>
#include <list>
#include <iterator>
#include <set>
#include <queue>
#include <iostream>
#include <sstream>
#include <stack>
#include <deque>
#include <cmath>
#include <memory.h>
#include <cstdlib>
#include <cstdio>
#include <cctype>
#include <algorithm>
#include <utility>
using namespace std;
#define FOR(i, a, b) for(int i = (a); i < (b); ++i)
#define RFOR(i, b, a) for(int i = (b) - 1; i >= (a); --i)
#define REP(i, N) FOR(i, 0, N)
#define RREP(i, N) RFOR(i, N, 0)

#define ALL(V) V.begin(), V.end()
#define SZ(V) (int)V.size()
#define PB push_back
#define MP make_pair
#define Pi 3.14159265358979

typedef long long Int;
typedef unsigned long long UInt;
typedef vector <int> VI;
typedef pair <int, int> PII;

VI a[1<<17];
bool was[1<<17];
int n,m;
int dfs(int cur)
{
	if (was[cur])
		return 0;

	was[cur] = true;
	int res = 1;
	REP(i,SZ(a[cur]))
	{
		int nx = a[cur][i];

		res += dfs(nx);
	}
	return res;
}


int main()
{
//	freopen("in.txt", "r", stdin);
//	freopen("out.txt", "w", stdout);
	scanf("%d%d",&n,&m);
	REP(i,m)
	{
		int x,y;
		scanf("%d%d",&x,&y);

		a[x].push_back(y);
		a[y].push_back(x);
	}
	VI all;
	REP(i,n)
	{
		if (!was[i])
		{
			all.push_back(dfs(i));
		}
	}
	Int res = 0;
	Int sum = 0;
	REP(i, SZ(all))
	{
		res += sum * all[i];
		sum += all[i];
	}
	cout << res << endl;
	return 0;
}