package algorithm.inflearn.tree;

import java.util.Scanner;

public class 동전교환 {

    int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int m = sc.nextInt();

        System.out.println(new 동전교환().solution(arr,n,m));
    }

    private int solution(int[] arr, int n, int m) {
        DFS(arr,n,m,0,0);

        return min;
    }

    public void DFS(int[] arr, int n, int m, int sum, int L){
        if (sum == m) {

        }
        if (L == n){
            return;
        }


    }
}
