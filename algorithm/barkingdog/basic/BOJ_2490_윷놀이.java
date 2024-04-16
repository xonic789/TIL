package algorithm.barkingdog.basic;

import java.util.Scanner;

public class BOJ_2490_윷놀이 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String res = "DCBAE";
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            int cnt = 0;
            for (int j = 0; j < 4; j++) {
                cnt += sc.nextInt();
            }
            sb.append(res.charAt(cnt) + "\n");
        }
        System.out.println(sb);
    }
}
