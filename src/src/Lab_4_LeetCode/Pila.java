package Lab_4_LeetCode;

public class Pila {

    // Problema 1. N°1614. Maximum Nesting Depth of the Parentheses

    public class Solution {

        public int maxDepth(String s) {

            int A = 0;
            int B = 0;

            for (int i = 0; i < s.length(); ++i) {
                if (s.charAt(i) == '(')
                    A = Math.max(A, ++B);
                if (s.charAt(i) == ')')
                    B--;
            }
            return A;
        }
    }
    //problema 2. N°1700. Number of Students Unable to Eat Lunch

    public class Solution2 {

        public int countStudents(int[] students, int[] sandwiches) {

            int zeros = 0;
            int unos = 0;

            for (int student : students) {
                if (student == 0) {
                    zeros++;
                } else {
                    unos++;
                }
            }
            for (int sandwich : sandwiches) {
                if (sandwich == 0) {
                    if (zeros == 0) {
                        return unos;
                    }
                    zeros--;
                } else {
                    if (unos == 0) {
                        return zeros;
                    }
                    unos--;
                }
            }
            return 0;
        }
    }
}
