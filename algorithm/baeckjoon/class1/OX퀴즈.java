package algorithm.baeckjoon.class1;

import java.util.Scanner;

public class OX퀴즈 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] arr = new String[n];
        int[] answer = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextLine();
        }

        for (int i = 0; i < n; i++){
            int score = 0;
            int tmp = 0;
            for (int j = 0; j < arr[i].length(); j++){
                if (arr[i].charAt(j) == 'O'){
                    tmp++;
                }else {
                    tmp = 0;
                }
                score += tmp;
            }
            answer[i] = score;
        }

        for (int a : answer){
            System.out.println(a);
        }
    }
}
