package algorithm.programmers.dfs;

public class 카카오프렌즈_컬러링북 {

    int tmpCnt;
    boolean[][] check;

    public int[] solution(int m, int n, int[][] picture){
        int[] answer = new int[2];
        check = new boolean[m][n];
        int cnt = 0;
        int bigCnt = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (picture[i][j] != 0 && !check[i][j]){
                    DFS(picture,i,j);
                    if (tmpCnt > bigCnt){
                        bigCnt = tmpCnt;
                    }
                    cnt++;
                    tmpCnt = 0;
                }
            }
        }

        answer[0] = cnt;
        answer[1] = bigCnt;


        return answer;
    }

    public void DFS(int[][] picture, int x, int y){
        if(check[x][y]) return;

        check[x][y] = true;
        tmpCnt++;
        // 동서남북
        // 행 렬
        int[] disX = {0, 0, 1, -1};
        int[] disY = {1, -1, 0, 0};

        for (int i = 0; i < 4; i++){
            int nx = x + disX[i];
            int ny = y + disY[i];
            if (nx < 0 || ny < 0 || nx >= picture.length || ny >= picture[0].length){
                continue;
            }
            if (picture[nx][ny] == picture[x][y] && !check[nx][ny]){
                DFS(picture,nx,ny);
            }

        }
    }

    public static void main(String[] args) {
        int m = 6;
        int n = 4;
        int[][] picture = {
                {1, 1, 1, 0},
                {1, 2, 2, 0},
                {1, 0, 0, 1},
                {0, 0, 0, 1},
                {0, 0, 0, 3},
                {0, 0, 0, 3}
        };
        System.out.println(new 카카오프렌즈_컬러링북().solution(m,n,picture)[0]);
    }
}
