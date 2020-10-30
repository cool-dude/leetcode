/*LC190:Reverse Bits
Reverse bits of a given 32 bits
* unsigned integer.
Ex 1:
Input: 00000010100101000001111010011100
Output: 00111001011110000010100101000000
Explanation: The input binary string
* 00000010100101000001111010011100
* represents the unsigned integer 43261596,
* so return 964176192 which its binary
* representation is 00111001011110000010100101000000.

* Ex 2:
Input: 11111111111111111111111111111101
Output: 10111111111111111111111111111111
Explanation: The input binary string
* 11111111111111111111111111111101 represents
* the unsigned integer 4294967293, so return
* 3221225471 which its binary representation is
* 10111111111111111111111111111111.*/
public class Sln {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res=0;
        for(int i=0;i<32;i++){
            int check=(n>>i)&1; // get bit at position i
            res=res|(check<<(32-1-i)); // turn on bit
        }
        return res;
    }
}