class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // init data
        int newStart = newInterval[0], newEnd = newInterval[1];
        int idx = 0, n = intervals.length;
        LinkedList<int[]> output = new LinkedList<int[]>();

        // add all intervals starting before newInterval
        while (idx < n && newStart > intervals[idx][0])
            output.add(intervals[idx++]);

        // add newInterval
        int[] interval = new int[2];
        // if there is no overlap, just add the interval
        if (output.isEmpty() || output.getLast()[1] < newStart)
            output.add(newInterval);
            // if there is an overlap, merge with the last interval
        else {
            interval = output.removeLast();
            interval[1] = Math.max(interval[1], newEnd);
            output.add(interval);
        }

        // add next intervals, merge with newInterval if needed
        while (idx < n) {
            interval = intervals[idx++];
            int start = interval[0], end = interval[1];
            // if there is no overlap, just add an interval
            if (output.getLast()[1] < start) output.add(interval);
                // if there is an overlap, merge with the last interval
            else {
                interval = output.removeLast();
                interval[1] = Math.max(interval[1], end);
                output.add(interval);
            }
        }
        return output.toArray(new int[output.size()][2]);
    }
}





























Algorithm:
        Here is the algorithm :
        Add to the output all the intervals starting before newInterval.

        Add to the output newInterval. Merge it with the last added interval if newInterval starts before the last added interval.

        Add the next intervals one by one. Merge with the last added interval if the current interval starts before the last added interval.

        Implementation
class Soln {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // init data
        int newStart = newInterval[0], newEnd = newInterval[1];
        int idx = 0, n = intervals.length;
        LinkedList<int[]> op = new LinkedList<int[]>();

        while (idx < n && newStart > intervals[idx][0]) {
            op.add(intervals[idx++]);
        }

        //add interval
        int[] interval = new int[2];
        //if no override, just add interval
        if (op.isEmpty() || op.getLast()[1] < newStart) {
            op.add(newInterval);
        }
        //overlap, check and add
        else {
            interval = op.removeLast();
            interval[1] = Math.max(interval[1], newEnd);
            op.add(interval);
        }
        // add next intervals, merge with newInterval if needed
        while (idx<n){
            interval=interval[idx++];
            int start=interval[0], end=interval[1];
            // if there is no overlap,
            // just add an interval
            if(op.getLast()[1]<start){
                op.add(interval);
            }
            //overlap
            else{
                interval=op.removeLast();
                interval[1]=Math.max(interval[1], end);
                op.add(interval);
            }
        }
        return op.toArray(new int[op.size()][2]);
    }
}