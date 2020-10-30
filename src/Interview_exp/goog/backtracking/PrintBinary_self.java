package backtracking;
/*Given a positive integer number N. The task is
* to generate all the binary strings of N bits.
* These binary strings should be in ascending order.
Examples:
Input: 2
Output:
0 0
0 1
1 0
1 1

Input: 3
Output:
0 0 0
0 0 1
0 1 0
0 1 1
1 0 0
1 0 1
1 1 0
1 1 1*/
public class PrintBinary {
    public static void main(String[] args) {
        PrintBinary printBinary = new PrintBinary();
        printBinary.printBinary(3, new StringBuilder(""));
    }
    public void printBinary(int digits, StringBuffer sb){
        if(digits==0){
            return sb.toString();
        }
        else{
            printBinary(digits-1, sb.append(0));
            sb.deleteCharAt(sb.length()-1);
            printBinary(digits-1, sb.append(1));
            sb.deleteCharAt(sb.length()-1);
        }
    }
}