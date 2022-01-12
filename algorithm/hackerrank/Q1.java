package algorithm.hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Q1 {


  // Complete the braces function below.
  static String[] braces(String[] values) {
    int N = values.length;
    String[] answer = new String[N];


    for (int i = 0; i < N; i++) {
      String value = values[i];
      Stack<Character> stack = new Stack<>();
      for (char ch : value.toCharArray()) {
        if (stack.isEmpty() && (ch == '}' || ch == ')' || ch == ']')) {
          answer[i] = "NO";
          break;
        }
        if (ch == '{' || ch == '[' || ch == '(') {
          stack.push(ch);
        } else {
          if (stack.isEmpty()) {
            answer[i] = "NO";
            break;
          }
          char peek = stack.peek();
          if (ch == ')') {
            if (peek == '(') {
              stack.pop();
            } else {
              stack.push(ch);
            }
          }
          if (ch == '}') {
            if (peek == '{') {
              stack.pop();
            } else {
              stack.push(ch);
            }
          }
          if (ch == ']') {
            if (peek == '[') {
              stack.pop();
            } else {
              stack.push(ch);
            }
          }
        }
      }
      if (stack.isEmpty() && answer[i] == null) answer[i] = "YES";
      else answer[i] = "NO";
    }

    return answer;
  }
  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    String[] braces = {"}][}}(}][))]"};
    for (String brace : braces(braces)) {
      System.out.println(brace);
    }
  }
}
