/*LC753: Cracking the Safe
https://leetcode.com/problems/cracking-the-safe/discuss/153039/DFS-with-Explanations
There is a box protected by a password.
The password is a sequence of n digits where
each digit can be one of the first k digits 0, 1, ..., k-1.
While entering a password, the last n
digits entered will automatically be
matched against the correct password.
For example, assuming the correct password is "345",
if you type "012345", the box will open because
the correct password matches the suffix of the entered password.
Return any password of minimum length that is
guaranteed to open the box at some point of entering it.

Example 1:
Input: n = 1, k = 2
Output: "01"
Note: "10" will be accepted too.

Example 2:
Input: n = 2, k = 2
Output: "00110"
Note: "01100", "10011", "11001" will be accepted too.*/
class Solution {
    public String crackSafe(int n, int k) {
        // Initialize pwd to n repeated 0's as the start node of DFS.
        String strPwd = String.join("", Collections.nCopies(n, "0"));
        StringBuilder sbPwd = new StringBuilder(strPwd);

        Set<String> visitedComb = new HashSet<>();
        visitedComb.add(strPwd);

        int targetNumVisited = (int) Math.pow(k, n);

        crackSafeAfter(sbPwd, visitedComb, targetNumVisited, n, k);

        return sbPwd.toString();
    }
    private boolean crackSafeAfter(StringBuilder pwd, Set<String> visitedComb, int targetNumVisited, int n, int k) {
        // Base case: all n-length combinations among digits 0..k-1 are visited.
        if (visitedComb.size() == targetNumVisited) {
            return true;
        }
        String lastDigits = pwd.substring(pwd.length() - n + 1); // Last n-1 digits of pwd.
        for (char ch = '0'; ch < '0' + k; ch++) {
            String newComb = lastDigits + ch;
            if (!visitedComb.contains(newComb))  {
                visitedComb.add(newComb);
                pwd.append(ch);
                if (crackSafeAfter(pwd, visitedComb, targetNumVisited, n, k)) {
                    return true;
                }
                visitedComb.remove(newComb);
                pwd.deleteCharAt(pwd.length() - 1);
            }
        }
        return false;
    }
}