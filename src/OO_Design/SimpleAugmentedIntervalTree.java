/*Interval tree(for maintaining*/
class IntervalNode implements Comparable {
    private long     start;
    private long     end;
    private long     max;
    private Interval left;
    private Interval right;
    public Interval(long start, long end) {
        this.start = start;
        this.end = end;
        this.max = end;
    }
    @Override
    public String toString() {
        return "[" + this.getStart() + ", " + this.getEnd() + ", "
                + this.getMax() + "]";
    }
    @Override
    public int compareTo(Interval i) {
        if (this.start < i.start) {
            return -1;
        }
        else if (this.start == i.start) {
            return this.end <= i.end ? -1 : 1;
        }
        else {
            return 1;
        }
    }
}
class AugmentedIntervalTree {
    private IntervalNode root;
    public static IntervalNode insertNode(IntervalNode newNode) {
        if (root == null) {
            root = newNode;
            return root;
        }
        // Update of the maximum
        // extreme of the subtree
        // during insertion
        if (newNode.getEnd() > root.getMax()) {
            root.setMax(newNode.getEnd());
        }
        if (root.compareTo(newNode) <= 0) {
            if (root.getRight() == null) {
                root.setRight(newNode);
            }
            else {
                insertNode(root.getRight(), newNode);
            }
        }
        else {
            if (root.getLeft() == null) {
                root.setLeft(newNode);
            }
            else {
                insertNode(root.getLeft(), newNode);
            }
        }
        return root;
    }
    // In-Order Tree Traversal
    public static void printTree(Interval tmp) {
        if (tmp == null) {
            return;
        }
        if (tmp.getLeft() != null) {
            printTree(tmp.getLeft());
        }
        System.out.print(tmp);
        if (tmp.getRight() != null) {
            printTree(tmp.getRight());
        }
    }
}