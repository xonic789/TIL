package algorithm.barkingdog.stack;

import java.io.*;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
Half Moon tonight (At least it is better than no Moon at all].
.
 */
public class BOJ_4949_균형잡힌세상 {

    public String solution(String line){
        Stack<Character> stack = new Stack<>();
        for (char ch : line.toCharArray()){
            if (Character.isAlphabetic(ch) || ch == ' ' || ch == '.') continue;
            if (ch == '[' || ch == '('){
                stack.push(ch);
            }else {
                if (stack.isEmpty()) return "no";
                if (ch == ']'){
                    if (stack.peek() == '[') stack.pop();
                    else return "no";
                }else{
                    if (stack.peek() == '(') stack.pop();
                    else return "no";
                }
            }
        }

        if (!stack.isEmpty()) return "no";
        return "yes";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String line;
        BOJ_4949_균형잡힌세상 main = new BOJ_4949_균형잡힌세상();
        while (!(line = br.readLine()).equals(".")){
            bw.write(main.solution(line) + "\n");
        }
        bw.flush();
    }
}
