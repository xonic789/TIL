package algorithm.inflearn.datastructure;

import java.util.Scanner;
import java.util.Stack;

public class 후위식연산 {

    public int solution(String str){
        Stack<Integer> stack = new Stack<>();
        for (char ch : str.toCharArray()){
            if (ch == '*'){
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a * b);
            }else if (ch == '+'){
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a + b);
            }else if (ch == '-'){
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a - b);
            }else if (ch == '/'){
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a / b);
            }else {
                stack.push(ch - '0');
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(new 후위식연산().solution(str));
    }
}
