package algorithm.barkingdog.basic;

import java.util.Scanner;

public class BOJ_1267_핸드폰요금 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int y = 0;
        int m = 0;
        for (int i = 0; i < n; i++){
            y += ((arr[i] / 30) + 1) * 10;
            m += ((arr[i] / 60) + 1) * 15;
        }
        if (y > m) System.out.print("M "+ m);
        else if (y < m) System.out.print("Y " + y);
        else System.out.print("Y " + "M " + y);

    }
}
// 10 20 30
// 15 15 30