package leetcode.contests.contest_142;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;


class Soln{
    public boolean carPooling(int[][] trips, int capacity){
        PriorityQueue<Integer> end = new PriorityQueue<>(Comparator.comparingInt(o -> trips[o][2]));
        Arrays.sort(trips, Comparator.comparingInt(o -> o[1]));
        end.add(0);
        int curr = trips[0][0];
        for (int i = 1; i < trips.length; i++) {
            while (!end.isEmpty() && trips[i][1] >= trips[end.peek()][2]) {
                curr -= trips[end.poll()][0];
            }
            if (curr + trips[i][0] > capacity) {
                return false;
            }
            curr += trips[i][0];
            end.add(i);
        }
        return true;
    }
}



class Soln{
    public boolean carPooling(int[][] trips, int capacity){
        PriorityQueue<Integer> end=new PriorityQueue<>(Comparator.comparingInt(o-> trips[o][2]));
        Arrays.sort(trips, Comparator.comparingInt(o-> o[1]));
        end.add(0);
        int cur = trips[0][0];
        for(int i=1;i<trips.length;i++){
            while (!end.isEmpty() && trips[i][1] >=)
        }
    }
}