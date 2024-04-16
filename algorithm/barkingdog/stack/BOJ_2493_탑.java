package algorithm.barkingdog.stack;

import java.io.*;
import java.util.*;

public class BOJ_2493_탑 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++){
            int e = Integer.parseInt(st.nextToken());
            arr[i] = e;
        }
        System.out.println(new BOJ_2493_탑().solution(arr, n));
    }

    public String solution(int[] arr, int n){
        int[] tmp = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--){
            // 스택에는 arr index가 들어감.
            if (stack.isEmpty()) stack.push(i);
            else{
                // 스택이 비어있지 않고, stack 의 top 이 arr[i]보다 크면,
                // 수신 받을 수 있으므로 해당 타워를 스택에서 꺼내고,
                // 수신 받은 타워의 번호를 기록함.
                while (!stack.isEmpty() && arr[stack.peek()] < arr[i]){
                    tmp[stack.pop()] = i + 1;
                }
                // 그리고 스택에 해당 타워를 넣어줌.
                stack.push(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int a : tmp) {
            sb.append(a).append(" ");
        }
        return sb.toString();
    }
}
