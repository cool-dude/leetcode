/*LC207: Course Schedule
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
class CourseSchedule {
    public static void main(String[] args) {
        int[][] in=new int[][]{{1,0}};
        System.out.printf(String.valueOf(canFinish(2,in)));
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses==0)
            return true;
        if(prerequisites.length==0)
            return true;
        HashMap<Integer, Set<Integer>> map=new HashSet<>();
        for(int i=0;i<numCourses;i++){
            map.put(i, new HashSet<Integer>());
        }
        int remaining = numCourses;
        for(int i=0;i<prerequisites.length;i++){
            int[] temp=prerequisites[i];
            map.get(temp[1]).add(temp[0]);
        }
        Queue<Integer> q=new LinkedList();
        for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
            if (entry.getValue().size() == 0){
                q.offer(entry.getKey());
                remaining--;
            }
        }
        while (!q.isEmpty()) {
            int k=q.poll();
            for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
                if(entry.getValue().contains(k)){
                    entry.getValue().remove(k);
                    if(entry.getValue().size()==0){
                        remaining--;
                        q.offer(entry.getKey());
                    }
                }
            }
        }
        return (remaining==0);
    }
}