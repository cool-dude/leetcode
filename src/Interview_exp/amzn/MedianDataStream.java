/*LC295: Find Median from Data Stream
* https://leetcode.com/problems/find-median-from-data-stream/
Median is the middle value in an ordered integer
* list. If the size of the list is even, there
* is no middle value. So the median is the
* mean of the two middle value.
For example,
[2,3,4], the median is 3
[2,3], the median is (2 + 3) / 2 = 2.5
Design a data structure that supports the following 2:

void addNum(int num) - Add a integer number from the data stream to the data structure.
double findMedian() - Return the median of all elements so far.

Example:
addNum(1)
addNum(2)
findMedian() -> 1.5
addNum(3)
findMedian() -> 2

Follow up:
If all integer numbers from the stream are
between 0 and 100, how would you optimize it?
If 99% of all integer numbers from the stream
* are between 0 and 100, how would you optimize it?*/
class StreamingMedian {
    PriorityQueue<Integer> left=new PriorityQueue<>((a,b)->a-b);
    PriorityQueue<Integer> right=new PriorityQueue<>((a,b)->b-a);
    public void acceptValue(int n) {
        if (left.size() == 0) {
            left.offer(n);
            return;
        } else (left.size() > right.size()) {
            if (n < right.peek()) {  // 10, 20, 30 | 40, 50, add 7
                left.offer(n);  // 7, 10, 20, 30 | 40, 50
                right.offer(left.poll());  // 7, 10, 20 | 30, 40, 50
            } else { // 10, 20, 30 | 40, 50, add 45
                right.offer(n)  // 10, 20, 30 |  40,45, 50
            }
            else{ // left.size() == right.size()
                if (n < right.peek())
                    left.offer(n); // 10, 20, | 35, 40
                else {
                    right.offer(n);  // 10, 20, | 30, 35, 40
                    left.offer(right.poll()); // 10, 20, 30, | 35, 40
                }
            }
        }
    }

    public int getMedian() {
        if(left.size()==0) return 0;
        Else return left.peek();
    }
}
    Streaming Median

    We receive a stream of integers in any order, and we have to maintain the median at any time.
        Median is the middle point of a sorted collection.
        There are no duplicates, and there are a large number of integers that may arrive.

        1  1
        2   1,2   3,4
        3   1,2,3,

        median
        1,2
        ^

        left  | right
        max | min
        2,4   | ,6,8
        ^

        10
        20
        5

        left           right
        5,10              20
        where does 5 go?


        25

        5,10              15,20,
        ^               ^

        5,7,10             15, 20
        ^              ^
        (left = max, right= min)

        left.peek < right..peek
        left.size == right.size // even
        or left.size == right.size + 1  // odd


        Are you there James?


