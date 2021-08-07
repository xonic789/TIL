package algorithm.baeckjoon;

import java.util.Scanner;

public class BOJ2577 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String result = String.valueOf(sc.nextInt() * sc.nextInt() * sc.nextInt());
        for (int i = 0; i <= 9; i++){
            int cnt = 0;
            for (char ch : result.toCharArray()){
                if (i == ch - '0') cnt++;
            }
            System.out.println(cnt);
        }
    }
}
