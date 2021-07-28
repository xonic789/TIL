package algorithm.inflearn.tree;

import java.util.Scanner;

public class 최대점수구하기 {

    int max = Integer.MIN_VALUE;

    public int solution(int[] scores, int[] times, int n, int m){
        DFS(scores, times, n, m, 0, 0, 0);


        return max;
    }

    private void DFS(int[] scores, int[] times, int n, int m, int sumScore, int sumTime,int L) {
        if (max < sumScore && m >= sumTime){
            max = sumScore;
        }
        if (L == n){
            return;
        }

        DFS(scores,times,n,m,sumScore + scores[L], sumTime + times[L], L  + 1);
        DFS(scores,times,n,m,sumScore, sumTime, L  + 1);

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] scores = new int[n];
        int[] times = new int[n];
        for (int i = 0; i < n; i++){
            scores[i] = sc.nextInt();
            times[i] = sc.nextInt();
        }

        System.out.println(new 최대점수구하기().solution(scores,times,n,m));
    }
}
