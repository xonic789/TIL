package algorithm.inflearn.datastructure;

import java.util.Scanner;
import java.util.Stack;

public class 쇠막대기 {

    public int solution(String str){
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        int n = str.length();
        for (int i = 0; i < n; i++){
            char ch = str.charAt(i);
            if (ch == '('){
                stack.push(ch);
            }else {
                stack.pop();
                if (str.charAt(i-1) == ')'){
                    answer++;
                }else {
                    answer += stack.size();
                }

            }
        }
        return answer;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        System.out.println(new 쇠막대기().solution(str));

    }
}
