/*Given a set of distinct positive integers,
find the largest subset such that every pair
(Si, Sj) of elements in this subset satisfies:

Si % Sj = 0 or Sj % Si = 0.
If there are multiple solutions, return any subset is fine.

Example 1:
Input: [1,2,3]
Output: [1,2] (of course, [1,3] will also be ok)
Example 2:
Input: [1,2,4,8]
Output: [1,2,4,8]
1. Sort all array elements in increasing order.
The purpose of sorting is to make sure that all
divisors of an element appear before it.
2. Create an array dp[] of same size as input array.
dp[i] stores size of divisible subset ending with
arr[i] (In sorted array). The minimum value of
dp[i] would be 1.
3. Traverse all array elements. For every element,
find a divisor arr[j] with largest value of dp[j]
and store the value of dp[i] as dp[j] + 1.*/
class Sln {
    // if we sort the array, every element
    // in a divisibleSubset can be divisible
    // by the element just before it.
    // for any element k, its largestDivisibleSubset
    // that ends with k can be formed in the following way:
    // use element k after any one of the
    // previous elements that is divisble
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int[] l = new int[nums.length]; // the length of largestDivisibleSubset that ends with element i
        int[] prev = new int[nums.length];
        // the previous index of element i in
        // the largestDivisibleSubset ends with element i
        Arrays.sort(nums);
        int max = 0;
        int idx = -1;
        for (int i = 0; i < nums.length; i++){
            l[i] = 1;
            prev[i] = -1;
            for (int j = i - 1; j >= 0; j--){
                if (nums[i] % nums[j] == 0 && l[j] + 1 > l[i]){
                    l[i] = l[j] + 1;
                    prev[i] = j;
                }
            }
            if (l[i] > max){
                max = l[i];
                idx = i;
            }
        }
        List<Integer> res = new ArrayList<Integer>();
        while (idx != -1){
            res.add(nums[idx]);
            idx = prev[idx];
        }
        return res;
    }
}