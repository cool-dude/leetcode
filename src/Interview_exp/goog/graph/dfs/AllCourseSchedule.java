/*LC207:Course Schedule
* https://leetcode.com/problems/course-schedule/
There are a total of n courses you have
* to take, labeled from 0 to n-1.
Some courses may have prerequisites,
* for example to take course 0 you have to
* first take course 1, which is expressed as a pair: [0,1]
Given the total number of courses and a list of
* prerequisite pairs, is it possible for you to finish all courses?
Example 1:
Input: 2, [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take.
             To take course 1 you should have finished course 0. So it is possible.
Example 2:
Input: 2, [[1,0],[0,1]]
Output: false*/
import java.util.*;
class Sln1{
    public boolean canFinish(int n,int[][] prereqs){
        if(n==0||prereqs.length) return true;
        Map<Integer,Set<Integer>> map=new HashMap<>();
        for(int i=0;i<n;i++)
            map.put(i,new HashSet<>());
        int rem=n;
        for(int i=0;i<prereqs.length;i++){
            int[] t=prereqs[i];
            map.get(t[1]).add(t[0]);
        }
        Queue<Integer> q=new LinkedList();
        for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
            if (entry.getValue().size() == 0){
                q.offer(entry.getKey());
                rem--;
            }
        }
        while (!q.isEmpty()) {
            int k=q.poll();
            for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
                if(entry.getValue().contains(k)){
                    entry.getValue().remove(k);
                    if(entry.getValue().size()==0){
                        rem--;
                        q.offer(entry.getKey());
                    }
                }
            }
        }
        return (rem==0);
    }
    public static void main(String[] args) {
        int[][] in=new int[][]{{1,0}};
        System.out.printf(String.valueOf(canFinish(2,in)));
    }
}
/*LC210:Course Schedule II
https://leetcode.com/problems/course-schedule-ii/
There are a total of n courses you have to take,
* labeled from 0 to n-1.
Some courses may have prerequisites, for example
* to take course 0 you have to first take course 1,
* which is expressed as a pair: [0,1]
Given the total number of courses and a list of
* prerequisite pairs, return the ordering of courses
* you should take to finish all courses.
There may be multiple correct orders, you just need to
* return one of them. If it is impossible to finish all courses, return an empty array.
Example 1:
Input: 2, [[1,0]]
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished
             course 0. So the correct course order is [0,1] .
Example 2:
Input: 4, [[1,0],[2,0],[3,1],[3,2]]
Output: [0,1,2,3] or [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both
             courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
             So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3] .
Note:*/
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
class Sln2{
    List<Integer>[] g;
    public static void main(String[] args) {
        Sln2 sln = new Sln2();
        sln.findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}});
    }
    void buildGraph(int n,int[][] pre){
        for(int i=0;i<n;i++)
            g[i]=new ArrayList<>();
        for(int[] e:pre)
            g[e[1]].add(e[0]);
    }
    void dfs(int i,boolean[] vis,Deque<Integer> st){
        if(vis[i])
            return;
        vis[i]=true;
        List<Integer> nbrs=g[i];
        for(int nbr:nbrs){
            if(!vis[nbr])
                dfs(nbr,vis,st);
        }
        st.add(i);
    }
    public int[] findOrder(int n,int[][] pre){
        if(n<=1)
            return new int[]{};
        g=new ArrayList[n];
        buildGraph(n,pre);
        boolean[] vis=new boolean[n];
        Deque<Integer> st=new ArrayDeque<>();
        for(int i=0;i<n;i++){
            if(!vis[i])
                dfs(i,vis,st);
        }
        return st.toArray();
    }
}
/*LC630: Course Schedule III
https://leetcode.com/problems/course-schedule-iii/
There are n different online courses
numbered from 1 to n. Each course has
some duration(course length) t and closed on dth day.
A course should be taken continuously for
t days and must be finished before or
on the dth day. You will start at the 1st day.

Given n online courses represented by pairs (t,d), your task is to find the maximal number of courses that can be taken.
Example:
Input: [[100, 200], [200, 1300], [1000, 1250], [2000, 3200]]
Output: 3
Explanation:
There're totally 4 courses, but you can take 3 courses at most:
First, take the 1st course, it costs 100 days so you will finish it on the 100th day, and ready to take the next course on the 101st day.
Second, take the 3rd course, it costs 1000 days so you will finish it on the 1100th day, and ready to take the next course on the 1101st day.
Third, take the 2nd course, it costs 200 days so you will finish it on the 1300th day.
The 4th course cannot be taken now, since you will finish it on the 3300th day, which exceeds the closed date.
Note:
The integer 1 <= d, t, n <= 10,000.
You can't take two courses simultaneously.*/
class Sln3 {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses,(a,b)->a[1]-b[1]);
        //Sort the courses by their deadlines
        // (Greedy! We have to deal with courses with early deadlines first)
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        int time=0;
        for (int[] c:courses) {
            time+=c[0]; // add current course to a priority queue
            pq.add(c[0]);
            if (time>c[1]) time-=pq.poll();
            //If time exceeds, drop the previous course
            // which costs the most time. (That must be the best choice!)
        }
        return pq.size();
    }
}
/*LC1462: Course Schedule IV
https://leetcode.com/problems/course-schedule-iv/
There are a total of n courses you have to take,
labeled from 0 to n-1.
Some courses may have direct prerequisites,
for example, to take course 0 you have
first to take course 1, which is expressed as a pair: [1,0]
Given the total number of courses n,
a list of direct prerequisite pairs
and a list of queries pairs.
You should answer for each queries[i]
whether the course queries[i][0]
is a prerequisite of the course queries[i][1] or not.
Return a list of boolean, the
answers to the given queries.
Please note that if course a is a
prerequisite of course b and course
b is a prerequisite of course c,
then, course a is a prerequisite of course c.
Example 1:
Input: n = 2, prerequisites = [[1,0]], queries = [[0,1],[1,0]]
Output: [false,true]
Explanation: course 0 is not a
prerequisite of course 1 but the opposite is true.

Example 2:
Input: n = 2, prerequisites = [], queries = [[1,0],[0,1]]
Output: [false,false]
Explanation: There are no prerequisites and each course is independent.

Example 3:
Input: n = 3, prerequisites = [[1,2],[1,0],[2,0]], queries = [[1,0],[1,2]]
Output: [true,true]

Example 4:
Input: n = 3, prerequisites = [[1,0],[2,0]], queries = [[0,1],[2,0]]
Output: [false,true]

Example 5:
Input: n = 5, prerequisites = [[0,1],[1,2],[2,3],[3,4]], queries = [[0,4],[4,0],[1,3],[3,0]]
Output: [true,false,true,false
Constraints:
2 <= n <= 100
0 <= prerequisite.length <= (n * (n - 1) / 2)
0 <= prerequisite[i][0], prerequisite[i][1] < n
prerequisite[i][0] != prerequisite[i][1]
The prerequisites graph has no cycles.
The prerequisites graph has no repeated edges.
1 <= queries.length <= 10^4
queries[i][0] != queries[i][1]*/
class Sln4 {
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        boolean[][] connect = new boolean[n][n];
        for (int[] p : prerequisites)
            connect[p[0]][p[1]] = true; // p[0] -> p[1]
        for (int k = 0; k < n; k++)
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    connect[i][j] = connect[i][j] || (connect[i][k] && connect[k][j]);
        List<Boolean> ans = new ArrayList<>();
        for (int[] q : queries)
            ans.add(connect[q[0]][q[1]]);
        return ans;
    }
}