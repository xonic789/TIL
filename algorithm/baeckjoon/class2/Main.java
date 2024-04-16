package algorithm.baeckjoon.class2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int w = sc.nextInt();
        int h = sc.nextInt();

        int nx = x > w - x ? w - x : x;
        int ny = y > h - y ? h - y : y;

        int answer = nx < ny ? nx : ny;
        System.out.println(answer);
    }
}
