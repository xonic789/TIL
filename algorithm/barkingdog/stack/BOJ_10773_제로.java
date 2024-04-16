package algorithm.barkingdog.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_10773_제로 {

    public static void main(String[] args) throws IOException {
        Stack<Integer> stack = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int nn = Integer.parseInt(st.nextToken());
            if (nn != 0){
                stack.push(nn);
            }else stack.pop();
        }
        int sum = stack.stream().mapToInt(num -> num).sum();
        System.out.println(sum);
    }
}
