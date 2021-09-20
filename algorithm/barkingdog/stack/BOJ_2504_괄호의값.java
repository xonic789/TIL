package algorithm.barkingdog.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BOJ_2504_괄호의값 {
    public int solution(String input){
        int answer = 0;
        int n = input.length();
        Stack<String> stack = new Stack<>();
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < n; i++){
            char ch = input.charAt(i);
            // 열 때 스택에 적재
            if (ch == '(' || ch == '['){
                stack.push(String.valueOf(ch));
            }else if (ch == ')'){
                // 닫는 괄호인데 비어있다면 잘못된 괄호
                if (stack.isEmpty()) return 0;
                if (input.charAt(i - 1) == '('){
                    stack.pop();
                    stack.push("2");
                }else {
                    int tmp = 0;
                    String peek;
                    while (!stack.isEmpty() && !(peek = stack.peek()).equals("(")){
                        if (peek.equals("[")) return 0;
                        tmp += Integer.parseInt(stack.pop());
                    }
                    stack.pop();
                    stack.push(String.valueOf(tmp * 2));
                }
            }else {
                if (stack.isEmpty()) return 0;
                if (input.charAt(i - 1) == '['){
                    stack.pop();
                    stack.push("3");
                }else {
                    int tmp = 0;
                    String peek;
                    while (!stack.isEmpty() && !(peek = stack.peek()).equals("[")){
                        if (peek.equals("(")) return 0;
                        tmp += Integer.parseInt(stack.pop());
                    }
                    stack.pop();
                    stack.push(String.valueOf(tmp * 3));
                }
            }
        }
        while (!stack.isEmpty()){
            String str = stack.peek();
            if (str.equals("[") || str.equals("]") || str.equals("(") || str.equals(")")) return 0;
            answer += Integer.parseInt(stack.pop());
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        System.out.println(new BOJ_2504_괄호의값().solution(input));
    }
}
