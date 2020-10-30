/*There is a meeting scheduled in office
that lasts for time t and starts at time 0.
 In between the meeting there are n presentations
  whose start and end times are given i.e.
  the ith presentation starts at s[i] and ends at e[i]-1. T
  he presentations do not overlap with each other.
  You are given k, the maximum number of presentations
   that you can reschedule keeping the original order intact.
   Note that the duration of the presentation can’t be changed.
   You can only change the start and end time. Your task is to
   maximize the longest time period in which there is no presentation scheduled during the meeting.*/
class Sln{
    public int maxMeetingTime(int t,int[][] meetings,int k){
        int prevEnd=0;
        int[] arr=new int[meetings.length+1];
        for(int i=0;i<meetings.length;i++){
            int s=meetings[i][0];
            int e=meetings[i][1];
            arr[i]=s-prevEnd;
            prevEnd=e;
        }
        arr[meetings.length]=t-prevEnd;
        int sum=0;
        for(int i=0;i<k&&i<meetings.length;i++)
            sum += arr[i];
        int max = sum;
        for(int i=k;i<=meetings.length;i++){
            sum += arr[k] - arr[k-i];
            max = Math.max(sum, max);
        }
        return max;
    }
}