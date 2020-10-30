/*LC1136: Parallel Courses
https://leetcode.com/problems/parallel-courses/
There are N courses, labelled from 1 to N.
We are given relations[i] = [X, Y],
representing a prerequisite relationship
between course X and course Y:
course X has to be studied before course Y.
In one semester you can study any number
of courses as long as you have studied
all the prerequisites for the course you are studying.
Return the minimum number of semesters
needed to study all courses.  If there
is no way to study all the courses, return -1.
Example 1:
Input: N = 3, relations = [[1,3],[2,3]]
Output: 2
Explanation:
In the first semester, courses 1 and 2 are studied. In the second semester, course 3 is studied.

Example 2:
Input: N = 3, relations = [[1,2],[2,3],[3,1]]
Output: -1
Explanation:
No course can be studied because they depend on each other.*/
class Sln1{
    public int minimumSemesters(int n,int[][] relations){
        Map<Integer,List<Integer>> g=new HashMap<>();
        int[] inDeg=new int[n+1];//indegree:number of prereqs of i
        for(int[] r:relations){
            g.computeIfAbsent(r[0],l->new ArrayList()).add(r[1]);//construct graph
            ++inDeg[r[1]]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=1;i<=n;i++)
            if(inDeg[i]==0)
                q.offer(i);
            int sem=0;
        while (!q.isEmpty()){
            for(int sz=q.size();sz>0;--sz){
                int c=q.poll();
                --n;
                if(!g.containsKey(c)) continue;
                for(int course:g.remove(c))
                    if(--inDeg[course]==0)
                        q.offer(course);
            }
            ++sem;
        }
        return n==0?sem:-1;
    }
}
/*LC1494: Parallel Courses II
https://leetcode.com/problems/parallel-courses-ii/
Given the integer n representing the number
of courses at some university labeled from
1 to n, and the array dependencies where
dependencies[i] = [xi, yi]  represents a
prerequisite relationship, that is, the
course xi must be taken before the course yi.
Also, you are given the integer k.

In one semester you can take at most k
courses as long as you have taken all
the prerequisites for the courses you are taking.

Return the minimum number of semesters
to take all courses. It is guaranteed
that you can take all courses in some way.
Example 1:
Input: n = 4, dependencies = [[2,1],[3,1],[1,4]], k = 2
Output: 3
Explanation: The figure above represents the given graph. In this case we can take courses 2 and 3 in the first semester, then take course 1 in the second semester and finally take course 4 in the third semester.

Example 2:
Input: n = 5, dependencies = [[2,1],[3,1],[4,1],[1,5]], k = 2
Output: 4
Explanation: The figure above represents the given graph. In this case one optimal way to take all courses is: take courses 2 and 3 in the first semester and take course 4 in the second semester, then take course 1 in the third semester and finally take course 5 in the fourth semester.

Example 3:
Input: n = 11, dependencies = [], k = 2
Output: 6*/
class Sln2 {
    public int minNumberOfSemesters(int n, int[][] deps, int k) {
        int[] preq = new int[n];
        for (int[] dep : deps) {
            // to study j, what are the prerequisites?  each set bit is a class that we need to take. ith bit means ith class
            // -1 because classes are 1 to n
            preq[dep[1] - 1] |= 1 << (dep[0] - 1);
        }
        int[] dp = new int[1 << n];
        Arrays.fill(dp, n);
        dp[0] = 0;
        for (int i = 0; i < (1 << n); i++) {
            // we are now at status i. we can "influence" a later status from this status
            int canStudy = 0;   // what are the classes we can study?
            for (int j = 0; j < n; j++) {
                // a & b== b means b is a's subset
                // so if preq[j] is i's subset, we can now study j given status i
                if ((i & preq[j]) == preq[j]) {
                    canStudy |= (1 << j);
                }
            }
            canStudy &= ~i;
            // take out i, so that we only enumerate a subset canStudy without i.
            // note we will | later so here we need a set that has no intersection with i to reduce the enumeration cost
            for (int sub = canStudy; sub > 0; sub = (sub - 1) & canStudy) {
                // we can study one or more courses indicated by set "canStudy". we need to enumerate all non empty subset of it.
                // This for loop is a typical way to enumerate all subsets of a given set "canStudy"
                // we studied i using dp[i] semesters. now if we also study the subset sub, we need dp [i ]+1 semesters,
                // and the status we can "influence" is dp[ i | sub] because at that state, we studied what we want to study in "sub"
                if (Integer.bitCount(sub) <= k) {
                    dp[i | sub] = Math.min(dp[i | sub], dp[i] + 1);
                }
            }
        }
        return dp[(1 << n) - 1];
    }
}