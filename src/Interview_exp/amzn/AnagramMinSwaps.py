def checkChars(s1, s2):
    chars = {}
    if len(s1) != len(s2):
        return False

    for c in s1:
        if c not in chars:
            chars[c] = 0
        chars[c] += 1

    for c in s2:
        if c not in chars or chars[c] == 0:
            return False
        chars[c] -= 1
    return True

def minNumOfSwaps(s1, s2, i):
    if i == 0:
        if s1[0] == s2[0]:
            return 0
        else:
            return 1

    if s1[i] == s2[i]:
        return minNumOfSwaps(s1, s2, i-1)
    else:
        return minNumOfSwaps(s1, s2, i-1)+1

def solve(s1, s2):
    if not checkChars(s1, s2):
        return -1
    return math.ceil(minNumOfSwaps(s1, s2, len(s1)-1)/2)

s1 = "aabcdeer"
s2 = "aebcedra"
print(solve(s1, s2))