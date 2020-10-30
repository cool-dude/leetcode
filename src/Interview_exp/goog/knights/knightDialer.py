'''LC935:Knight Dialer
https://leetcode.com/problems/knight-dialer/solution/
A chess knight can move as indicated in
the chess diagram below:
This time, we place our chess knight on any numbered
key of a phone pad (indicated above), and the
knight makes N-1 hops.  Each hop must be from
one key to another numbered key.
Each time it lands on a key (including the
initial placement of the knight), it presses the number of that key, pressing N digits total.
How many distinct numbers can you dial in this manner?
'''
/*SOLN1*/
NEIGHBORS_MAP={
    0:(4,6),
    1:(6,8),
    2:(7,9),
    3:(4,8),
    4:(3,9,0),
    5:(),
    6:(1,7,0),
    7:(2,6),
    8:(1,3),
    9:(2,4)
}
def neighbors(position):
    return NEIGHBORS_MAP[position]
def count_sequences(starting_pos, num_hops):
    if num_hops == 0:
        return 1
    num_sequences = 0
    for position in neighbors(starting_pos):
        num_sequences += count_sequences(position, num_hops-1)
    return num_sequences
if __name__ == '__main__':
    print(count_sequences(6, 2))

/*SOLN2*/
NEIGHBORS_MAP={
    0:(4,6),
    1:(6,8),
    2:(7,9),
    3:(4,8),
    4:(3,9,0),
    5:((),
    6:(1,7,0),
    7:(2,6),
    8:(1,3),
    9:(2,4)
}
def neighbors(position):
    return NEIGHBORS_MAP[position]
def count_sequences(starting_pos, num_hops):
    cache={}
    def helper(position, num_hops):
        if(position, num_hops) in cache:
            return cache[(position, num_hops)]
        if num_hops==0:
            return 1
        else:
            num_sequences = 0
            for neighbor in neighbors(position):
                num_sequences+=count_sequences(neighbor, num_hops-1)
            cache[(position, num_hops)]=num_sequences
            return num_sequences
    res = helper(starting_pos, num_hops)
    return res

/*SOLN4*/
NEIGHBORS_MAP={
    0:(4,6),
    1:(6,8),
    2:(7,9),
    3:(4,8),
    4:(3,9,0),
    5:((),
    6:(1,7,0),
    7:(2,6),
    8:(1,3),
    9:(2,4)
}
def neighbors(position):
    return NEIGHBORS_MAP[position]
def count_sequences(starting_pos, num_hops):
    prior_case=[1]*10
    cur_case=[0]*10
    cur_num_hops=1
    while cur_num_hops <= num_hops:
        cur_case =[0]*10
        cur_num_hops+=1
        for position in range(0,10):
            for neighbor in neighbors(position):
                cur_case[position] += prior_case[neighbor]
        prior_case = cur_case
    return cur_case[starting_pos]