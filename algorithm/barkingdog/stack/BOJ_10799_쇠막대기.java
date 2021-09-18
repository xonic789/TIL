package algorithm.barkingdog.stack;

import java.io.*;
import java.util.Stack;

public class BOJ_10799_쇠막대기 {

    public int solution(String s){
        int answer = 0;
        int n = s.length();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < n; i++){
            char ch = s.charAt(i);
            if (ch == '('){
                stack.push(ch);
            }else {
                stack.pop();
                if (s.charAt(i - 1) == ')'){
                    answer++;
                }else answer += stack.size();
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        System.out.println(new BOJ_10799_쇠막대기().solution(line));
    }
}
