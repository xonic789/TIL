package algorithm.barkingdog.basic;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2587_대표값2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];

        for (int i = 0; i < 5; i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        System.out.println((int)Arrays.stream(arr).average().getAsDouble());
        System.out.println(arr[2]);

    }
}
