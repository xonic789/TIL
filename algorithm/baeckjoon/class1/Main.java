package algorithm.baeckjoon.class1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String str = sc.nextLine();
        int answer = 0;
        for (int i = 0; i < str.length(); i++){
            answer += str.charAt(i) - '0';
        }
        System.out.println(answer);
    }
}
