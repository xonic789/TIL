package algorithm.inflearn.datastructure;

import java.util.Scanner;
import java.util.Stack;

public class 괄호문자제거 {

    public String solution(String str){
        Stack<Character> stack = new Stack<>();
        for (char ch : str.toCharArray()){
            if (ch == '('){
                stack.push(ch);
            }else if (ch >= 'A' && ch <= 'Z' || ch >= 'a' && ch <= 'z'){
                stack.push(ch);
            }else {
                while (stack.pop() != '('){
                }
            }
        }
        StringBuffer sb = new StringBuffer();
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        System.out.println(new 괄호문자제거().solution(str));
    }
}
