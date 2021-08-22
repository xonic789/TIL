package algorithm.barkingdog.stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_6198_옥상꾸미기 {

    public long solution(int[] arr, int n){
        long answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++){
            while (!stack.isEmpty() && stack.peek() <= arr[i]){
                stack.pop();
            }
            stack.push(arr[i]);
            // 현재 i 에서 볼 수 있는 경비원 파악
            // 스택의 size - 1을 할 것임.
            answer += stack.size() - 1;
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(new BOJ_6198_옥상꾸미기().solution(arr, n));
    }
}
