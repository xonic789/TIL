package algorithm.inflearn.tree;

import java.util.*;


/*
6 9
1 3
1 4
2 1
2 5
3 4
4 5
4 6
6 2
6 5

 */
public class 그래프최단거리_BFS {
    static List<List<Integer>> graph;
    static int m,n;
    static boolean[] check;
    static int[] loc;
    static int[] dis;

    /**
     * 레벨 탐색
     * @param v
     */
    static void BfsLevel(int v){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);
        check[v] = true;
        int L = 0;
        while(!queue.isEmpty()){
            int size = queue.size();

            for (int i = 0; i < size; i++){
                int currentV = queue.poll();
                List<Integer> children = graph.get(currentV);
                for (int nv : children){
                    if (!check[nv]){
                        queue.offer(nv);
                        check[nv] = true;
                    }
                }
                loc[currentV] = L;
            }
            L++;
        }
    }

    public static void reset(){
        boolean[] tmp = new boolean[n + 1];
        check = tmp;
    }

    static void BfsDis(int v){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);
        check[v] = true;
        dis[v] = 0;
        while (!queue.isEmpty()){
            int size = queue.size();

            for (int i = 0; i < size; i++){
                int cv = queue.poll();
                for (int nv : graph.get(cv)){
                    if (!check[nv]){
                        queue.offer(nv);
                        check[nv] = true;
                        dis[nv] = dis[cv] + 1;
                    }
                }
            }
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        graph = new ArrayList<>();
        check = new boolean[n + 1];
        loc = new int[n + 1];
        dis = new int[n + 1];
        for (int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
        }

        BfsLevel(1);
        for (int i = 2; i < loc.length; i++){
            System.out.println(i + " : " + loc[i]);
        }

        reset();

        BfsDis(1);
        for (int i = 2; i < loc.length; i++){
            System.out.println(i + " : " + dis[i]);
        }
    }
}
