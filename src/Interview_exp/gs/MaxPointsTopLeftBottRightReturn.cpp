/*Input : N = 3, M = 4
****
.##.
.##.
****
Output : 8

Input : N = 9, M = 7
*........
.....**#.
..**...#*
..####*#.
.*.#*.*#.
...#**...
*........
Output : 7*/
// CPP program to find maximum points that can
// be collected in a journey from top to bottom
// and then back from bottom to top,
#include <bits/stdc++.h>
#define MAX 5
#define N 5
#define M 5
#define inf 100000
using namespace std;

// Calculating the points at a (row1, col1) &&
// (row2, col2) from path1 && path2
int cost(char grid[][M], int row1, int col1,
						int row2, int col2)
{
	// If both path is at same cell
	if (row1 == row2 && col1 == col2) {

		// If the cell contain *, return 1
		if (grid[row1][col1] == '*')
			return 1;

		// else return 0.
		return 0;
	}

	int ans = 0;

	// If path 1 contain *, add to answer.
	if (grid[row1][col1] == '*')
		ans++;

	// If path contain *, add to answer.
	if (grid[row2][col2] == '*')
		ans++;

	return ans;
}

// Calculate the maximum points that can be
// collected.
int solve(int n, int m, char grid[][M],
		int dp[MAX][MAX][MAX], int row1,
					int col1, int row2)
{
	int col2 = (row1 + col1) - (row2);

	// If both path reach the bottom right cell
	if (row1 == n - 1 && col1 == m - 1 &&
		row2 == n - 1 && col2 == m - 1)
		return 0;

	// If moving out of grid
	if (row1 >= n || col1 >= m ||
		row2 >= n || col2 >= m)
		return -1 * inf;

	// If already calculated, return the value
	if (dp[row1][col1][row2] != -1)
		return dp[row1][col1][row2];

	// Vaiable for 4 options.
	int ch1 = -1 * inf, ch2 = -1 * inf;
	int ch3 = -1 * inf, ch4 = -1 * inf;

	// If path 1 is moving right and path 2
	// is moving down.
	if (grid[row1][col1 + 1] != '#' &&
		grid[row2 + 1][col2] != '#')
	ch1 = cost(grid, row1, col1 + 1, row2 + 1, col2) +
		solve(n, m, grid, dp, row1, col1 + 1, row2 + 1);

	// If path 1 is moving right and path 2 is moving
	// right.
	if (grid[row1][col1 + 1] != '#' &&
		grid[row2][col2 + 1] != '#')
	ch2 = cost(grid, row1, col1 + 1, row2, col2 + 1) +
			solve(n, m, grid, dp, row1, col1 + 1, row2);

	// If path 1 is moving down and path 2 is moving right.
	if (grid[row1 + 1][col1] != '#' &&
		grid[row2][col2 + 1] != '#')
	ch3 = cost(grid, row1 + 1, col1, row2, col2 + 1) +
		solve(n, m, grid, dp, row1 + 1, col1, row2);

	// If path 1 is moving down and path 2 is moving down.
	if (grid[row1 + 1][col1] != '#' &&
		grid[row2 + 1][col2] != '#')
	ch4 = cost(grid, row1 + 1, col1, row2 + 1, col2) +
		solve(n, m, grid, dp, row1 + 1, col1, row2 + 1);

	// Returning the maximum of 4 options.
	return dp[row1][col1][row2] = max({ch1, ch2, ch3, ch4});
}

// Wrapper Function
int wrapper(int n, int m, char grid[N][M])
{
	int ans = 0;
	int dp[MAX][MAX][MAX];
	memset(dp, -1, sizeof dp);

	// If last bottom right cell is blcoked
	if (grid[n - 1][m - 1] == '#' || grid[0][0] == '#')
		ans = -1 * inf;

	// If top left cell contain *
	if (grid[0][0] == '*')
		ans++;
	grid[0][0] = '.';

	// If bottom right cell contain *
	if (grid[n - 1][m - 1] == '*')
		ans++;
	grid[n - 1][m - 1] = '.';

	ans += solve(n, m, grid, dp, 0, 0, 0);
	return max(ans, 0);
}

// Driven Program
int main()
{
	int n = 5, m = 5;

	char grid[N][M] = {
		{ '.', '*', '.', '*', '.' },
		{ '*', '#', '#', '#', '.' },
		{ '*', '.', '*', '.', '*' },
		{ '.', '#', '#', '#', '*' },
		{ '.', '*', '.', '*', '.' }
	};

	cout << wrapper(n, m, grid) << endl;
	return 0;
}