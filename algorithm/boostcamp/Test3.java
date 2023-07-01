import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Test3 {
    public static final int LAND = 1;
    public static final int SEA = 2;
    public static final int LAKE = 0;
    int rows;
    int columns;
    int[][] map;
    // 동 서 남 북
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};

    public int[] solution(int rows, int columns, int[][] lands) {
        int[] answer = {-1, -1};
        this.rows = rows;
        this.columns = columns;
        map = new int[rows][columns];

        // 섬 기록
        for (int[] land : lands) {
            int x = land[0] - 1;
            int y = land[1] - 1;
            map[x][y] = LAND;
        }
        bfsSEA();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (map[i][j] == LAKE) {
                    int area = bfsLAKE(i, j);
                    list.add(area);
                }
            }
        }
        int max = list.stream().mapToInt(x -> x).max().orElse(-1);
        int min = list.stream().mapToInt(x -> x).min().orElse(-1);

        answer[0] = min;
        answer[1] = max;
        return answer;
    }


    public int bfsLAKE(int a, int b) {
        int area = 0;
        Queue<POJO> queue = new LinkedList<>();
        boolean[][] isVisit = new boolean[rows][columns];

        isVisit[a][b] = true;
        queue.offer(new POJO(a, b));
        map[a][b] = LAKE;
        area++;
        while(!queue.isEmpty()) {
            int qSize = queue.size();
            for (int i = 0; i < qSize; i++) {
                POJO e = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = e.x + dx[j];
                    int ny = e.y + dy[j];
                    if (nx >= rows || ny >= columns || nx < 0 || ny < 0) continue;
                    if (!isVisit[nx][ny] && map[nx][ny] == LAKE) {
                        isVisit[nx][ny] = true;
                        queue.offer(new POJO(nx, ny));
                        area++;
                    }
                }
            }
        }
        return area;
    }

    public void bfsSEA() {
        Queue<POJO> queue = new LinkedList<>();
        boolean[][] isVisit = new boolean[rows][columns];

        isVisit[0][0] = true;
        queue.offer(new POJO(0, 0));
        map[0][0] = SEA;
        while(!queue.isEmpty()) {
            int qSize = queue.size();
            for (int i = 0; i < qSize; i++) {
                POJO e = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = e.x + dx[j];
                    int ny = e.y + dy[j];
                    if (nx >= rows || ny >= columns || nx < 0 || ny < 0) continue;
                    if (!isVisit[nx][ny] && map[nx][ny] != LAND) {
                        isVisit[nx][ny] = true;
                        map[nx][ny] = SEA;
                        queue.offer(new POJO(nx, ny));
                    }
                }
            }
        }
    }

    public static class POJO {
        public int x;
        public int y;

        public POJO(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        int[][] arr = {
            {2, 2},
            {2, 3},
            {2, 4},
            {3, 2},
            {3, 5},
            {4, 3},
            {4, 4}
        };
        System.out.println(Arrays.toString(new Test3().solution(5, 6, arr)));
    }

}
