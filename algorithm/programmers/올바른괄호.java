package algorithm.programmers;

import java.util.Stack;

public class 올바른괄호 {
    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            } else {
                if (stack.isEmpty()) return false;
                if (stack.peek() == '(') {
                    stack.pop();
                }
            }
        }
        if (!stack.isEmpty()) return false;
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new 올바른괄호().solution("()()"));
    }
}
