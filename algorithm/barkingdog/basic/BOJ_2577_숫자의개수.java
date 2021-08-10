package algorithm.barkingdog.basic;

import java.util.Scanner;

public class BOJ_2577_숫자의개수 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputs = String.valueOf(sc.nextInt() * sc.nextInt() * sc.nextInt());
        int[] answer = new int[10];
        for (char input : inputs.toCharArray()){
            int tmp = input - '0';
            answer[tmp]++;
        }

        for (int a : answer){
            System.out.println(a);
        }
    }
}
