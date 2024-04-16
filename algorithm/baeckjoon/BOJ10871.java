package algorithm.baeckjoon;

import java.util.Scanner;

public class BOJ10871 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int X = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++){
            int tmp = sc.nextInt();
            if (X > tmp) sb.append(tmp + " ");
        }

        System.out.println(sb);

    }
}
