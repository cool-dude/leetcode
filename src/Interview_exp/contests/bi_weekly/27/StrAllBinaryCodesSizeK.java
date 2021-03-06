/*1461. Check If a String Contains
https://leetcode.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k/
All Binary Codes of Size K
Return True if all binary codes of
length k is a substring of s. Otherwise, return False.

Example 1:
Input: s = "00110110", k = 2
Output: true
Explanation: The binary codes of length 2 are
"00", "01", "10" and "11". They can be all
found as substrings at indicies 0, 1, 3 and 2 respectively.

Example 2:
Input: s = "00110", k = 2
Output: true

Example 3:
Input: s = "0110", k = 1
Output: true
Explanation: The binary codes of length 1 are "0" and "1",
it is clear that both exist as a substring.

Example 4:
Input: s = "0110", k = 2
Output: false
Explanation: The binary code "00" is of length 2 and doesn't exist in the array.

Example 5:
Input: s = "0000000001011100", k = 4
Output: false*/
class Sln {
    public boolean hasAllCodes(String s, int k) {
        Set<String> set=new HashSet<>();
        if(s.length()<k) return false;
        for(int i=0;i<s.length()-k;i++) set.add(s.substring(i,i+k));
        return s.length()==Math.pow(2,k);
    }
}