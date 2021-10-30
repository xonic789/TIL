package algorithm.barkingdog.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_1926_그림 {

    private int n;
    private int m;
    private int cnt;
    private int max;
    private boolean[][] isVisits;
    // 상하좌우
    private int[] dx = {-1, 1, 0, 0};
    private int[] dy = {0, 0, -1, 1};
    private int[][] graph;

    public BOJ_1926_그림() {
        graph = new int[n][m];
    }

    public static void main(String[] args) throws IOException {
        BOJ_1926_그림 main = new BOJ_1926_그림();
        Scanner sc = new Scanner(System.in);
        int n = main.n = sc.nextInt();
        int m = main.m = sc.nextInt();
        int[][] graph = main.graph = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                graph[i][j] = sc.nextInt();
            }
        }
        for (int e : main.solution(n, m)) {
            System.out.println(e);
        }
    }

    public int[] solution(int n, int m) {
        isVisits = new boolean[n][m];
        int[] answer = new int[2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!isVisits[i][j] && graph[i][j] == 1) {
                    cnt++;
                    isVisits[i][j] = true;
                    Integer[] location = new Integer[2];
                    location[0] = i;
                    location[1] = j;
                    BFS(location, n, m);
                }
            }
        }
        answer[0] = cnt;
        answer[1] = max;
        return answer;
    }

    public void BFS(Integer[] location, int n, int m) {
        Queue<Integer[]> queue = new LinkedList<>();
        int size = 1;
        queue.offer(location);
        while (!queue.isEmpty()) {
            Integer[] poll = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = poll[0] + dx[i];
                int ny = poll[1] + dy[i];
                if (nx >= n || ny >= m || nx < 0 || ny < 0) {
                    continue;
                }
                if (!isVisits[nx][ny] && graph[nx][ny] == 1) {
                    isVisits[nx][ny] = true;
                    size++;
                    Integer[] tmp = new Integer[2];
                    tmp[0] = nx;
                    tmp[1] = ny;
                    queue.offer(tmp);
                }
            }
        }
        if (size > max) max = size;
    }
}
