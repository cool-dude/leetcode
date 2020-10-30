Sub-problem: DPn be the number of ways to write N as the sum of 1, 3, and 4.
Finding recurrence: Consider one possible solution, n = x1 + x2 + ... xn. If the last number is 1, the sum of the remaining numbers should be n - 1. So, number of sums that end with 1 is equal to DPn-1.. Take other cases into account where the last number is 3 and 4. The final recurrence would be:

DPn = DPn-1 + DPn-3 + DPn-4.

Take care of the base cases. DP0 = DP1 = DP2 = 1, and DP3 = 2.

Implementation:

 DP[0] = DP[1] = DP[2] = 1; DP[3] = 2;
    for (i = 4; i <= n; i++) {
      DP[i] = DP[i-1] + DP[i-3] + DP[i-4];
    }