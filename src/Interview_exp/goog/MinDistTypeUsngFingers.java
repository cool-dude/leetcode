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
class Sln{
    class Location{
        int r,c;
        public Location(int x,int y){
            this.r=x;
            this.c=y;
        }
        public int distLocation(Location o){
            return Math.abs(o.x-this.r)+Math.abs(o.y-this.c);
        }
        public String toString(){
            return this.r+":"+c;
        }
    }
    static Map<Character,Location> map=new HashMap<>();
    static String [] layout = {
            "ABCDEF",
            "GHIJKL",
            "MNOPQR",
            "STUVWX",
            "YZ"
    };
    public static int helper(Location f1,Location f2, int start, String ip){
        if(start==ip.length())
            return 0;
        Location nextLocation=map.get(ip.charAt(start));
        //choice 1:Move finger1 to next location and cost
        int costStartingWithFinger1Move=f1.distLocation(nextLocation)+helper(nextLocation,f2,start+1,ip);
        //choice 2:Move finger2 to next location and cost
        int costStartingWithFinger2Move=(f2==null)?0:(f2.distLocation(nextLocation)+helper(f1,nextLocation,start+1,ip));
        return Math.min(costStartingWithFinger1Move,costStartingWithFinger2Move);
    }
}
/*Explanation
Imagine that we tap all letters with only one finger.
The res distance we get is the maximum distance we will need.
In our dynamic programming, dp[a] means that,
if our left finger ends at character a,
the maximum we can save is dp[a].

Now our right finger tapped all letters, and left finger did nothing.
We iterate through the whole string one by one
and select some letter to tap with the left finger.
By doing this, we want to find out the maximum distance that we can save from the tapping with one finger.

Assume that our left finger is at a now,
our right finger is at b,
and we the right finger will tap c next.

Instead of moving right finger from b to c with distance d(b, c),
we try moving left finger from a to c with distance d(a, c).
Hopely this will save d(b, c) - d(a, c).

And finaly, we have one fingers at b and the other at c now.
The finger at b will be new left finger, and the other will be the rihgt.*/
class Sln2{
    public int minimumDistance(String word) {
        int dp[] = new int[26], res = 0, save = 0, n = word.length();
        for (int i = 0; i < n - 1; ++i) {
            int b = word.charAt(i) - 'A', c = word.charAt(i + 1) - 'A';
            for (int a = 0; a < 26; ++a)
                dp[b] = Math.max(dp[b], dp[a] + d(b, c) - d(a, c));
            save = Math.max(save, dp[b]);
            res += d(b, c);
        }
        return res - save;
    }
    private int d(int a, int b) {
        return Math.abs(a / 6 - b / 6) + Math.abs(a % 6 - b % 6);
    }
}

class Sln2{
    public int minimumDistance(String word) {
        int[] dp = new int[27];
        Arrays.fill(dp, 3000);
        int a = word.charAt(0) - 'A';
        dp[26] = 0;
        for(int i = 1; i < word.length(); i++) {
            int b = word.charAt(i) - 'A';
            int[] dp1 = new int[27]; Arrays.fill(dp1, 3000);
            for(int j = 0; j < 27; j++) {
                if(dp[j] != 3000) {
                    //Two options
                    //move finger 1, next step other finger will be on a.
                    dp1[a] = Math.min(dp1[a], dp[j] + d(j, b));
                    //move finger 2, next step other finger will stay with j.
                    dp1[j] = Math.min(dp1[j], dp[j] + d(a, b));
                }
            }
            dp = dp1;
            a = b;
        }
        int res = 3000;
        for(int d : dp) res = Math.min(d, res);
        return res;
    }
    public int d(int a, int b) {
        if(a == 26) return 0;
        return Math.abs(a / 6 - b / 6) + Math.abs(a % 6 - b % 6);
    }
}

class Sln3 {
    int[][][] memo = new int[27][27][300];
    public int minimumDistance(String word) {
        return minDist(word, 0, null, null);
    }
    private int minDist(String word, int pos, Character c1, Character c2) {
        if (pos >= word.length())
            return 0;
        int idx1 = c1 == null ? 0 : c1 - 'A' + 1;
        int idx2 = c2 == null ? 0 : c2 - 'A' + 1;
        if (memo[idx1][idx2][pos] == 0) {
            memo[idx1][idx2][pos] = Math.min(getDist(c1,word.charAt(pos)) + minDist(word,pos+1,word.charAt(pos),c2),
                    getDist(c2,word.charAt(pos)) + minDist(word,pos+1,c1,word.charAt(pos)));
        }
        return memo[idx1][idx2][pos];
    }
    private int getDist(Character c1, Character c2) {
        if (c1 == null || c2 == null) return 0;
        int d1 = c1 - 'A', d2 = c2 - 'A';
        int x1 = d1 / 6, y1 = d1 % 6;
        int x2 = d2 / 6, y2 = d2 % 6;
        return Math.abs(x1-x2) + Math.abs(y1-y2);
    }
}