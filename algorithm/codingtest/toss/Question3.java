package toss;
import java.util.Stack;

public class Question3 {
    public boolean solution(String amountText) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        for (char ch : amountText.toCharArray()){
            stack.push(ch);
        }

        for (int i = 0; i < stack.size(); i++){
            char ch = stack.pop();
            if (i % 3 == 0) {
                if (!Character.isDefined(ch)|| ch != ',') {
                    answer = false;
                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        new Question3().solution("10000");

    }
}
