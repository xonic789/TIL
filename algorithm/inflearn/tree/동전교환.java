package algorithm.inflearn.tree;

import java.util.LinkedList;
import java.util.Queue;
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

        return BFS(arr,n,m);
    }

    public int BFS(int[] arr,int n, int m){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(m);
        int L = 0;
        while (!queue.isEmpty()){
            int len = queue.size();
            for (int i = 0; i < len; i++){
                int coin = queue.poll();
                for (int j = 0; j < n; j++){
                    int tmp = coin - arr[j];
                    if (tmp == 0) return L + 1;
                    if (tmp > 0){
                        queue.offer(tmp);
                    }
                }
            }
            L++;
        }
        return -1;
    }
}
