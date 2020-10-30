from typing import List

class Sln(object):
    def balancing_possible(nums):
        if len(a)<5:
            return False
        i=1
        j=len(a)-2
        while i!=j:
            if sum(a[:i])==sum(a[i+1:j])==sum(a[j+1:]):
                return True
            if sum(a[:i])<=sum(a[j+1:]):
                i+=1
            else:
                j-=1
        return False

print(Sln.balancing_possible([1, 3, 4, 2, 2, 2, 1, 1, 2])) # true
print(balancing_possible([1, 1, 1, 1, 1, 1])) # false
print(balancing_possible([1, 2] * 10000)) # true