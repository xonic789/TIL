package algorithm.barkingdog.basic;

import java.util.Scanner;

public class BOJ_2576_홀수 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int min = Integer.MAX_VALUE;
        int sum = 0;

        for (int i = 0; i < 7; i++){
            int tmp = sc.nextInt();
            // 홀수는 무조건 2^0에 1이 들어가기 때문에
            // 14 : 1110
            // & 연산 0001
            // 11 : 1011
            // 엔드 연산 처리 해준다면 홀수면 1, 짝수면 0이 나온다.
            if ((tmp & 1) == 1) {
                sum += tmp;
                if (tmp < min) min = tmp;
            }
        }
        if (sum == 0) {
            System.out.println(-1);
            return;
        }
        System.out.println(sum + "\n" + min);
    }
}
