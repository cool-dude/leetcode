Problem:
For a given array of distinct  integers
and two integers  and , the goal is to
find the number of subsequences of  with
exactly  local minimums and  local maximums.
For a subsequence  of , element  for  is a
local minimum if and only if . Similarly,
is a local maximum if and only if .

Since subsequences can be build incrementally,
dynamic programming approach to this problem sounds promising.

Initial solution
Let  be the number of subsequences of  ending
in  with exactly  local minimums, exactly
local maximums and the last element smaller
than the one before last element taken to a subsequence.

Similarly, let  be the number of subsequences of
ending in  with exactly  local minimums, exactly
local maximums and the last element greater than
the one before last element taken to a subsequence.

With these values defined, any entry of  table with the
 as the value of its first dimension can be computed using
 entries with values of first dimension smaller than.