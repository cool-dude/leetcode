/*LC252:Meeting Rooms
https://leetcode.com/problems/meeting-rooms/
Given an array of meeting time intervals
consisting of start and end times
[[s1,e1],[s2,e2],...] (si < ei),
determine if a person could attend all meetings.
Example 1:
Input: [[0,30],[5,10],[15,20]]
Output: false

Example 2:
Input: [[7,10],[2,4]]
Output: true
NOTE: input types have been changed on April 15, 2019.
Please reset to default code definition to get new method signature.*/
class Sln{
    public boolean canAttentMeetings(int[][] ints){
        if(ints==null||ints.length==0) return false;
        Arrays.sort(ints,new Comparator<int[]>(){
            public int compare(int[] a,int[] b){ return a[0]-b[0];}
        });
        for(int i=1;i<ints.length;i++)
            if(ints[i][0]<ints[i-1][1])
                return false;
        return true;
    }
}
/*LC253: Meeting Rooms II
Given an array of meeting time intervals
consisting of start and end times
[[s1,e1],[s2,e2],...] (si < ei),
find the minimum number of conference rooms required.
Example 1:
Input: [[0, 30],[5, 10],[15, 20]]
Output: 2
Example 2:
Input: [[7,10],[2,4]]
Output: 1*/
class Sln2 {
    public int minMeetingRooms(int[][] ints){
        if(ints.length==0||ints==null) return 0;
        PriorityQueue<Integer> pq=
                new PriorityQueue<Integer>(
                        ints.length,
                        new Comparator<Integer>(){
                            public int compare(Integer a,Integer b){ return a-b;}
                        }
                );
        Arrays.sort(ints,new Comparator<int[]>(){
            public int compare(int[] a,int[] b){ return a[0]-b[0];}
        });
        pq.add(ints[0][1]);
        for(int i=1;i<ints.length;i++){
            if(ints[i][0]>pq.peek())
                pq.poll();
            pq.offer(ints[i][1]);
        }
        return pq.size();
    }
}