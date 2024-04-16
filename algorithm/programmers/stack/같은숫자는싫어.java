package algorithm.programmers.stack;

import java.util.Stack;

public class 같은숫자는싫어 {

    public Stack<Integer> solution(int []arr) {
        Stack<Integer> stack = new Stack<>();

        stack.push(arr[0]);

        for (int i = 0; i < arr.length; i++){
            if (stack.peek() != arr[i]){
                stack.push(arr[i]);
            }
        }

        String tmp = "";

        return stack;
    }
}
