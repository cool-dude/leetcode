package bybybyte;
/**given two integers, check are they differ by only single bit or not
 * <p>
 * exmaple:
 * (0,1)-> true
 * (1,2)-> false
 * 00
 * 01
 * <p>
 * <p>
 * 000 0001 010 011  100 101 110 111
 * <p>
 * 110
 * 111
 * <p>
 * 10010
 * 10001*/
public class IntegerDifferenceInSingleBit {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        IntegerDifferenceInSingleBit test = new IntegerDifferenceInSingleBit();
        System.out.println(test.isGray(a, b));
        System.out.println(test.isGrayOptimize(a,b));
    }
    private boolean isGrayOptimize(int a, int b) {
        int result = a ^ b;
        return (result & result - 1) == 0;
    }
}