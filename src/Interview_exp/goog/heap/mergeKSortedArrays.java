class ArrContainer implements Comparable<ArrContainer> {
    int[] arr;
    int idx;
    public ArrContainer(int[] a, int i) {
        this.arr = a;
        this.idx = i;
    }
    @Override
    public int compareTo(ArrayContainer o) {
        return this.arr[this.idx] - o.arr[o.idx];
    }
}
class KSortedArr{
    public static int[] mergeKSortedArrs(int[][] arr){
        PriorityQueue<ArrayContainer> pq=
                new PriorityQueue<ArrayContainer>();
        int total=0;
        for(int i=0;i<arr.length;i++){
            pq.add(new ArrayContainer(arr[i],0));
            total += arr[i].length;
        }
        int m = 0;
        int result[] = new int[total];
        while(!pq.isEmpty(){
            ArrayContainer ac=pq.poll();
            result[m++] = ac.arr[ac.idx];

            if(ac.idx < ac.arr.length-1) {
                pq.add(new ArrayContainer(ac.a, ac.idx + 1));
            }
        }
    }
}
arr={
        {1,4,7},
        {2,5,8,11},
        {3,6,9,12,15}
        }
          1        2          2         3         4
        /  \=>      \  =>    /\   =>   / \  =>   / \
       2   3         3      4   3     4   5     5  6
         res={1,2,3,}