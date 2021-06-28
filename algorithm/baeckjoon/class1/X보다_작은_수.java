package algorithm.baeckjoon.class1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class X보다_작은_수 {

    public static List<Integer> solution(int[] arr, int n, int x){
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < n; i++){
            if (arr[i] < x){
                answer.add(arr[i]);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        for (int a : solution(arr,n,x)){
            System.out.print(a + " ");
        }
    }
}
