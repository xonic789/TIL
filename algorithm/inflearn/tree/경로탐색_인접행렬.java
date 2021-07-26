package algorithm.inflearn.tree;

import java.util.Scanner;

public class 경로탐색_인접행렬 {
    static int answer = 0, n,m;
    static int[][] graph;
    static boolean[] check;

    /**
     * 5 9
     * 1 2
     * 1 3
     * 1 4
     * 2 1
     * 2 3
     * 2 5
     * 3 4
     * 4 2
     * 4 5
     *
     */

    static void DFS(int v){
        check[v] = true;
        if (v == n) answer++;

        for (int i = 1; i < graph[v].length; i++){
            if(graph[v][i] == 1 && !check[i]){
                DFS(i);
                check[i] = false;
            }
        }
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        check = new boolean[n + 1];
        graph = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            graph[x][y] =  1;
        }
        DFS(1);
        System.out.println(answer);
    }
}
