package algorithm.barkingdog.basic;

import java.util.Scanner;

public class BOJ_10093_숫자 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int end = sc.nextInt();
        int cnt = 0;
        StringBuilder answer = new StringBuilder();
        for (int i = start + 1; i < end; i++){
            cnt++;
            answer.append(i + " ");
        }

        System.out.println(cnt + "\n" + answer);
    }
}
