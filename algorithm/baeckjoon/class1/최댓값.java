package algorithm.baeckjoon.class1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 최댓값 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int max = Integer.MIN_VALUE;
        int index = 0;
        for (int i = 0; i < 9; i++){
            int tmp = sc.nextInt();
            if (max < tmp){
                max = tmp;
                index = i + 1;
            }
        }
        System.out.println(max);
        System.out.println(index);

    }
}
