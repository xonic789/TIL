package algorithm.programmers.bfs;

import java.util.*;

public class 목적지최단거리 {
    public void BFS(int[][] maps,List<Integer> current, int m, int n){
        //남동북서
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.offer(current);

        while (!queue.isEmpty()){
            List<Integer> loc = queue.poll();
            int x = loc.get(0);
            int y = loc.get(1);

            for (int i = 0; i < 4; i++){

                // 캐릭터의 열 행
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= m || ny >= n){
                    continue;
                }
                if (maps[nx][ny] == 0){
                    continue;
                }
                if (maps[nx][ny] == 1){
                    List<Integer> move = new ArrayList<>();
                    maps[nx][ny] = maps[x][y] + 1;
                    move.add(nx);
                    move.add(ny);
                    queue.offer(move);

                }

            }
        }
    }

    public int solution(int[][] maps) {
        int answer = 0;
        List<Integer> current = new ArrayList<>();
        current.add(0);
        current.add(0);
        int m = maps.length;
        int n = maps[0].length;
        BFS(maps,current,m,n);
        answer = maps[m - 1][n - 1];
        if (answer == 1){
            answer = -1;
        }


        return answer;
    }
    public static void main(String[] args) {
        목적지최단거리 solution = new 목적지최단거리();
        int[][] maps = {{1, 0, 1, 1, 1},{1, 0, 1, 0, 1},{1, 0, 1, 1, 1},{1, 1, 1, 0, 1},{0, 0, 0, 0, 1}};

        System.out.println(solution.solution(maps));
    }
}
