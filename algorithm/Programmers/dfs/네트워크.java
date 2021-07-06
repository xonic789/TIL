package algorithm.Programmers.dfs;

public class 네트워크 {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] check = new boolean[n];
        for (int i = 0; i < n; i++){
            if (!check[i]){
                DFS(computers,i,check);
                answer++;
            }
        }

        return answer;
    }

    void DFS(int[][] computers, int v, boolean[] check){
        check[v] = true;
        int n = computers.length;
        for (int i = v; i < v + 1; i++){
            for (int j = 0; j < n; j++){
                if (i != j && computers[i][j] == 1 && !check[j]){
                    DFS(computers,j,check);
                }
            }
        }
    }
}
