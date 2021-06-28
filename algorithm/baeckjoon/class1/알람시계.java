package algorithm.baeckjoon.class1;

import java.util.Scanner;

public class 알람시계 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int time = sc.nextInt() * 60;
        time += sc.nextInt();

        if (time - 45 < 0){
            time = time + 1440 - 45;
        }else {
            time -= 45;
        }
        System.out.println(time / 60 + " " + time % 60);

    }
}
