'''
Given a length n, count the number of strings of
length n that can be made using ‘a’, ‘b’ and ‘c’
with at-most one ‘b’ and two ‘c’s allowed.
'''
def count_abc(n,nb,nc):
    if (nb<0 or nc<0):
        return 0
    if (n==0):
        return 1
    if (n==1):
        return 1+(1 if nb else 0)+(1 if nc else 0)
    if(nb==0 and nc==0):
        return 1

    # Three cases, we choose, a or b or c
    # In all three cases n decreases by 1.
    res = count_abc(n-1, nb, nc)
    res += count_abc(n-1, nb-1, nc)
    res += count_abc(n-1, nb, nc-1)

# Driver code
if __name__ =="__main__":
    n = 3 # Total number of characters
    print(countStr(n, 1, 2))
'''
T(n):O(2^n)
'''
