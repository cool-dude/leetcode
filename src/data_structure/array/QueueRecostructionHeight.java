/*LC406. Queue Reconstruction by Height
https://leetcode.com/problems/queue-reconstruction-by-height/
Suppose you have a random list of people standing
in a queue. Each person is described by a pair of
integers (h, k), where h is the height of the person
and k is the number of people in front of this person
who have a height greater than or equal to h.
Write an algorithm to reconstruct the queue.

Input:
[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

Output:
[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]*/
class Sln1 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(p,(p1,p2)->{
            if(p1[0]!=p2[0]){
                return p2[0]-p1[0];
            }
            return p1[1]-p2[1];
        });
        LinkedList<int[]> ansList=new LinkedList<>();
        for(int[] pp:p){
            ansList.add(pp[1],pp);
        }
        int[][] ans=new int[ansList.size()][2];
        for(int i=0;i<ansList.size();i++)
            ans[i]=ansList.get(i);
        return ans;
    }
    //T:O(n^2).
}

class Sln2{
    class BinaryIndexedTree {
        int[] ft;
        BinaryIndexedTree(int n) {
            ft = new int[n];
        }
        int rangeSum(int r) {
            int sum = 0;
            for(; r > 0; r -= (r & (-r))) {
                sum += ft[r];
            }
            return sum;
        }
        void update(int k, int v) {
            for(; k < ft.length; k += (k & (-k))) {
                ft[k] += v;
            }
        }
    }
    public int[][] reconstructQueue(int[][] people) {
        int n = people.length;
        Arrays.sort(people, (p1, p2) -> {
            if(p1[0] != p2[0]) {
                return p1[0] - p2[0];
            }
            return p2[1] - p1[1];
        });
        BinaryIndexedTree bit = new BinaryIndexedTree(n + 1);
        int[][] ans = new int[n][];
        for(int i = 0; i < n; i++) {
            int l = 1, r = n;
            while(l < r) {
                int mid = l + (r - l) / 2;
                int filled = bit.rangeSum(mid);
                if(mid - filled == people[i][1] + 1 && ans[mid - 1] == null) {
                    break;
                }
                else if(mid - filled < people[i][1] + 1) {
                    l = mid + 1;
                }
                else {
                    r = mid - 1;
                }
            }
            ans[l + (r - l) / 2 - 1] = people[i];
            bit.update(l + (r - l) / 2, 1);
        }
        return ans;
    }
    //T:O(nlgn+n*(lgn)^2).
    //S:O(n).
}