/*LC1320: Minimum Distance to Type a Word Using Two Fingers
* https://leetcode.com/problems/minimum-distance-to-type-a-word-using-two-fingers/
You have a keyboard layout as shown above in the XY plane,
* where each English uppercase letter is located at some coordinate,
* for example, the letter A is located at coordinate (0,0),
*  the letter B is located at coordinate (0,1), the letter P
*  is located at coordinate (2,3) and the letter Z is located at coordinate (4,1).
Given the string word, return the minimum total distance
* to type such string using only two fingers.
* The distance between coordinates (x1,y1) and
*  (x2,y2) is |x1 - x2| + |y1 - y2|.
Note that the initial positions of your two fingers
* are considered free so don't count towards your total distance,
*  also your two fingers do not have to start at the first letter or the first two letters.
Example 1:
Input: word = "CAKE"
Output: 3
Explanation:
Using two fingers, one optimal way to type "CAKE" is:
Finger 1 on letter 'C' -> cost = 0
Finger 1 on letter 'A' -> cost = Distance from letter 'C' to letter 'A' = 2
Finger 2 on letter 'K' -> cost = 0
Finger 2 on letter 'E' -> cost = Distance from letter 'K' to letter 'E' = 1
Total distance = 3

Example 2:
Input: word = "HAPPY"
Output: 6
Explanation:
Using two fingers, one optimal way to type "HAPPY" is:
Finger 1 on letter 'H' -> cost = 0
Finger 1 on letter 'A' -> cost = Distance from letter 'H' to letter 'A' = 2
Finger 2 on letter 'P' -> cost = 0
Finger 2 on letter 'P' -> cost = Distance from letter 'P' to letter 'P' = 0
Finger 1 on letter 'Y' -> cost = Distance from letter 'A' to letter 'Y' = 4
Total distance = 6

Example 3:
Input: word = "NEW"
Output: 3

Example 4:
Input: word = "YEAR"
Output: 7*/
int dp[27][27][301] = {};
int cost(char from, char to) {
    if (from == 26) return 0;
    return abs(from / 6 - to / 6) + abs(from % 6 - to % 6);
}
int minimumDistance(string &word, int pos = 0, char left = 26, char right = 26) {
    if (pos >= word.size()) return 0;
    if (dp[left][right][pos] == 0) {
        auto to = word[pos] - 'A';
        dp[left][right][pos] = min(cost(left, to) + minimumDistance(word, pos + 1, to, right),
            cost(right, to) + minimumDistance(word, pos + 1, left, to)) + 1;
    }
    return dp[left][right][pos] - 1;
}
//T:O(n*27^m)
//S:O(n*27^m)
int dp[27][301] = {};
int cost(char from, char to) {
    if (from == 26) return 0;
    return abs(from / 6 - to / 6) + abs(from % 6 - to % 6);
}
int minimumDistance(string &word, int pos = 1, char other = 26) {
    if (pos >= word.size()) return 0;
    if (dp[other][pos] == 0) {
        auto to = word[pos] - 'A', last = word[pos - 1] - 'A';
        dp[other][pos] = min(cost(last, to) + minimumDistance(word, pos + 1, other),
            cost(other, to) + minimumDistance(word, pos + 1, last)) + 1;
    }
    return dp[other][pos] - 1;
}
//T:O(n*27)
//S:O(n*27).
