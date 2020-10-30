/*LC1467: Probability of a Two Boxes Having The Same
Number of Distinct Balls.
https://leetcode.com/problems/probability-of-a-two-boxes-having-the-same-number-of-distinct-balls/
Given 2n balls of k distinct colors. You will be
given an integer array balls of size k where
balls[i] is the number of balls of color i.

All the balls will be shuffled uniformly at random,
then we will distribute the first n balls to the
first box and the remaining n balls to the other
box (Please read the explanation of the second
example carefully).

Please note that the two boxes are considered different.
For example, if we have two balls of colors a and b,
and two boxes [] and (), then the distribution [a] (b)
is considered different than the distribution [b] (a)
(Please read the explanation of the first example carefully).

We want to calculate the probability that the
two boxes have the same number of distinct balls.

Example 1:
Input: balls = [1,1]
Output: 1.00000
Explanation: Only 2 ways to divide the balls equally:
- A ball of color 1 to box 1 and a ball of color 2 to box 2
- A ball of color 2 to box 1 and a ball of color 1 to box 2
In both ways, the number of distinct colors in each box is equal. The probability is 2/2 = 1

Example 2:
Input: balls = [2,1,1]
Output: 0.66667
Explanation: We have the set of balls [1, 1, 2, 3]
This set of balls will be shuffled randomly and we may have one of the 12 distinct shuffles with equale probability (i.e. 1/12):
[1,1 / 2,3], [1,1 / 3,2], [1,2 / 1,3], [1,2 / 3,1], [1,3 / 1,2], [1,3 / 2,1], [2,1 / 1,3], [2,1 / 3,1], [2,3 / 1,1], [3,1 / 1,2], [3,1 / 2,1], [3,2 / 1,1]
After that we add the first two balls to the first box and the second two balls to the second box.
We can see that 8 of these 12 possible random distributions have the same number of distinct colors of balls in each box.
Probability is 8/12 = 0.66667

Example 3:
Input: balls = [1,2,1,2]
Output: 0.60000
Explanation: The set of balls is [1, 2, 2, 3, 4, 4]. It is hard to display all the 180 possible random shuffles of this set but it is easy to check that 108 of them will have the same number of distinct colors in each box.
Probability = 108 / 180 = 0.6

Example 4:
Input: balls = [3,2,1]
Output: 0.30000
Explanation: The set of balls is [1, 1, 1, 2, 2, 3]. It is hard to display all the 60 possible random shuffles of this set but it is easy to check that 18 of them will have the same number of distinct colors in each box.
Probability = 18 / 60 = 0.3

Example 5:
Input: balls = [6,6,6,6,6,6]
Output: 0.90327*/
class Sln {
    public double getProbability(int[] balls) {
        int sum = 0;
        for (int i = 0; i < balls.length; ++i) sum += balls[i];
        //Get all possible cases where we select same number of balls in both bins
        double all = allCases(balls, 0, 0, 0, 0, 0, sum);
        //Get all possible cases where we select same number of balls in both bins + we select same number of distinct balls
        double valid = casesWithEqualDistinctBalls(balls, 0, 0, 0, 0, 0, sum);

        return ((1.0) * valid / all);
    }

    // disF = distinct balls in first bin
    // disS = distinct balls in second bin
    // f = number of balls in first bin
    // s = number of balls in second bin
    public double allCases(int[] b, int pos, int f, int s, int disF, int disS, int sum) {
        if (pos == b.length) {
            // for all cases, we just need to check if both bins have same number of balls or not
            if (f == s) return fact(sum / 2) * fact(sum / 2); //numerator of our permutations
            return 0;
        }
        // we put all balls in second bin
        double answer = 1.0 * allCases(b, pos + 1, f, s + b[pos], disF, disS + 1, sum) / fact(b[pos]);

        // we put all balls in first bin
        answer += 1.0 * allCases(b, pos + 1, f + b[pos], s, disF + 1, disS, sum) / fact(b[pos]);
        for (int i = 1; i < b[pos]; ++i) {
            answer += 1.0 * (allCases(b, pos + 1, f + i, s + b[pos] - i, disF + 1, disS + 1, sum) / (fact(i) * fact(b[pos] - i))); // We put i ball in bin and b[pos] - i in another, now since all of them are of same color, we need to divide permutation by  (fact(i) * fact(b[pos]-i)), this acts as a denominator of our permutations
        }
        return answer;
    }
    // disF = distinct balls in first bin
    // disS = distinct balls in second bin
    // f = number of balls in first bin
    // s = number of balls in second bin
    public double casesWithEqualDistinctBalls(int[] b, int pos, int f, int s, int disF, int disS, int sum) {
        if (pos == b.length) {
            // we  need to check if both bins have same number of balls or not + number of distinct balls in each bin should be equal
            if (f == s && disF == disS) return fact(sum / 2) * fact(sum / 2); //numerator of our permutations
            return 0;
        }
        // we put all balls in second bin
        double answer = 1.0 * casesWithEqualDistinctBalls(b, pos + 1, f, s + b[pos], disF, disS + 1, sum) / fact(b[pos]);
        // we put all balls in first bin
        answer += 1.0 * casesWithEqualDistinctBalls(b, pos + 1, f + b[pos], s, disF + 1, disS, sum) / fact(b[pos]);
        for (int i = 1; i < b[pos]; ++i) {
            answer += 1.0 * (casesWithEqualDistinctBalls(b, pos + 1, f + i, s + b[pos] - i, disF + 1, disS + 1, sum) / (fact(i) * fact(b[pos] - i))); // We put i ball in bin and b[pos] - i in another, now since all of them are of same color, we need to divide permutation by  (fact(i) * fact(b[pos]-i)), this acts as a denominator of our permutations
        }
        return answer;
    }
    double fact(double n) {
        double res = 1;
        for (int i = 2; i <= n; i++)
            res = res * i;
        return res;
    }
}