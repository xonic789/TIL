package algorithm.inflearn.datastructure;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 응급실 {

    public int solution(int n, int m, int[] arr){
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++){
            queue.offer(arr[i]);
        }

        for (int a : queue){
            System.out.println(a);
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        System.out.println(new 응급실().solution(n,m,arr));
    }
}
