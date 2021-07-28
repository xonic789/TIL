package algorithm.inflearn.datastructure;

import java.util.Scanner;
import java.util.Stack;

public class 올바른괄호 {

    public String solution(String str){
        String answer = "NO";
        Stack<Character> stack = new Stack<>();

        for (char bracket : str.toCharArray()){
            if (bracket == '('){
                stack.push(bracket);
            }else {
                if (stack.isEmpty()) return "NO";
                if (stack.peek() == '('){
                    stack.pop();
                }else {
                    return "NO";
                }
            }
        }

        if (stack.isEmpty()){
            answer = "YES";
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        System.out.println(new 올바른괄호().solution(str));
    }
}
