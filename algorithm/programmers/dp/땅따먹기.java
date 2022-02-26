package algorithm.programmers.dp;

import java.util.Arrays;
import java.util.Comparator;

public class 땅따먹기 {

    // 먼저, 0행을 돌면서 자기 자신을 제외한 나머지 값들에 원래 있던 값과 더한 값을 비교해서 넣음.
    int solution(int[][] land) {
        int answer = 0;
        int x = land.length;
        int[][] dp = new int[x][4];
        System.arraycopy(land[0], 0, dp[0], 0, 4);
        for (int i = 1; i < x; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    if (j == k) continue;
                    dp[i][j] = Math.max(dp[i][j], land[i][j] + dp[i - 1][k]);
                }
            }
        }
        return Arrays.stream(dp[x - 1]).max().getAsInt();
    }

    public static void main(String[] args) {
        int[][] land = {{1, 2, 3, 5}, {5, 6, 7, 8}, {4, 3, 2, 1}};

        System.out.println(new 땅따먹기().solution(land));
    }
}
