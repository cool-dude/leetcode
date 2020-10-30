package dp;
import java.util.*;

public class Job {
    public int start;
    public int end;
    public int profit;

    public Job(int start, int end, int profit) {
        this.start = start;
        this.end = end;
        this.profit = profit;
    }
}

class JobComparator implements Comparator<Job>{
    public int compare(Job a,Job b){
        return a.end < b.end ? -1 : a.end == b.end ? 0 : 1;
    }
}

public class JobScheduling {
    /* A Binary Search based function to find the latest job
    (before current job) that doesn't conflict with current
    job.  "index" is index of the current job.  This function
    returns -1 if all jobs before index conflict with it.
    The array jobs[] is sorted in increasing order of finish
    time. */
    static private int binSearchJob(Job[] jobs, int index){
        int low=0, high=index-1;

        while(low <= high){
            int mid=low + (high-low)/2;
            if(jobs[mid].end <= jobs[index].start) {
                if(jobs[mid+1].end <= jobs[index].start)
                    low = mid+1;
                else
                    return mid;
            }
            else
                high = mid-1;
        }
        return -1;
    }

    // The main function that returns the maximum possible
    // profit from given array of jobs
    static public int schedule(Job[] jobs){
        // Sort jobs according to finish time
        Arrays.sort(jobs, new JobComparator());
        int n = jobs.length;
        // Create an array to store solutions of subproblems.  table[i]
        // stores the profit for jobs till arr[i] (including arr[i])
        int table[] = new int[n];
        table[0] = jobs[0].profit;

        for(int i=1;i<n;i++){
            int inclProfit = jobs[i].profit;
            int l = binSearchJob(jobs,i);
            if(l!=-1)
                inclProfit += table[l];
            table[i] = Math.max(inclProfit, table[i-1]);
        }
        return table[n-1];
    }
}