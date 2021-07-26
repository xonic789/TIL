package algorithm.programmers.stack;

import java.util.Stack;

public class 짝지어제거하기 {
    public int solution(String s){
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        int n = s.length();
        stack.push(s.charAt(0));

        for (int i = 1; i < n; i++){
            char tmp = s.charAt(i);
            if (stack.size() == 0){
                stack.push(tmp);
            }else {
                if (stack.peek() == tmp){
                    stack.pop();
                }else {
                    stack.push(tmp);
                }
            }
        }

        if (stack.size() == 0){
            return 1;
        }
        return answer;
    }
}
