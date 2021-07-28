package algorithm.baeckjoon.class1;

import java.util.Scanner;

public class 평균 {

    public double solution(int[] arr, int n){
        double answer = 0;
        double max = Integer.MIN_VALUE;
        for (int tmp : arr){
            if (max < tmp){
                max = tmp;
            }
        }

        for (int i = 0; i < n; i++){
            answer += arr[i] / max * 100;
        }


        return answer / n;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(new 평균().solution(arr,n));
    }
}
