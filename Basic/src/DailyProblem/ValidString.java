package DailyProblem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidString {

    public static void main(String[] args) {
        System.out.println("Using Brute force, validating the string is valid or not : " + isValid("([{})"));
    }
    static Map<Character, Integer> parenthesisMap= Map.of('(',1,')',-1,'{',2,'}',-2,'[',3,']',-3);


    public static boolean naiveApproach(String s) {
        if (s == null)
            return false;
        if (s.isEmpty())
            return false;
        if (s.length() == 1)
            return false;

        char[] val = s.toCharArray();
        int[] test = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (parenthesisMap.containsKey(val[i]))
                test[i] = parenthesisMap.get(val[i]);
        }
        int sum = 0;
        int low = 0;
        int high = s.length() - 1;
        for (int i = 0; i < s.length(); i++) {
            sum += test[i];
            if (test[low] + test[high] == 0) {
                low++;
                high--;
            } else {
                return false;
            }
        }
        return sum == 0;
    }

    public static boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()) {

            if(c == '(' || c == '{' || c == '[') {

                stack.push(c);

            } else {

                if(stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();

                if(c == ')' && top != '(') {
                    return false;
                }

                if(c == '}' && top != '{') {
                    return false;
                }

                if(c == ']' && top != '[') {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
