'''
Minimum Number of Frogs Croaking

Frogs can only be in one of 5 states: just
finished saying "c", just finished saying "r", etc.
We can manage the state of all frogs, and introduce a new frog only if necessary.
'''
class Solution(object):
    def minNumberOfFrogs(self, S):
        state = [0, 0, 0, 0, 0]
        if len(S) % 5:
            return -1
        ans = 0
        for c in S:
            i = 'croak'.find(c)
            if state[i - 1]:
                state[i - 1] -= 1
                state[i] += 1
            elif i == 0:
                ans += 1
                state[i] += 1
            else:
                return -1
        return ans if sum(state) == state[-1] else -1