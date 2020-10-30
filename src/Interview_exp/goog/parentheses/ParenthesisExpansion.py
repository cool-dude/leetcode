'''LC1087:Brace Expansion
https://leetcode.com/problems/brace-expansion/
A string S represents a list of words.
Each letter in the word has 1 or more options.
If there is one option, the letter is represented as is.
If there is more than one option, then curly braces
delimit the options. For example, “{a,b,c}”
represents options [“a”, “b”, “c”].

For example, “{a,b,c}d{e,f}” represents the
list [“ade”, “adf”, “bde”, “bdf”, “cde”, “cdf”]'''
class Solution(object):
    def expand(self, S):
        """
        :type S: str
        :rtype: List[str]
        """
        self.res = []
        def helper(s, word):
            if not s:
                self.res.append(word)
            else:
                if s[0] == "{":
                    i = s.find("}")
                    for letter in s[1:i].split(','):
                        helper(s[i+1:], word+letter)
                else:
                    helper(s[1:], word + s[0])
        helper(S, "")
        self.res.sort()
        return self.res