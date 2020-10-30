'''LC1087: Brace Expansion
https://leetcode.com/problems/brace-expansion/
A string S represents a list of words.
Each letter in the word has 1 or more options.  
If there is one option, the letter is 
represented as is.  If there is more than 
one option, then curly braces delimit the 
options.  For example, "{a,b,c}" represents 
options ["a", "b", "c"].

For example, "{a,b,c}d{e,f}" represents 
the list ["ade", "adf", "bde", "bdf", "cde", "cdf"].

Return all words that can be formed in this manner, in lexicographical order.
Example 1:
Input: "{a,b}c{d,e}f"
Output: ["acdf","acef","bcdf","bcef"]
Example 2:
Input: "abcd"
Output: ["abcd"]
Note:
1 <= S.length <= 50
There are no nested curly brackets.
All characters inside a pair of consecutive opening and ending curly brackets are different.'''
class Sln(object):
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

class Sln2(object):
    def permute(self, S):
            A = S.replace('{', ' ').replace('}', ' ').strip().split(' ')
        B = [sorted(a.split(',')) for a in A]
        return [''.join(c) for c in itertools.product(*B)]