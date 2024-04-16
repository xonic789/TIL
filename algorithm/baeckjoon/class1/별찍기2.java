package algorithm.baeckjoon.class1;

import java.util.Scanner;

public class 별찍기2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int tmp = n;

        for (int i = 1; i <= n; i++){
            for (int j = tmp - 1; j > 0; j--){
                System.out.print(" ");
            }
            for (int k = 0; k < i; k++){
                System.out.print("*");
            }
            System.out.println();
            tmp--;
        }
    }
}
