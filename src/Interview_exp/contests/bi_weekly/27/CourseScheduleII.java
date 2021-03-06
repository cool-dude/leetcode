/*LC210. Course Schedule II
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
package data_structure.graph.dfs;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
class Sln1 {
    List<Integer>[] g;
    public static void main(String[] args) {
        CourseScheduleII courseScheduleII = new CourseScheduleII();
        courseScheduleII.findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}});
    }
    void buildGraph(int n,int[][] pre){
        for(int i=0;i<n;i++){
            g[i]=new ArrayList<>();
        }
        for(int[] e:pre){
            g[e[1]].add(e[0]);
        }
    }
    void dfs(int i,boolean[] visited, Deque<Integer> stack){
        if(visited[i])
            return;
        visited[i]=true;
        List<Integer> nbrs=g[i];
        for(int nbr:nbrs){
            if(!visited[nbr])
                dfs(nbr, vis, stack);
        }
        stack.add(i);
    }
    public int[] findOrder(int n,int[][] pre){
        if(n<=1)
            return new int[]{};
        g=new ArrayList[n];
        buildGraph(n,pre);
        boolean[] visited=new boolean[n];
        Deque<Integer> stack=new ArrayDeque<>();
        for(int i=0;i<n;i++){
            if(!visited[i])
                dfs(i,visited,stack);
        }
        return stack.toArray();
    }
}

class Sln2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) return null;
        // Convert graph presentation from edges to indegree of adjacent list.
        int indegree[] = new int[numCourses], order[] = new int[numCourses], index = 0;
        for (int i = 0; i < prerequisites.length; i++) // Indegree - how many prerequisites are needed.
            indegree[prerequisites[i][0]]++;

        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++)
            if (indegree[i] == 0) {
                // Add the course to the order because it has no prerequisites.
                order[index++] = i;
                queue.offer(i);
            }

        // How many courses don't need prerequisites.
        while (!queue.isEmpty()) {
            int prerequisite = queue.poll(); // Already finished this prerequisite course.
            for (int i = 0; i < prerequisites.length; i++) {
                if (prerequisites[i][1] == prerequisite) {
                    indegree[prerequisites[i][0]]--;
                    if (indegree[prerequisites[i][0]] == 0) {
                        // If indegree is zero, then add the course to the order.
                        order[index++] = prerequisites[i][0];
                        queue.offer(prerequisites[i][0]);
                    }
                }
            }
        }
        return (index == numCourses) ? order : new int[0];
    }
}