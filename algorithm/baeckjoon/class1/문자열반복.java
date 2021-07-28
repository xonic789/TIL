package algorithm.baeckjoon.class1;

import java.util.Scanner;

public class 문자열반복 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] strings = new String[n];
        int[] ints = new int[n];
        sc.nextLine();
        for (int i = 0; i < n; i++){
            String[] tmp = sc.nextLine().split(" ");
            ints[i] = tmp[0].charAt(0) - '0';
            strings[i] = tmp[1];
        }

        for (int i = 0; i < n; i++){
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < strings[i].length(); j++){
                for (int k = 0; k < ints[i]; k++){
                    sb.append(strings[i].charAt(j));
                }
            }
            System.out.println(sb.toString());
        }
    }
}
