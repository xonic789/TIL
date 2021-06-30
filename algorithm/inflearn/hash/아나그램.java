package algorithm.inflearn.hash;

import java.util.Scanner;

public class 아나그램 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();

        int sumA = 0;
        int sumB = 0;

        for (int i = 0; i < a.length(); i++){
            sumA += a.charAt(i);
        }
        for (int i = 0; i < b.length(); i++){
            sumB += b.charAt(i);
        }

        String answer = "";

        if (sumA == sumB){
            answer = "YES";
        }else {
            answer = "NO";
        }

        System.out.println(answer);
    }
}
