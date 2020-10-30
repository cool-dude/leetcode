/*Minimum Number of Platforms/Rooms Required for Station/Meetings
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
        //merge process of merge-sort to create single
        //sorted list
        while (i<n && j<n){
            if(start[j]<=end[i]){
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
    class Interval{
        int start;
        int end;
    }
    public int minMeetingRooms(Interval[] intervals){
        if(intervals.length==0||intervals==null)
            return 0;
        Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1,Interval i2){
                return i1.start-i2.start;
            }
        });
        PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
        int count=1;
        pq.offer(intervals[0].end);
        for(int i=1;i<intervals.length;i++){
            if(intervals[i].start<=pq.peek()){
                count++;
            }
            else {
                pq.poll();
            }
            pq.offer(intervals[i].end);
        }
        return count;
    }
    //T:O(nlgn).
    //S:O(n).
}