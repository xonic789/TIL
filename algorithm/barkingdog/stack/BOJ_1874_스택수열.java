package algorithm.barkingdog.stack;

import java.io.*;
import java.util.*;

public class BOJ_1874_스택수열 {
    public static void main(String[] args) throws IOException {
        Stack<Integer> stack = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        //4 3 6 8 7 5 2 1
        //1 2 3 4 5 6 7 8
        List<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            list.add(Integer.parseInt(st.nextToken()));
        }

        List<String> result = new ArrayList<>(n);


        int idx = 0;
        for (int i = 1; i <= n; i++){
           stack.push(i);
           result.add("+");

           while (!stack.isEmpty() && stack.peek() == list.get(idx)){
               idx++;
               stack.pop();
               result.add("-");
           }
        }

        if (!stack.isEmpty()) bw.write("NO");
        else {
            for (String s : result) {
                bw.write(s);
            }
        }


        bw.flush();

    }
}
