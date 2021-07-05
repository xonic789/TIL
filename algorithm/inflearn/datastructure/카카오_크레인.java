package algorithm.inflearn.datastructure;

import java.util.Scanner;
import java.util.Stack;

public class 카카오_크레인 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                board[i][j] = sc.nextInt();
            }
        }

        int m = sc.nextInt();
        int[] moves = new int[m];
        for (int i = 0; i < m; i++){
            moves[i] = sc.nextInt();
        }

        System.out.println(new 카카오_크레인().solution(n,board,m,moves));
    }

    private int solution(int n, int[][] board, int m, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();


        for (int i = 0; i < m; i++){
            int crane = moves[i] - 1;
            for (int j = 0; j < n; j++){
                int doll = board[j][crane];
                if (doll == 0){
                    continue;
                }
                if (!stack.isEmpty()){
                    if (stack.peek() == doll){
                        board[j][crane] = 0;
                        stack.pop();
                        answer += 2;
                        break;
                    }
                }
                board[j][crane] = 0;
                stack.push(doll);
                break;
            }
        }
        return answer;
    }
}
