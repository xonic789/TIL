package algorithm.baeckjoon.class1;

import java.util.Scanner;

public class 상수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr = sc.nextLine().split(" ");
        for (int i = 0; i < arr.length; i++){
            arr[i] = new StringBuffer(arr[i]).reverse().toString();
        }
        if (Integer.parseInt(arr[0]) > Integer.parseInt(arr[1])){
            System.out.println(Integer.parseInt(arr[0]));
        }else {
            System.out.println(Integer.parseInt(arr[1]));
        }

    }
}
