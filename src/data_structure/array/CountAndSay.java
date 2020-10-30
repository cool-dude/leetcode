package coderbyte;
/*LC38: Count and Say
* https://leetcode.com/problems/count-and-say/
1.     1
2.     11
3.     21
4.     1211
5.     111221
1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.

Input: 1
Output: "1"
Explanation: This is the base case.
Example 2:

Input: 4
Output: "1211"
Explanation: For n = 3 the term was "21" in which we have two
* groups "2" and "1", "2" can be read as "12" which means
* frequency = 1 and value = 2, the same way "1" is read as "11",
* so the answer is the concatenation of "12" and "11"
* which is "1211".*/
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
class Sln {
    public String countAndSay(int n) {
        if (n == 1)
            return "1";
        String prev = countAndSay(n - 1);
        char[] cs = prev.toCharArray();
        StringBuilder sb = new StringBuilder();
        int cnt = 1;
        for (int i = 0; i < cs.length; i++) {
            if (i + 1 < cs.length && cs[i] == cs[i + 1])
                cnt++;
            else {
                if(cnt>1) {
                    sb.append(cnt);
                }
                sb.append(cs[i]);
                cnt = 1;
            }
        }
        return sb.toString();
    }
}