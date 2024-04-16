package algorithm.baeckjoon.class1;

import java.util.Scanner;

public class 검증수 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];
        for (int i = 0; i < 5; i++){
            arr[i] = sc.nextInt();
        }
        int answer = 0;
        for (int i = 0; i < 5; i++){
            int tmp = arr[i];
            answer += tmp * tmp;
        }

        System.out.println(answer % 10);
    }
}
