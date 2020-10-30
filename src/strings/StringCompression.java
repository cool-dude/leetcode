package String;
/*Cracking codig interview*/
public class StringCompression {
    public static void main(String[] args) {
        String in = "aabcccccaaa";
        System.out.println(compressString(in));
        System.out.println(compressLeetCode(new char[]{'a','a','b','b','c','c','c'}));
    }
    private static int compress(char[] in) {
        StringBuilder sb = new StringBuilder();
        int counter = 0;
        for (int i = 0; i < in.length; i++) {
            counter++;
            if (i + 1 >= in.length || in[i] != in[i + 1]) {
                sb.append(in[i]);
                if(counter>1) {
                    sb.append(counter);
                }
                counter = 0;
            }
        }
        return sb.toString().length();
    }
}