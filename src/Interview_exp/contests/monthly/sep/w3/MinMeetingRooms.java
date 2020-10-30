/*LC253:Meeting Rooms II
https://leetcode.com/problems/meeting-rooms-ii/
Minimum Number of Platforms/Rooms Required for Station/Meetings
Given arrival and departure times all trains/meetings
that reach railway station,
the task is to find the minimum number of
platforms required for the railway station so that no train waits.*/
class Sln1{
    public int numberMeetingRooms(int[] start,int[] end){
        if(start.length==0||start==null||end.length==0||end==null||start.length!=end.length)
            return -1;
        Arrays.sort(start);
        Arrays.sort(end);
        int cur_rooms=1,result=1;
        int i=0,j=1,n=start.length;
        while (i<n && j<n){
            if(end[i]>=start[j]){
                cur_rooms++;
                j++;
                result=Math.max(result,cur_rooms);
            }
            else {
                cur_rooms--;
                i++;
            }
        }
        return result;
    }
    //T:O(nlgn)
    //S:O(1).
}
class Sln2{
    public int minMeetingRooms(int[][] intervals){
        if(intervals.length==0||intervals==null)
            return 0;
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] i1,int[] i2){
                return i1[0]-i2[0];
            }
        });
        PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
        int count=1;
        pq.offer(intervals[0][1]);
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<=pq.peek()){
                count++;
            }
            else {
                pq.poll();
            }
            pq.offer(intervals[i][1]);
        }
        return count;
    }
    //T:O(nlgn).
    //S:O(n).
    public int minMeetingRooms(Interval[] intervals) {
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        for(int i=0; i<intervals.length; i++) {
            starts[i] = intervals[i].start;
            ends[i] = intervals[i].end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int rooms = 0;
        int endsItr = 0;
        for(int i=0; i<starts.length; i++) {
            if(starts[i]<ends[endsItr])
                rooms++;
            else
                endsItr++;
        }
        return rooms;
    }
    //T:O(nlgn)
    //S:O(1)
}