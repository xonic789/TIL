package algorithm.barkingdog.array;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_3273_두수의합 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] tmp = new int[2000001];
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
            tmp[arr[i]] = 1;
        }
        int x = sc.nextInt();
        int answer = 0;
        for (int i = 0; i < n; i++){
            int a = x - arr[i];
            if (a < 0) continue;
            if (tmp[a] == 1) {
                answer++;
            }
        }
        // 또는 이분탐색!
        System.out.println(answer / 2);
    }
}
