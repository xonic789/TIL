package algorithm.baeckjoon.class1;

import java.util.Scanner;

public class 숫자의개수 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tmp = 1;

        for (int i = 0; i < 3; i++){
            tmp *= sc.nextInt();
        }

        String str = String.valueOf(tmp);
        int[] answer = new int[10];
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < str.length(); j++){
                if (i == str.charAt(j) - '0'){
                    answer[i]++;
                }
            }
        }

        for (int e : answer){
            System.out.println(e);
        }
    }

}
