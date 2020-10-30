package leetcode;

import java.util.*;

/**
 * We are required to return the minimum number of invalid parentheses to remove, that is,
 * the shortest distance from s to a valid string. Shortest-path problem is natural to BFS :
 * <p>
 * node: all possible string by removing parenthesis
 * start node: s
 * end state: reach the level which contains a valid string
 * We establish set visited to avoid duplicate calculations.
 * For example, (() count as 2 candidates () and (( with set visited,
 * but one more candidate () without set visited.
 */
public class RemoveInvalidParenthesis {
    public static void main(String[] args) {
        RemoveInvalidParenthesis rip = new RemoveInvalidParenthesis();
        ArrayList<String> res;
        res = (ArrayList<String>) rip.removeInvalidParentheses("()())()");
        res.forEach(System.out::println);
    }
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();

        // sanity check
        if (s == null) return res;

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        // initialize
        queue.add(s);
        visited.add(s);

        boolean found = false;

        while (!queue.isEmpty()) {
            s = queue.poll();

            if (isValid(s)) {
                // found an answer, add to the result
                res.add(s);
                found = true;
            }

            if (found) continue;

            // generate all possible states
            for (int i = 0; i < s.length(); i++) {
                // we only try to remove left or right paren
                if (s.charAt(i) != '(' && s.charAt(i) != ')') continue;

                String t = s.substring(0, i) + s.substring(i + 1);

                if (!visited.contains(t)) {
                    // for each state, if it's not visited, add it to the queue
                    queue.add(t);
                    visited.add(t);
                }
            }
        }
        return res;
    }
    private boolean isValid(String s) {
        int score = 0; // Indicates whether left parenthesis and right parenthesis are balanced.
        for (char ch : s.toCharArray()) {
            if (ch == '(')
                score++;
            else if (ch == ')')
                score--;
            if (score < 0)
                return false;
        }
        return score == 0;
    }
}



class Soln{
    private Set<String> validExpressions = new HashSet<String>();
    private void recurse(
            String s,
            int idx,
            int leftCount,
            int rightCount,
            int leftRem,
            int rightRem,
            StringBuilder expression) {
        // If we reached the end of the string, just check if the resulting expression is
        // valid or not and also if we have removed the total number of left and right
        // parentheses that we should have removed.
        if (idx == s.length()) {
            if (leftRem == 0 && rightRem == 0) {
                validExpressions.add(expression.toString());
            }
        }
        else {
            char ch = s.charAt(idx);
            int len = expression.length();

            // The discard case. Note that here we have our pruning condition.
            // We don't recurse if the remaining count for that parenthesis is == 0.
            if ((character == '(' && leftRem > 0) || (character == ')' && rightRem > 0)) {
                this.recurse(
                        s,
                        index + 1,
                        leftCount,
                        rightCount,
                        leftRem - (character == '(' ? 1 : 0),
                        rightRem - (character == ')' ? 1 : 0),
                        expression);
            }
            expression.append(character);

            // Simply recurse one step further if the current character is not a parenthesis.
            if (character != '(' && character != ')') {
                this.recurse(s, index + 1, leftCount, rightCount, leftRem, rightRem, expression);
            }
            else if (character == '(') {
                // Consider an opening bracket.
                this.recurse(s, index + 1, leftCount + 1, rightCount, leftRem, rightRem, expression);
            }
            else if (rightCount < leftCount) {
                // Consider a closing bracket.
                this.recurse(s, index + 1, leftCount, rightCount + 1, leftRem, rightRem, expression);
            }
            // Delete for backtracking.
            expression.deleteCharAt(length);
        }
    }
    public List<String> removeInvalidParentheses(String s) {
        int left = 0, right = 0;
        // First, we find out the number of misplaced left and right parentheses.
        for (int i = 0; i < s.length(); i++) {
            // Simply record the left one.
            if (s.charAt(i) == '(') {
                left++;
            }
            else if (s.charAt(i) == ')') {
                // If we don't have a matching left, then this is a misplaced right, record it.
                right = left == 0 ? right + 1 : right;

                // Decrement count of left parentheses because we have found a right
                // which CAN be a matching one for a left.
                left = left > 0 ? left - 1 : left;
            }
        }
        this.recurse(s, 0, 0, 0, left, right, new StringBuilder());
        return validExpressions.toList();
    }
}