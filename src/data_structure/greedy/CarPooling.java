/*LC1094: Car Pooling
You are driving a vehicle that has capacity empty seats
* initially available for passengers.  The vehicle only
* drives east (ie. it cannot turn around and drive west.)

Given a list of trips, trip[i] = [num_passengers, start_location, end_location]
* contains information about the i-th trip: the number of
* passengers that must be picked up, and the locations to
* pick them up and drop them off.  The locations are given
* as the number of kilometers due east from your vehicle's
* initial location.

Return true if and only if it is possible to pick up and
* drop off all passengers for all the given trips.

Example 1:
Input: trips = [[2,1,5],[3,3,7]], capacity = 4
Output: false
*
Example 2:
Input: trips = [[2,1,5],[3,3,7]], capacity = 5
Output: true
*
Example 3:
Input: trips = [[2,1,5],[3,5,7]], capacity = 3
Output: true
*
Example 4:
Input: trips = [[3,2,7],[3,7,9],[8,3,9]], capacity = 11
Output: true*/
class Sln{
    public boolean carPooling(int[][] trips, int capacity){
        PriorityQueue<Integer> end = new PriorityQueue<>(Comparator.comparingInt(o-> trips[o][2]));
        Arrays.sort(trips, Comparator.comparingInt(o-> o[1]));
        end.add(0);
        int cur = trips[0][0];
        for(int i=1;i<trips.length;i++){
            while (!end.isEmpty() && trips[i][1] >= trips[end.peek()][2]){
                cur -= trips[end.poll()][0];
            }
            if(cur + trips[i][0] > capacity) {
                return false;
            }
            cur += trips[i][0];
            end.add(i);
        }
        return true;
    }
}

class Sln{
    public boolean carPooling(int[][] trips, int capa){
        PriorityQueue<Integer> end =
                new PriorityQueue<>(Comparator.comparingInt(o-> trips[o][2]));
        Arrays.sort(trips, Comparator.comparingInt(o->o[1]));
        end.add(0);
        int cur=trips[0][0];
        for(int i=1;i<trips.length;i++){
            while (!end.isEmpty() && trips[i][1]>=trips[end.peek()][2]){
                cur-=trips[end.poll()][0];
            }
            if(cur+trips[i][0]>capa){
                return false;
            }
            cur += trips[i][0];
            end.add(i);
        }
        return true;
    }
}