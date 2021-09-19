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
        Stack<Character> stack = new Stack<>();
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < n; i++){
            char ch = input.charAt(i);
            // 열 때 스택에 적재
            if (ch == '(' || ch == '['){
                stack.push(ch);
            }else {
                // 닫는 괄호인데 비어있다면 잘못된 괄호
                if (stack.isEmpty()) return 0;
                // 끝 참조
                char peek = stack.peek();

            }
        }


        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        System.out.println(new BOJ_2504_괄호의값().solution(input));
    }
}
