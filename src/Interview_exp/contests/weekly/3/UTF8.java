/*LC393: UTF-8 Validation
https://leetcode.com/problems/utf-8-validation/
A character in UTF8 can be from
1 to 4 bytes long, subjected to the following rules:

For 1-byte character, the first bit is a 0, followed by its unicode code.
For n-bytes character, the first n-bits are
all one's, the n+1 bit is 0, followed by n-1
bytes with most significant 2 bits being 10.
This is how the UTF-8 encoding would work:

   Char. number range  |        UTF-8 octet sequence
      (hexadecimal)    |              (binary)
   --------------------+---------------------------------------------
   0000 0000-0000 007F | 0xxxxxxx
   0000 0080-0000 07FF | 110xxxxx 10xxxxxx
   0000 0800-0000 FFFF | 1110xxxx 10xxxxxx 10xxxxxx
   0001 0000-0010 FFFF | 11110xxx 10xxxxxx 10xxxxxx 10xxxxxx
Given an array of integers representing the data,
return whether it is a valid utf-8 encoding.

Example 1:
data = [197, 130, 1], which represents the octet
sequence: 11000101 10000010 00000001.
Return true.
It is a valid utf-8 encoding for a 2-bytes
character followed by a 1-byte character.

Example 2:
data = [235, 140, 4], which represented the octet
sequence: 11101011 10001100 00000100.

Return false.
The first 3 bits are all one's and the 4th bit is 0 means it is a 3-bytes character.
The next byte is a continuation byte which starts with 10 and that's correct.
But the second continuation byte does not start with 10, so it is invalid.*/
class Sln {
   /*  Thought-way:
     * As long as every byte in the array is of right type, it is a valid UTF-8 encoding.
     *
     * Method:
     * Start from index 0, determine each byte's type and check its validity.
     *
     * There are five kinds of valid byte type: 0**, 10**, 110**,1110** and 11110**
     * Give them type numbers, 0, 1, 2, 3, 4 which are the index of the first 0 from left.
     * So, the index of the first 0 determines the byte type.
     *
     * if a byte belongs to one of them:
        1 : if it is type 0, continue
        2 : if it is type 2 or 3 or 4, check whether the following 1, 2, and 3 byte(s) are of type 1 or not
                if not, return false;
     * else if a byte is type 1 or not of valid type, return false
     * Analysis :
     * The faster you can determine the type, the quicker you can get.
     * Time O(n), space O(1)
     * real performance: 7ms*/
    // Hard code "masks" array to find the index of the first appearance of 0 in the lower 8 bits of each integer.
    private int[] masks = {128, 64, 32, 16, 8};
    public boolean validUtf8(int[] data) {
        int len = data.length;
        for (int i = 0; i < len; i ++) {
            int curr = data[i];
            int type = getType(curr);
            if (type == 0) {
                continue;
            }
            else if (type > 1 && i + type <= len) {
                while (type-- > 1) {
                    if (getType(data[++i]) != 1) {
                        return false;
                    }
                }
            }
            else {
                return false;
            }
        }
        return true;
    }
    public int getType(int num) {
        for (int i = 0; i < 5; i ++) {
            if ((masks[i] & num) == 0) {
                return i;
            }
        }
        return -1;
    }
}

class Sln2{
    public boolean validUtf8(int[] data) {
        if(data==null || data.length==0) return false;
        boolean isValid = true;
        for(int i=0;i<data.length;i++) {
            if(data[i]>255) return false; // 1 after 8th digit, 100000000
            int numberOfBytes = 0;
            if((data[i] & 128) == 0) { // 0xxxxxxx, 1 byte, 128(10000000)
                numberOfBytes = 1;
            } else if((data[i] & 224) == 192) { // 110xxxxx, 2 bytes, 224(11100000), 192(11000000)
                numberOfBytes = 2;
            } else if((data[i] & 240) == 224) { // 1110xxxx, 3 bytes, 240(11110000), 224(11100000)
                numberOfBytes = 3;
            } else if((data[i] & 248) == 240) { // 11110xxx, 4 bytes, 248(11111000), 240(11110000)
                numberOfBytes = 4;
            } else {
                return false;
            }
            for(int j=1;j<numberOfBytes;j++) { // check that the next n bytes start with 10xxxxxx
                if(i+j>=data.length) return false;
                if((data[i+j] & 192) != 128) return false; // 192(11000000), 128(10000000)
            }
            i=i+numberOfBytes-1;
        }
        return isValid;
    }
}