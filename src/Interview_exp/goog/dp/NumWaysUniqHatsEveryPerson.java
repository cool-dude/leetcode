/*The first line contains the value of n, next n lines contain collections
of all the n persons.
Input:
3
5 100 1     // Collection of the first person.
2           // Collection of the second person.
5 100       // Collection of the third person.

Output:
4
Explanation: All valid possible ways are (5, 2, 100),  (100, 2, 5),
            (1, 2, 5) and  (1, 2, 100)*/
/*SOLN:
Let i be the current cap number (caps from 1 to i-1 are already
processed). Let integer variable mask indicates that the persons w
earing and not wearing caps.  If i'th bit is set in mask, then
i'th person is wearing a cap, else not.

             // consider the case when ith cap is not included
                     // in the arrangement
countWays(mask, i) = countWays(mask, i+1) +

                    // when ith cap is included in the arrangement
                    // so, assign this cap to all possible persons
                    // one by one and recur for remaining persons.
                    ∑ countWays(mask | (1 << j), i+1)
                       for every person j that can wear cap i

Note that the expression "mask | (1 << j)" sets j'th bit in mask.
And a person can wear cap i if it is there in the person's cap list
provided as input.*/
class Sln {
    static final int MOD = 1000000007;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Vector<Integer> capList[] = new Vector[101];

    // dp[2^10][101] .. in dp[i][j], i denotes the mask i.e., it tells that
    // how many and which persons are wearing cap. j denotes the first j caps
    // used. So, dp[i][j] tells the number ways we assign j caps to mask i
    // such that none of them wears the same cap
    static int dp[][] = new int[1025][101];

    // This is used for base case, it has all the N bits set
    // so, it tells whether all N persons are wearing a cap.
    static int allmask;

    // Mask is the set of persons, i is cap-id (OR the
    // number of caps processed starting from first cap).
    static long countWaysUtil(int mask, int i) {
        // If all persons are wearing a cap so we
        // are done and this is one way so return 1
        if (mask == allmask) return 1;

        // If not everyone is wearing a cap and also there are no more
        // caps left to process, so there is no way, thus return 0;
        if (i > 100) return 0;

        // If we already have solved this subproblem, return the answer.
        if (dp[mask][i] != -1) return dp[mask][i];

        // Ways, when we don't include this cap in our arrangement
        // or solution set.
        long ways = countWaysUtil(mask, i+1);

        // size is the total number of persons having cap with id i.
        int size = capList[i].size();

        // So, assign one by one ith cap to all the possible persons
        // and recur for remaining caps.
        for (int j = 0; j < size; j++) {
            // if person capList[i][j] is already wearing a cap so continue as
            // we cannot assign him this cap
            if ((mask & (1 << capList[i].get(j))) != 0) continue;
            // Else assign him this cap and recur for remaining caps with
            // new updated mask vector
            else ways += countWaysUtil(mask | (1 << capList[i].get(j)), i+1);
            ways %= MOD;
        }
        // Save the result and return it.
        return dp[mask][i] = (int) ways;
    }
    // Reads n lines from standard input for current test case
    static void countWays(int n) throws Exception {
        //----------- READ INPUT --------------------------
        String str;
        String split[];
        int x;

        for (int i=0; i<n; i++) {
            str = br.readLine();
            split = str.split(" ");

            // while there are words in the split[]
            for (int j = 0; j < split.length; j++) {
                // add the ith person in the list of cap if with id x
                x = Integer.parseInt(split[j]);
                capList[x].add(i);
            }
        }
        // All mask is used to check of all persons
        // are included or not, set all n bits as 1
        allmask = (1 << n) - 1;
        // Initialize all entries in dp as -1
        for (int[] is : dp) {
            for (int i = 0; i < is.length; i++) {
                is[i] = -1;
            }
        }
        // Call recursive function count ways
        System.out.println(countWaysUtil(0, 1));
    }
    // Driver method
    public static void main(String args[]) throws Exception {
        int n;   // number of persons in every test case

        // initializing vector array
        for (int i = 0; i < capList.length; i++)
            capList[i] = new Vector<>();

        n = Integer.parseInt(br.readLine());
        countWays(n);
    }
}