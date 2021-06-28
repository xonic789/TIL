package algorithm.baeckjoon.class1;

import dataStructure.Set;

import java.util.Scanner;

public class 나머지 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];

        for (int i = 0; i < 10; i++){
            arr[i] = sc.nextInt() % 42;
        }

        Set set = new Set(arr);
        System.out.println(set.getNum());
    }
}
