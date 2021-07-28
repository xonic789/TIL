package algorithm.inflearn.tree;

import java.util.Scanner;

public class 바둑이승차 {
    int max = Integer.MIN_VALUE;




    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(new 바둑이승차().solution(c,n,arr));


    }

    private int solution(int c, int n, int[] arr) {
        DFS(arr,0,c,n,0);

        return max;
    }

    public void DFS(int[] arr,int sum, int c, int n, int L){
        if (c >= sum && max < sum){
            max = sum;
        }
        if (L == n){
            return;
        }

        DFS(arr, sum+arr[L],c,n,L + 1);
        DFS(arr, sum,c,n,L + 1);

    }
}
