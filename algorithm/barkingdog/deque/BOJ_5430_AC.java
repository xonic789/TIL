package algorithm.barkingdog.deque;

import java.io.*;
import java.util.*;
import java.util.Deque;

public class BOJ_5430_AC {

    public static final char R = 'R';
    public static final char D = 'D';


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        while (T-- != 0){
            String cmd = br.readLine();
            Deque<Integer> deque = new ArrayDeque<>();
            String n = br.readLine();
            String arr = br.readLine();
            convertStrToDeque(deque, arr);

            // R 이 나올 때마다 reverse not 연산 해준다.
            boolean reverse = false;
            boolean errorFlag = false;
            for (char e : cmd.toCharArray()){
                if (e == R) reverse = !reverse;
                if (e == D) {
                    if (deque.isEmpty()) {
                        errorFlag = true;
                        break;
                    }
                    if (reverse) deque.pollLast();
                    else deque.pollFirst();
                }
            }
            if (!errorFlag){
                bw.write(resultLine(deque, reverse).toString());
            }else {
                bw.write("error");
            }
            bw.write("\n");
        }
        bw.flush();
    }

    public static void convertStrToDeque(Deque<Integer> deque, String arr) {
        StringBuilder num = new StringBuilder();
        for (int i = 1; i + 1 < arr.length(); i++){
            char ch = arr.charAt(i);
            if (ch != ','){
                num.append(ch);
            }else {
                deque.add(Integer.parseInt(num.toString()));
                num = new StringBuilder();
            }

        }
        if (num.length() != 0){
            deque.add(Integer.parseInt(num.toString()));
        }
    }

    public static StringBuilder resultLine(Deque<Integer> deque, boolean reverse) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        // 굳이 reverse 할 필요 없이 뒤에서 부터 꺼내거나 앞에서 부터 꺼낸다
        while (!deque.isEmpty()) {
            if (reverse){
                sb.append(deque.pollLast());
            }else {
                sb.append(deque.pollFirst());
            }
            if (deque.size() != 0){
                sb.append(",");
            }
        }
        sb.append("]");
        return sb;
    }

}
