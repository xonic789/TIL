package algorithm.baeckjoon;

import java.util.*;

public class DFS와BFS {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int v = sc.nextInt();
        boolean[][] graph = new boolean[n + 1][n + 1];
        for (int i = 0; i < m; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            graph[x][y] = graph[y][x] = true;
        }

        boolean[] check = reset(n);
        DFS(graph,v,check);
        System.out.println();
        check = reset(n);
        BFS(graph,v,check);

    }

    private static void BFS(boolean[][] graph, int v, boolean[] check) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(v);
        check[v] = true;
        while (!queue.isEmpty()){
            int root = queue.poll();
            System.out.print(root + " ");
            for (int i = 1; i < graph[root].length; i++){
                if (graph[root][i] && graph[i][root] && !check[i]){
                    queue.offer(i);
                    check[i] = true;
                }
            }

        }




    }

    static boolean[] reset(int n){
        return new boolean[n + 1];
    }

    static void DFS(boolean[][] graph,int v, boolean[] check){

        check[v] = true;
        System.out.print(v + " ");

        for (int i = 1; i < graph[v].length; i++){
            if (graph[v][i] && graph[i][v]) {
                if(!check[i]) DFS(graph,i,check);
            }
        }

    }

}
