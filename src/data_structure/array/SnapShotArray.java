/***Implement a SnapshotArray that supports the following interface:
        SnapshotArray(int length) initializes an array-like data structure with the given length.  Initially, each element equals 0.
        void set(index, val) sets the element at the given index to be equal to val.
        int snap() takes a snapshot of the array and returns the snap_id: the total number of times we called snap() minus 1.
        int get(index, snap_id) returns the value at the given index, at the time we took the snapshot with the given snap_id
***/
class SnapshotArray {
    List<Integer>[] arr;
    int currentSnapId = 0;
    public SnapshotArray(int length) {
        arr = new List[length];
        for (int i = 0; i < length; i++) {
            arr[i] = new ArrayList<Integer>();
        }
    }
    public void set(int index, int val) {
        List<Integer> list = arr[index];
        while (list.size() <= currentSnapId) {
            list.add(null);
        }
        // System.out.println(index + " " + list.size() + " " + val + " " + currentSnapId);
        list.set(currentSnapId, val);
    }
    public int snap() {
        return currentSnapId++;
    }
    public int get(int index, int snapId) {
        List<Integer> list = arr[index];
        if (list.size() <= snapId) {
            snapId = list.size() - 1;
        }
        while (snapId >= 0 && list.get(snapId) == null) {
            snapId--;
        }
        if (snapId < 0) {
            return 0;
        }
        else {
            return list.get(snapId);
        }
    }
}