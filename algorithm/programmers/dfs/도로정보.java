package algorithm.programmers.dfs;

public class 도로정보 {
    int answer = 0;

    public int solution(int N, int[][] road, int K) {
        int[][] graph = new int[N+1][N+1];


        for (int i = 0; i < road.length; i++){
            int a = road[i][0];
            int b = road[i][1];
            int c = road[i][2];

            graph[a][b] = c;
            graph[b][a] = c;
        }



        DFS(graph,1, N, K, 0);


        return answer;
    }

    public void DFS(int[][] graph, int v, int N, int K, int time){


        if (time <= K){
            answer++;
        }

        for (int i = v; i <= N; i++){
            if (graph[v][i] != 0){
                DFS(graph, i, N, K, time + graph[v][i]);
            }
        }


    }


    public static void main(String[] args) {
        int[][] road = {{1, 2, 1}, {2, 3, 3}, {5, 2, 2}, {1, 4, 2}, {5, 3, 1}, {5, 4, 2}};

        new 도로정보().solution(5,road,3);
    }
}
