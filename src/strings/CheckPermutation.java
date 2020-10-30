package strings;
import java.util.Arrays;
/*Assume case sensitive*/
public class CheckPermutation {
    public static void main(String[] args) {
        String a = "dog";
        String b = "go9d";
        System.out.println(checkPermutation(a, b));
        System.out.println(checkPermutationCount(a, b));
    }
    private static boolean checkPermutationCount(String a, String b) {
        if (a.length() != b.length())
            return false
        //count and put into an array
        int[] counter = new int[128]; //ASCII character
        for (int i = 0; i < a.length(); i++)
            counter[a.charAt(i)]++;
        // start reducing the counter. if any value goes negtive return false
        for (int i = 0; i < b.length(); i++) {
            counter[b.charAt(i)]--;
            if (counter[b.charAt(i)] < 0)
                return false;
        }
        return true;
    }
}