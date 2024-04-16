package algorithm.barkingdog.basic;

import java.util.Scanner;

public class BOJ_10804_카드역배치 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] cards = new int[20];
        for (int i = 0; i < 20; i++){
            cards[i] = i + 1;
        }

        for (int i = 0; i < 10; i++){
            int lt = sc.nextInt() - 1;
            int rt = sc.nextInt() - 1;
            while (lt < rt){
                swap(cards, lt++, rt--);
            }
        }
        for (int e : cards){
            System.out.print(e + " ");
        }
    }

    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
