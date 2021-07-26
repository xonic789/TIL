package algorithm.baeckjoon.class1;

import java.util.Scanner;

public class 음계 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[8];
        String answer = "";
        for (int i = 0; i < 8; i++){
            arr[i] = sc.nextInt();
        }
        int tmp = 0;
        if (arr[0] == 1){
            tmp = 1;
            for (int i = 0; i < 8; i++){
                if (arr[i] == tmp){
                    answer = "ascending";
                }else {
                    System.out.println("mixed");
                    return;
                }
                tmp++;
            }
        }else if (arr[0] == 8){
            tmp = 8;
            for (int i = 0; i < 8; i++){
                if (arr[i] == tmp){
                    answer = "descending";
                }else {
                    System.out.println("mixed");
                    return;
                }
                tmp--;
            }
        }else {
            System.out.println("mixed");
            return;
        }
        System.out.println(answer);
    }
}
