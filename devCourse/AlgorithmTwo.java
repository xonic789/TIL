package devCourse;

import java.util.Stack;
/**
 * 프로그래머스 데브코스 백엔드 과정 2번
 */
public class AlgorithmTwo {

    public Stack<Integer> solution(int[] deposit) {
        int[] answer = {};
        Stack<Integer> stack = new Stack<>();
        int n = deposit.length;

        for (int i = 0; i < n; i++){
            int content = deposit[i];
            // 입금일 경우 스택에 쌓는다.
            if (content > 0){
                stack.push(content);
            }else {
                // 출금일 경우 스택을 제거하며 content가 0 이 될 때까지.
                while (content < 0){
                    content += stack.pop();
                }
                // 0 일 경우 입금해야할 필요가 없기 때문에 .
                // 0이 아닐 경우에만.
                if (content != 0){
                    stack.push(content);
                }

            }
        }

        return stack;
    }

    public static void main(String[] args) {
        int[] deposit = {500, 1000, -300, 200, -400, 100, -100};

        System.out.println(new AlgorithmTwo().solution(deposit));
    }
}
