package algorithm.barkingdog.array;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1475_방번호 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String N = sc.nextLine();
        int[] arr = new int[10];
        for (char ch : N.toCharArray()){
            int num = ch - '0';
            if (num == 6 || num == 9){
                if (arr[6] < arr[9]){
                    arr[6]++;
                }else {
                    arr[9]++;
                }
            }else {
                arr[num]++;
            }
        }
        System.out.println(Arrays.stream(arr).max().getAsInt());

    }
}
