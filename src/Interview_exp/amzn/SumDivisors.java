// Function to calculate sum of all proper
// divisors num --> given natural number
class Sln1 {
    //simple
    static int divSum(int num) {
        int result = 0;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                if (i == (num / i))
                    result += i;
                else
                    result += (i + num / i);
            }
        }
        return (result + 1);
    }
    //optimized
    static int sumofiFactors(int n) {
        // Traversing through all prime factors.
        int res = 1;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            int  curr_sum = 1;
            int curr_term = 1;
            while (n % i == 0) {
                n /= i;
                curr_term *= i;
                curr_sum += curr_term;
            }
            res *= curr_sum;
        }
        return res;
    }
}